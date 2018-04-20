//
//  LoginViewController.swift
//  AppLogin
//
//  Created by Emerson Delfino on 17/04/2018.
//  Copyright © 2018 Emerson Delfino. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {

    @IBOutlet weak var userNameTxt: UITextField!
    
    @IBOutlet weak var passwordTxt: UITextField!
    
    var userName : String!
    
    var password : String!
    
    var login : Login?
    
    var service : LoginService!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder:aDecoder)
        self.service = LoginService()
    }
    
    @IBAction func signIn(_ sender: Any) {
        var ok : Bool! = true
        
        self.userName = userNameTxt?.text
       
        self.password = passwordTxt?.text
        
        //retorna o objeto consumido pela API
        self.login = self.service.returnObjectLogin()
        
        // valida os dados do login com os dados consumido pela API
        ok = self.service.validarLogin(userName,password,self.login!)
        
        //se houver alguma divergencia no login
        //emite um alert
        if ok == false{
            self.alert("Erro","UserName ou Password incorreto!")
            
        }
        
        if ok == true{
            //cria uma instancia UIStoryboard
            let storyboard = UIStoryboard(name: "Main", bundle: nil)
            //cria uma instancia UIStoryboard storyboard.instantiateViewController
            let home = storyboard.instantiateViewController(withIdentifier: "form-home") as! HomeViewController
            //executa o pushViewController com suas propriedades
            _ = self.navigationController?.pushViewController(home,animated: true)
        }
        
    }
    
    //func responsavel pelos alert
    private func alert(_ tilte:String,_ message:String){
        // create the alert
        let alert = UIAlertController(title: tilte, message: message, preferredStyle: UIAlertControllerStyle.alert)
        
        // add an action (button)
        alert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        
        // show the alert
        self.present(alert, animated: true, completion: nil)
    }

}
