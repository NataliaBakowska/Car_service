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
    @IBOutlet weak var desctiptionLabel: UILabel!
    var carModel: CarModel?
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

    }
    
    func loadData(car: CarModel!, indexPathRow: Int) {
        self.carModel = car
        self.carName.text = car.brand! + " " + car.model!
        self.time.text = car.repairs![indexPathRow].endDate?.toString()
        self.desctiptionLabel.text = "opis: " + car.repairs![indexPathRow].descriptionString!
    }

    @IBAction func moreInformationButtonAcrtion(_ sender: Any) {
//
//        let detailsVC = segue.destinationViewController as DetailsHistoryViewControlle
//        detailsVC.carModel = self.carModel
//        detailsVC.performSegue(withIdentifier: SegueIdentifier.details, sender: self)
    }
}
