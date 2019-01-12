//
//  RepairModel.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class RepairModel: NSObject {
    
    var id: Int?
    var startDate: Date?
    var endDate: Date?
    var costs: Double?
    var descriptionString: String?
    
    init(id: Int?, startDate: Date?, endDate: Date?, costs: Double?, descriptionString: String?){
        self.id = id
        self.startDate = startDate
        self.endDate = endDate
        self.costs = costs
        self.descriptionString = descriptionString
    }
}
