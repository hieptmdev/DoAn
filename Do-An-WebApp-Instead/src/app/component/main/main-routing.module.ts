import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {SubjectComponent} from './subject/subject.component';

const routes: Routes = [
  {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
  {path: 'students', loadChildren: () => import('./student/student.module').then(m => m.StudentModule)},
  {path: 'users', loadChildren: () => import('./user/user.module').then(m => m.UserModule)},
  {path: 'class-subject', loadChildren: () => import('./class-subject/class-subject.module').then(m => m.ClassSubjectModule)},
  {path: 'subjects', loadChildren: () => import('./subject/subject.module').then(m => m.SubjectModule)},
  {path: 'teachers', loadChildren: () => import('./teach/teach.module').then(m => m.TeachModule)},
  {path: 'structure', loadChildren: () => import('./structure/structure.module').then(m => m.StructureModule)},
  {path: 'profile', component: UserProfileComponent},
  {path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
