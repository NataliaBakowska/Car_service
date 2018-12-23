//
//  HistoryTableViewCell.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 15.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class HistoryTableViewCell: UITableViewCell {

    @IBOutlet weak var carName: UILabel!
    @IBOutlet weak var time: UILabel!
    @IBOutlet weak var desctiption: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

    }
    
    func loadData() {
        print("bedzie")
    }

}
