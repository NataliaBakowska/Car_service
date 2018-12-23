//
//  ContactViewController.swift
//  ProjectMechanicApp
//
//  Created by Łukasz Michalski on 15.12.2018.
//  Copyright © 2018 Łukasz Michalski. All rights reserved.
//

import UIKit
import MapKit

class ContactViewController: UIViewController {

    @IBOutlet weak var map: MKMapView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

    }
    
    @IBAction func callAction(_ sender: Any) {
        if let url = URL(string: "tel://726081806"), UIApplication.shared.canOpenURL(url) {
            if #available(iOS 10, *) {
                UIApplication.shared.open(url)
            } else {
                UIApplication.shared.openURL(url)
            }
        }
    }
}
