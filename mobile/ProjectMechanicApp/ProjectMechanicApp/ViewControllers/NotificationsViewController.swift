//
//  NotificationsViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class NotificationsViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func addNotificationButtonAction(_ sender: Any) {
        let dialog = AddNotificationDialog()
        self.present(dialog, animated: true)
    }
}
