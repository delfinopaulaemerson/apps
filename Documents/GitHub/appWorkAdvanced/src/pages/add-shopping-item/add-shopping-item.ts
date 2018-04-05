import { Component } from '@angular/core';
import { NavController, NavParams,AlertController } from 'ionic-angular';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';
import { ShoppingItemListPage } from '../shopping-item-list/shopping-item-list';


import { ShoppingItem } from '../../models/shopping-item/shopping-item.interface';


@IonicPage()
@Component({
  selector: 'page-add-shopping-item',
  templateUrl: 'add-shopping-item.html',
})
export class AddShoppingItemPage {

	// Creating a new Object 
  	shoppingItem = {} as ShoppingItem;

	 items: Observable<ShoppingItem[]>

  constructor(public navCtrl: NavController, public navParams: NavParams, private database: AngularFireDatabase,private alertCtrl: AlertController) {
    this.items = this.database.list('shopping-list');
  
  }

  addShoppingItem(shoppingItem: ShoppingItem) {

  	if(this.shoppingItem.itemName===undefined||this.shoppingItem.itemNumber===undefined){
  		let alert = this.alertCtrl.create({
			title: 'Erro!',
			subTitle: 'Itens obrigatório!',
			buttons:['OK']
		});
		alert.present();
		return;
  	}
 

    this.items.push({
      key: this.shoppingItem.key, 
      itemName: this.shoppingItem.itemName,
      itemNumber: Number(this.shoppingItem.itemNumber)
    });

    this.shoppingItem = {} as ShoppingItem;


    let alert = this.alertCtrl.create({
			title: 'Sucesso!',
			subTitle: 'Itens adicionado!',
			buttons:['OK']
		});
		alert.present();
		
    this.shoppingItem.key = '';
    this.shoppingItem.itemName = '';
    this.shoppingItem.itemNumber = '';
  }


  doEditShoppingList(){

  	this.navCtrl.push(ShoppingItemListPage);

  }

}
