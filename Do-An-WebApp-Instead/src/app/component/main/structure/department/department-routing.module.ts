import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DepartmentIndexComponent} from './department-index/department-index.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: DepartmentIndexComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartmentRoutingModule { }
