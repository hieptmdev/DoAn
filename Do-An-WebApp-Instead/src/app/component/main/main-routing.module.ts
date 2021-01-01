import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {StudentComponent} from './student/student.component';
import {UserComponent} from './user/user.component';
import {ClassSubjectComponent} from './class-subject/class-subject.component';
import {SubjectComponent} from './subject/subject.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'students', loadChildren: () => import('./student/student.module').then(m => m.StudentModule)},
  {path: 'users', loadChildren: () => import('./user/user.module').then(m => m.UserModule)},
  {path: 'class-subject', component: ClassSubjectComponent,
    loadChildren: () => import('./class-subject/class-subject.module').then(m => m.ClassSubjectModule)},
  {path: 'subject', component: SubjectComponent,
    loadChildren: () => import('./subject/subject.module').then(m => m.SubjectModule)},
  {path: 'profile', component: UserProfileComponent},
  {path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
