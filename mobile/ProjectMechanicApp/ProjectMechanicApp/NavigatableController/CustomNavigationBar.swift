//
//  CustomNavigationBar.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 27.11.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import Foundation
import UIKit

class CustomNavigationBar: UINavigationBar {
    
    override func sizeThatFits(_ size: CGSize) -> CGSize {
        return CGSize(width: UIScreen.main.bounds.width, height: 70)
    }
    
}
