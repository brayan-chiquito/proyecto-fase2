import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrendListComponent } from './trend-list/trend-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ConsultListComponent } from './consult-list/consult-list.component';
import { BarraLateralComponent } from './barra-lateral/barra-lateral.component';

@NgModule({
  declarations: [
    AppComponent,
    TrendListComponent,
    ConsultListComponent,
    BarraLateralComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
