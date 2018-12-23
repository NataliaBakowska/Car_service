//
//  CarModel.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class CarModel: NSObject{
    
    var id: Int?
    var brand: String?
    var model: String?
    var productionYear: Int?
    var registrationNumber: String?
    var customer: CustomerModel?
    var repairs: [RepairModel]?
    
    init(id: Int?, brand: String?, model: String?, productionYear: Int?, registrationNumber: String?, customer: CustomerModel?, repairs: [RepairModel]?){
        self.id = id
        self.brand = brand
        self.model = model
        self.productionYear = productionYear
        self.registrationNumber = registrationNumber
        self.customer = customer
        self.repairs = repairs
    }
}
