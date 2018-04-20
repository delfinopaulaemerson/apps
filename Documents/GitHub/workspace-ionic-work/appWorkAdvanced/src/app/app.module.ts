import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { RestPage } from '../pages/rest/rest';
import { AddShoppingItemPage } from '../pages/add-shopping-item/add-shopping-item';
import { ShoppingItemListPage } from '../pages/shopping-item-list/shopping-item-list';


import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule, AngularFireDatabase } from 'angularfire2/database';
import { AngularFireAuthModule } from 'angularfire2/auth';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { RestProvider } from '../providers/rest/rest';
import { HttpClientModule } from '@angular/common/http';

import { GoogleMaps } from '@ionic-native/google-maps';
import { Geolocation } from '@ionic-native/geolocation';

export const firebaseConfig = {
   apiKey: "AIzaSyCQUp57w4QPu0a9G0mrVzvm3kFukCft0UQ",
    authDomain: "project1-62e83.firebaseapp.com",
    databaseURL: "https://project1-62e83.firebaseio.com",
    projectId: "project1-62e83",
    storageBucket: "project1-62e83.appspot.com",
    messagingSenderId: "819096340573"
};

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    ShoppingItemListPage,
    AddShoppingItemPage,
    LoginPage,
    RestPage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp),
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireDatabaseModule,
    AngularFireAuthModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    AddShoppingItemPage,
    ShoppingItemListPage,
    LoginPage,
    RestPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    AngularFireDatabase,
    GoogleMaps,
    Geolocation,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    RestProvider
  ]
})
export class AppModule {}
