import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ClassSubjectIndexComponent} from './class-subject-index/class-subject-index.component';
import {ClassSubjectFormComponent} from './class-subject-form/class-subject-form.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: ClassSubjectIndexComponent},
      {path: 'add', component: ClassSubjectFormComponent},
      {path: 'detail/:id', component: ClassSubjectFormComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClassSubjectRoutingModule { }
