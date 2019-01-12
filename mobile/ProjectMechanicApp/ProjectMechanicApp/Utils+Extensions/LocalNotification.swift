//
//  LocalNotification.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 06.01.2019.
//  Copyright © 2019 Łukasz Michalski. All rights reserved.
//

import Foundation
import UIKit
import UserNotifications

class LocalNotification: NSObject, UNUserNotificationCenterDelegate {
    class func registerForLocalNotification(on application:UIApplication) {
        if (UIApplication.instancesRespond(to: #selector(UIApplication.registerUserNotificationSettings(_:)))) {
            let notificationCategory:UIMutableUserNotificationCategory = UIMutableUserNotificationCategory()
            notificationCategory.identifier = "NOTIFICATION_CATEGORY"
            DispatchQueue.main.async {
                application.registerUserNotificationSettings(UIUserNotificationSettings(types:[.sound, .alert, .badge], categories: nil))
            }
        }
    }
    
    class func dispatchLocalNotification(with title: String, body: String, at date:Date, id: String){
        if #available(iOS 10.0, *) {
            let center = UNUserNotificationCenter.current()
            let content = UNMutableNotificationContent()
            content.title = title
            content.body = body
            content.sound = UNNotificationSound.default()
            let comp = Calendar.current.dateComponents([.year, .month, .day, .hour, .minute, .second], from: date)
            let trigger = UNCalendarNotificationTrigger(dateMatching: comp, repeats: true)
            let request = UNNotificationRequest(identifier: id, content: content, trigger: trigger)
            center.add(request)
        } else {
            let notification = UILocalNotification()
            notification.fireDate = date
            notification.alertBody = body
            notification.soundName = UILocalNotificationDefaultSoundName
            notification.userInfo = ["id": id]
            UIApplication.shared.scheduleLocalNotification(notification)
        }
    }
    
    class func removePendingNotifications(with id: String){
        if #available(iOS 10.0, *) {
            let center = UNUserNotificationCenter.current()
            center.removePendingNotificationRequests(withIdentifiers: [id])
        } else {
            if let scheduledNotifications = UIApplication.shared.scheduledLocalNotifications{
                for notification:AnyObject in scheduledNotifications {
                    let scheduledNotification = notification as! UILocalNotification
                    if let type = scheduledNotification.userInfo?["id"] as? String {
                        if type == id {
                            UIApplication.shared.cancelLocalNotification(scheduledNotification)
                        }
                    }
                }
            }
            
        }
    }
}
