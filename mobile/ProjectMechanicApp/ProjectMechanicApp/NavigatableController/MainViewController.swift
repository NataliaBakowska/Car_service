//
//  CustomViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 27.11.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import Foundation
import UIKit

class MainViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        showBackButton()
        self.navigationController?.navigationBar.tintColor = Colors.orange

    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent // .default
    }
    
    func hiddenBackButton(){
        extendedLayoutIncludesOpaqueBars = true
        self.navigationController?.navigationBar.backIndicatorTransitionMaskImage = nil
        self.navigationController?.navigationBar.tintColor = UIColor.clear
        self.navigationController?.navigationBar.topItem?.title = ""
        self.navigationItem.hidesBackButton = true
    }
    
    func showBackButton(){
        extendedLayoutIncludesOpaqueBars = true
        self.navigationController?.navigationBar.backIndicatorTransitionMaskImage = UIImage(named: "back_button")
        self.navigationController?.navigationBar.tintColor = UIColor.black
        self.navigationController?.navigationBar.topItem?.title = ""
        self.navigationItem.hidesBackButton = false
    }
    
}

