import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams,AlertController } from 'ionic-angular';
import { HomePage } from '../home/home';


@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  username: string = '';
  password: string = '';

  strUsername : string = "ionic";
  strPassword : string = "123456";


  constructor(public navCtrl: NavController, public navParams: NavParams,private alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }


doLogin(){

	if(this.username === '' || this.password === ''){
		let alert = this.alertCtrl.create({
			title: 'Error Login!',
			subTitle: 'UserName our Password incorreto.',
			buttons:['OK']
		});
		alert.present();
		return;
	}

	if((this.username === this.strUsername) && (this.password === this.strPassword)){
		this.navCtrl.push(HomePage);
	}

	
}
}
