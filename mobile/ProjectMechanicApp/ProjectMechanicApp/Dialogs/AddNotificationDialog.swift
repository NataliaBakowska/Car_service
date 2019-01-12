//
//  AddNotificationDialog.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit
import SkyFloatingLabelTextField
import UserNotifications

protocol NotificationsDelegate {
    func refreshTableView()
}

class AddNotificationDialog: UIViewController {

    @IBOutlet weak var titleTextField: SkyFloatingLabelTextField!
    @IBOutlet weak var datePickerTextField: SkyFloatingLabelTextField!
    let center = UNUserNotificationCenter.current()
    var dateTimeinterval: TimeInterval = 0
    var delegate: NotificationsDelegate?
    
    init() {
        super.init(nibName: nil, bundle: nil)
        self.modalPresentationStyle = .overCurrentContext
        self.modalTransitionStyle = .crossDissolve
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        initNotificationSetupCheck()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        center.getPendingNotificationRequests { (notifications) in
            print("Count: \(notifications.count)")
            for item in notifications {
                print(item.content)
            }
        }
    }
    
    
    @IBAction func dp(_ sender: UITextField) {
        let datePickerView = UIDatePicker()
        datePickerView.datePickerMode = .date
        sender.inputView = datePickerView       	
        datePickerView.addTarget(self, action: #selector(handleDatePicker(sender:)), for: .valueChanged)
    }
    
    @objc func handleDatePicker(sender: UIDatePicker) {
        let dateFormatter = DateFormatter()
        dateTimeinterval = sender.date.timeIntervalSinceNow
        dateFormatter.dateFormat = "dd MMM yyyy"
        datePickerTextField.text = dateFormatter.string(from: sender.date)
    }

    @IBAction func buttonAction(_ sender: Any) {
        guard let titleString = titleTextField.text, titleTextField.text != "" else {
            showToast(controller: self, message: "Należy podać tytuł przypomnienia", seconds: 3.0)
            return
        }
        guard let dateString = datePickerTextField.text, datePickerTextField.text != "" else {
            showToast(controller: self, message: "Należy wybrać date przypomnienia", seconds: 3.0)
            return
        }
        
        let notification = UNMutableNotificationContent()
        notification.title = "CarMechanic: Przypomnienie!"
        notification.subtitle =  titleString
        notification.body = "Data: \(dateString)"
        let date = Date(timeIntervalSinceNow: dateTimeinterval)
        let triggerDate = Calendar.current.dateComponents([.year, .month, .day, .hour, .minute, .second], from: date)
        let trigger = UNCalendarNotificationTrigger(dateMatching: triggerDate, repeats: true)
        let trigger2 = UNTimeIntervalNotificationTrigger(timeInterval: 10, repeats: false)

        let carReviewId = Utils.randomString(length: 10)
        let request = UNNotificationRequest(identifier: carReviewId, content: notification, trigger: trigger2)
        UNUserNotificationCenter.current().add(request, withCompletionHandler: nil)
        self.dismiss(animated: true) {
            self.delegate?.refreshTableView()
        }
        
    }
    
    func initNotificationSetupCheck() {
        UNUserNotificationCenter.current().requestAuthorization(options: [.alert])
        { (success, error) in
            if success {
                print("Permission Granted")
            } else {
                print("There was a problem!")
            }
        }
    }
}
