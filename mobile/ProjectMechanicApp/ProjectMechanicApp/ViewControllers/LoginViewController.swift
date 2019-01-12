//
//  ViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 27.11.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit
import SkyFloatingLabelTextField

class LoginViewController: MainViewController {

    @IBOutlet weak var numberLabel: SkyFloatingLabelTextField!
    @IBOutlet weak var passwordLabel: SkyFloatingLabelTextField!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        self.title = "CAR SERVICE"
    }
    
    override func shouldPerformSegue(withIdentifier identifier: String, sender: Any?) -> Bool {
        var status = true
        if identifier == SegueIdentifier.login {
            guard let number = numberLabel.text, number != "" else {
                showToast(controller: self, message: "Podaj numer", seconds: 3.0)
                return false
            }
            guard let password = passwordLabel.text, password != "" else {
                showToast(controller: self, message: "Podaj hasło", seconds: 3.0)
                return false
            }
            let request = ConnectionManager.init()
            
                request.login(number: Int(number)!, password: password) { response in
                    if response == 403 {
                        showToast(controller: self, message: "Błędny numer lub hasło", seconds: 3.0)
                        status = false
                    } else if response == 200 {
                        status =  true
                    }
                }
        }
        return status
    }

}

