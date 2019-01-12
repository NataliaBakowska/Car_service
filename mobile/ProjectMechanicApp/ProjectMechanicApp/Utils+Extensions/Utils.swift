//
//  Utils.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 09.01.2019.
//  Copyright © 2019 Łukasz Michalski. All rights reserved.
//

import Foundation
class Utils: NSObject {
    
    static func randomString(length: Int) -> String {
        let letters : NSString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        let len = UInt32(letters.length)
        var randomString = ""
        for _ in 0 ..< length {
            let rand = arc4random_uniform(len)
            var nextChar = letters.character(at: Int(rand))
            randomString += NSString(characters: &nextChar, length: 1) as String
        }
        return randomString
    }
}
