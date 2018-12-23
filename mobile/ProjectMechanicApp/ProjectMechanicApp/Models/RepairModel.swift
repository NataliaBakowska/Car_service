//
//  RepairModel.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class RepairModel: NSObject{
    
    var id: Int?
    var car: CarModel?
    var startDate: Date?
    var endDate: Date?
    var costs: Double?
    
    init(id: Int?, car: CarModel?, startDate: Date?, endDate: Date?, costs: Double?){
        self.id = id
        self.car = car
        self.startDate = startDate
        self.endDate = endDate
        self.costs = costs
    }
}
