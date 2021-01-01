import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StudentIndexComponent} from './student-index/student-index.component';
import {StudentFormComponent} from './student-form/student-form.component';
import {StudentScoreComponent} from './student-score/student-score.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: StudentIndexComponent},
      {path: 'add', component: StudentFormComponent},
      {path: 'detail/:code', component: StudentFormComponent},
      {path: 'detail/:code/score', component: StudentScoreComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
