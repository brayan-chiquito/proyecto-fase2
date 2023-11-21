import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TrendListComponent } from './trend-list/trend-list.component';
import { ConsultListComponent } from './consult-list/consult-list.component';

const routes: Routes = [

  {path: 'trends', component: TrendListComponent},
  {path: '', redirectTo: 'trends', pathMatch: 'full'},
  {path: 'consult', component: ConsultListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
