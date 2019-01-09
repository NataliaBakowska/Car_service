//
//  NotificationsViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit
import UserNotifications

class NotificationsViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, NotificationsDelegate {
    
    

    @IBOutlet weak var tableView: UITableView!
    let center = UNUserNotificationCenter.current()
    var notificationsArray: [UNNotificationRequest] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        getNotifications()
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.separatorStyle = .none
        tableView.estimatedRowHeight = 44
        tableView.rowHeight = UITableViewAutomaticDimension
        self.tableView.reloadData()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        title = "HISTORIA NAPRAW"
        getNotifications()
        self.tableView.reloadData()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return notificationsArray.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: CellIdentifier.notification, for: indexPath) as! NotificationTableViewCell
        cell.titleNotificationLabel.text = notificationsArray[indexPath.row].content.subtitle
        cell.dateLabel.text = notificationsArray[indexPath.row].content.body
        cell.selectionStyle = UITableViewCellSelectionStyle.none
        cell.buttonTappedAction = {
            self.removeNotification(id: self.notificationsArray[indexPath.row].identifier)
            self.tableView.reloadData()
        }
        return cell
    }
    
    func refreshTableView() {
        getNotifications()
    }
    
    @IBAction func addNotificationButtonAction(_ sender: Any) {
        let dialog = AddNotificationDialog()
        self.present(dialog, animated: true)
    }
    
    private func getNotifications() {
            self.center.getPendingNotificationRequests { (notifications) in
            if self.notificationsArray.count != 0 {
                self.notificationsArray = []
            }
            print("Count: \(notifications.count)")
            for item in notifications {
                self.notificationsArray.append(item)
                print(item.content)
            }
            
        }
    }
    
    private func removeNotification(id: String) {
        center.getPendingNotificationRequests { (notifications) in
            print(notifications)
            for item in notifications {
                if(item.identifier.contains(id)) {
                    self.center.removePendingNotificationRequests(withIdentifiers: [item.identifier])
                }
            }
            self.getNotifications()
        }
    }
    
}
