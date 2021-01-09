import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CourseIndexComponent} from './course-index/course-index.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: CourseIndexComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CourseRoutingModule { }
