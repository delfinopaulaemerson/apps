import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { RestProvider } from '../../providers/rest/rest';

/**
 * Generated class for the RestPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-rest',
  templateUrl: 'rest.html',
})
export class RestPage {

  countries : string[];
  errorMessage : string;

  constructor(public navCtrl: NavController,public rest: RestProvider) {

  }

 ionViewDidLoad() {
    this.getCountries();
  }

   getCountries() {
    this.rest.getCountries().subscribe(countries => this.countries = countries, error =>  this.errorMessage = <any>error);
  }

}
