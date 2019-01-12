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
        
        let annotation = MKPointAnnotation()
        annotation.coordinate = CLLocationCoordinate2D(latitude: 52.249714, longitude: 19.170164)
        map.addAnnotation(annotation)
        self.map.showAnnotations(self.map.annotations, animated: true)

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
