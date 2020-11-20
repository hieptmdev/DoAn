import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from './main.component';
import {StudentComponent} from './student/student.component';
import {UserComponent} from './user/user.component';
import {UserInfoComponent} from './user-info/user-info.component';

const routes: Routes = [
  {path: '', component: MainComponent, children: [
      {path: '', redirectTo: 'students', pathMatch: 'prefix'},
      {path: 'students', component: StudentComponent},
      {path: 'users', component: UserComponent},
      {path: 'profile', component: UserInfoComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
