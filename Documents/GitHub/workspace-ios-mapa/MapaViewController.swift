//
//  MapaViewController.swift
//  AppMapa
//
//  Created by Emerson Delfino on 19/04/2018.
//  Copyright © 2018 Emerson Delfino. All rights reserved.
//

import UIKit
import CoreLocation
import MapKit

class MapaViewController: UIViewController,MKMapViewDelegate{
    
    var coordenadas : Coordenadas!
    
    let locationManager = CLLocationManager()

    @IBOutlet weak var mapa: MKMapView!
    
    //ciclo de vida utilizado para inicializar
    //alguns componentes
    override func viewDidLoad() {
        super.viewDidLoad()
        self.locationManager.requestWhenInUseAuthorization()
        
        mapa.showsUserLocation = true
        
        mapa.delegate = self
        
        let botaoLocalizacao = MKUserTrackingBarButtonItem(mapView: self.mapa)
        
        self.navigationItem.rightBarButtonItem = botaoLocalizacao
    }

    //ciclo de vida responsavel pela visualizacao do mapa
    override func viewWillAppear(_ animated: Bool) {
        let latitude : Double = self.coordenadas.latitude!
        let longitude : Double = self.coordenadas.longitude!
        
        let info = Coordenadas()
        info.coordinate = CLLocationCoordinate2D(latitude: latitude, longitude: longitude)
        info.title = "GEOLOCATION"
        info.subtitle = "Emerson"
        
        self.mapa.addAnnotation(info)
    }


}

