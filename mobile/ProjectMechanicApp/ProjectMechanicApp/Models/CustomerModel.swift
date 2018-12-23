//
//  CustomerModel.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 23.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit

class CustomerModel: NSObject{
    
    var id: Int?
    var cars: [CarModel]?
    var telephoneNumber: Int?
    var firstName: String?
    var lastName: String?
    var password: String?
    
    init(id: Int?, cars: [CarModel]?, telephoneNumber: Int?, firstName: String?, lastName: String?, password: String?){
        self.id = id
        self.cars = cars
        self.telephoneNumber = telephoneNumber
        self.firstName = firstName
        self.lastName = lastName
        self.password = password
    }
}
