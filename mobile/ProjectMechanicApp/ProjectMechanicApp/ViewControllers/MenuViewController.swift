//
//  MenuViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 02.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import Foundation
import UIKit

class MenuViewController: MainViewController {
    
    @IBOutlet weak var historyButton: UIButton!
    @IBOutlet weak var currentButton: UIButton!
    @IBOutlet weak var notificationsButton: UIButton!
    @IBOutlet weak var contactButton: UIButton!
    @IBOutlet var collectionButtons: [UIButton]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        initView()
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        self.title = "MENU"
    }
    
    func initView() {
        for button in collectionButtons {
            button.backgroundColor = .clear
            button.layer.borderWidth = 1
            button.layer.borderColor = Colors.black.cgColor
        }
    }
}
