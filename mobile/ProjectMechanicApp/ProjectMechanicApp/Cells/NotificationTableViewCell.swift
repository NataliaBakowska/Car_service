//
//  NotificationTableViewCell.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 09.01.2019.
//  Copyright © 2019 Łukasz Michalski. All rights reserved.
//

import UIKit

class NotificationTableViewCell: UITableViewCell {

    @IBOutlet weak var titleNotificationLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    var buttonTappedAction : (() -> Void)? = nil
    @IBOutlet weak var removeButton: UIButton!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    @IBAction func removeAction(_ sender: UIButton) {
        if let removeAction = self.buttonTappedAction
        {
            removeAction()
        }
    }

}
