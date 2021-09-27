import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListLocationsComponent } from './components/list-locations/list-locations.component';
import { AddLocationComponent } from './components/add-location/add-location.component';
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";

const routers: Routes = [
  {path: 'locations', component: ListLocationsComponent},
  {path: 'addlocation', component: AddLocationComponent},
  {path: 'editlocation/:id', component: AddLocationComponent},
  {path: '', redirectTo: '/locations', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListLocationsComponent,
    AddLocationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routers)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
