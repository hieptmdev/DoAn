import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TeachFormComponent} from './teach-form/teach-form.component';
import {TeachIndexComponent} from './teach-index/teach-index.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: TeachIndexComponent},
      {path: 'add', component: TeachFormComponent},
      {path: 'detail/:code', component: TeachFormComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TeachRoutingModule { }
