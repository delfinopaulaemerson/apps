//
//  LoginService.swift
//  AppLogin
//
//  Created by Emerson Delfino on 18/04/2018.
//  Copyright © 2018 Emerson Delfino. All rights reserved.
//

import Foundation
//classe de servico
class LoginService{
    
    static private var loginService : LoginService!
    
    private var login : Login!
    
    //implementacao para criacao de uma unica instancia do objeto
    static func sharedInstance() -> LoginService{
        
        if loginService == nil{
            loginService = LoginService()
        }
        
        return loginService
    }
    
    //metodo de consumo da API
    public func conumerApiLogin(){
        let url = URL(string: "http://echo.jsontest.com/userName/swift/password/123456")!
        
        //instanciando session
        let session = URLSession.shared
        
        //instanciando URLrequest
        let request = URLRequest(url: url)
        
        let task = session.dataTask(with: request as URLRequest, completionHandler: { data, response, error in
            
            //se o erro for igual a nil retorna
            guard error == nil else {
                return
            }
            
            //atribui a data
            guard let data = data else {
                return
            }
            
            do {
                //obtem o json
                if let json = try JSONSerialization.jsonObject(with: data, options: .mutableContainers) as? [String: Any] {
                    
                    //deserializa o json
                    self.login = Login()
                    self.login?.userName = (json)["userName"] as? String
                    self.login?.password = (json)["password"] as? String
                    
                }
                
            } catch let error {
                print(error.localizedDescription)
            }
            
        })
        
        task.resume()
    }
    
    //construtor
    public init() {
        self.conumerApiLogin()
    }
    
    //retorna o objeto consumido pela API
    public func returnObjectLogin()-> Login{
        return self.login
    }
    
    
    //metodo valida os parametros de entrada do login e consumo da API
    public func validarLogin(_ userName : String,_ password : String,_ login : Login) -> Bool{
        var ok : Bool! = true
        
        if userName == ""{
            ok = false
        }
        if password == ""{
            ok = false
        }
        if userName != login.userName{
            ok = false
        }
        if password != login.password{
            ok = false
        }
        
        return ok
        
    }
    
}
