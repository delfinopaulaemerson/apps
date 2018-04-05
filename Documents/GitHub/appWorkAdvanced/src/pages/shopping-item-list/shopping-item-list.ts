import { Component } from '@angular/core';
import { NavController, NavParams,IonicPage } from 'ionic-angular';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';


import { ShoppingItem } from '../../models/shopping-item/shopping-item.interface';

@IonicPage()
@Component({
  selector: 'page-shopping-item-list',
  templateUrl: 'shopping-item-list.html',
})
export class ShoppingItemListPage {

    // Creating a new Object 
    shoppingItem = {} as ShoppingItem;

	items: Observable<ShoppingItem[]>


  constructor(public navCtrl: NavController, public navParams: NavParams, private database: AngularFireDatabase) {
    this.items = this.database.list('/shopping-list').valueChanges();

  }



}
