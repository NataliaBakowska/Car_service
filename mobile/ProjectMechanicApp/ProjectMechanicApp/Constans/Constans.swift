//
//  Constans.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 27.11.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import Foundation
import UIKit

struct Colors {
    static let orange = #colorLiteral(red: 1, green: 0.5490196078, blue: 0.1019607843, alpha: 1)
    static let black = #colorLiteral(red: 0.1490196078, green: 0.1490196078, blue: 0.1490196078, alpha: 1)
    static let grey = #colorLiteral(red: 0.893655479, green: 0.8943349719, blue: 0.8937607408, alpha: 1)
}

struct CellIdentifier {
    static let history = "historyTableViewCell"
    static let currentRepair = "currentRepairTableViewCell"
    static let detailsHistory = "detailsHistoryTableViewCell"
    static let notification = "notificationIdentifier"
}

struct SegueIdentifier {
    static let details = "detailsIdentifier"
    static let login = "login"
}

struct Request {
    static let login = "http://192.168.43.178:8080/customer/login"
}
