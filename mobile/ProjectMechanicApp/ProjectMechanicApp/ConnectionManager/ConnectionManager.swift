//
//  ConnectionManager.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 12.01.2019.
//  Copyright © 2019 Łukasz Michalski. All rights reserved.
//

import UIKit
import Alamofire

class ConnectionManager {
    
    
    func login(number: Int, password: String, completion: @escaping (Int) -> Void) {
        let data: [String:Any] = ["number": number, "password": password]
        Alamofire.request(Request.login, method: .post, parameters: data, encoding: JSONEncoding.default, headers: nil).response { (response) in
            if response.response?.statusCode == 403 {
                completion(403)
            } else if response.response?.statusCode == 200 {
                completion(200)
            } else { completion(403) }
        }
    }
}
