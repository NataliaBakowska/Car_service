//
//  DetailsHistoryTableViewCell.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 06.01.2019.
//  Copyright © 2019 Łukasz Michalski. All rights reserved.
//

import UIKit

class DetailsHistoryTableViewCell: UITableViewCell {

    @IBOutlet weak var carName: UILabel!
    @IBOutlet weak var time: UILabel!
    @IBOutlet weak var desctiptionLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func loadData(car: CarModel!, indexPathRow: Int) {
        self.carName.text = car.brand! + " " + car.model!
        self.time.text = car.repairs![indexPathRow].endDate?.toString()
        self.desctiptionLabel.text = "opis: " + car.repairs![indexPathRow].descriptionString!
        self.priceLabel.text = String(format: "Koszt: %.2f zł", car.repairs![indexPathRow].costs ?? 0.0)
    }

}
