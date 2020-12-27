import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './component/login/login.component';
import {ForgetPasswordComponent} from './component/forget-password/forget-password.component';
import {Page404Component} from './component/page404/page404.component';
import {Page500Component} from './component/page500/page500.component';
import {MainComponent} from './component/main/main.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'forget-password', component: ForgetPasswordComponent},
  {path: 'home', component: MainComponent, loadChildren: () => import('./component/main/main.module').then(m => m.MainModule)},
  {path: 'error', children: [
      {path: '404', component: Page404Component},
      {path: '500', component: Page500Component}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
