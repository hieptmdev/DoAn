import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {LoginComponent} from './components/login/login.component';
import {ForgetPasswordComponent} from './components/forget-password/forget-password.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'forget-password', component: ForgetPasswordComponent},
  {path: 'home', loadChildren: () => import('./components/main/main.module').then(m => m.MainModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
