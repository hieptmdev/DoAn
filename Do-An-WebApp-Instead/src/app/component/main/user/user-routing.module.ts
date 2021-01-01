import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserIndexComponent} from './user-index/user-index.component';
import {UserFormComponent} from './user-form/user-form.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: UserIndexComponent},
      {path: 'add', component: UserFormComponent},
      {path: 'detail/:code', component: UserFormComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
