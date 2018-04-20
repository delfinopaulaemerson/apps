//
//  CoordenadasViewController.swift
//  AppMapa
//
//  Created by Emerson Delfino on 19/04/2018.
//  Copyright © 2018 Emerson Delfino. All rights reserved.
//

import UIKit
import CoreLocation

class CoordenadasViewController: UIViewController {
    
    private var coordenadas : Coordenadas!
    
    @IBOutlet weak var enderecoTxt: UITextField!
    
    @IBOutlet weak var latitudeTxt: UITextField!
    
    @IBOutlet weak var longitudeTxt: UITextField!
    
    @IBOutlet weak var loading: UIActivityIndicatorView!
    
    @IBOutlet weak var buscarBtn: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        
    }


    //metodo responsavel pelo encapsulamento do
    //objeto Coordenadas
    @IBAction func exibirMapa(_ sender: Any) {
        var ok:Bool = true
        
        self.coordenadas = Coordenadas()
        
        if self.latitudeTxt.text == ""{
            self.alert("Erro", "Latitude é obrigatório!")
            ok = false
        }
        
        if self.longitudeTxt.text == ""{
            self.alert("Erro", "Longitude é obrigatório!")
            ok = false
        }
        
        if ok{
            //atribui o conteudo do textField para a variavel
            let strLatit = self.latitudeTxt.text!
            //atribui o conteudo do textField para a variavel
            let strLong = self.longitudeTxt.text!
            
            //faz o parse de string para Double
            self.coordenadas.latitude = Double(strLatit)
            //faz o parse de string para Double
            self.coordenadas.longitude = Double(strLong)
            
            //chama o metodo de exibicao para exibicao do formulario mapa
            self.exibirFormMapa(self.coordenadas)
        }
        
    }
    //metodo para navegacao de tela
    //com passagem de parametros
    public func exibirFormMapa(_ coordenadas : Coordenadas){
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        
        let mapa = storyboard.instantiateViewController(withIdentifier: "form-mapa") as! MapaViewController
        mapa.coordenadas = self.coordenadas
        
        _ = self.navigationController?.pushViewController(mapa,animated: true)
        
    }
    
    // metodo responsavel pela busca  latitude e longitude
    @IBAction func buscarCoordenadas(_ sender: Any) {
    
        var ok : Bool = true
        
        //inicia o efeito de loading
        self.loading.startAnimating()
        
        //desabilita o botao
        self.buscarBtn.isEnabled = false
        
        //criando uma variavel de instancia CLGeocoder
        let geocoder = CLGeocoder()
        
        
        if self.enderecoTxt.text == ""{
            self.alert("Erro", "Endereço é obrigatório!")
            ok = false
        }
        
        if ok == true{
            
            //exectudando o metodo geocodeAddressString
            //passando o endereco do formulario
            geocoder.geocodeAddressString(self.enderecoTxt.text!){(resultado, error) in
                if error == nil && (resultado?.count)! > 0{
                    //atribuindo ao placemark o primeiro item do array resultado
                    let placemark = resultado?[0]
                    
                    //atribuindo a cordenada placemark?.location!.coordinate
                    let cordenada = placemark?.location!.coordinate
                    
                    //atribuindo ao textView latitude cordenada?.latitude.description
                    self.latitudeTxt.text = cordenada?.latitude.description
                    
                    //atribuindo ao textView longitude cordenada?.longitude.description
                    self.longitudeTxt.text = cordenada?.longitude.description
                    
                }
            }
            //para o loading no botao
            self.loading.stopAnimating()
            
            //habilita o botao
            self.buscarBtn.isEnabled = true
        }
    }
    
    //func responsavel pelos alert
    func alert(_ tilte:String,_ message:String){
        // create the alert
        let alert = UIAlertController(title: tilte, message: message, preferredStyle: UIAlertControllerStyle.alert)
        
        // add an action (button)
        alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        
        // show the alert
        self.present(alert, animated: true, completion: nil)
        
    }
    
    


}
