import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SubjectsIndexComponent} from './subjects-index/subjects-index.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: SubjectsIndexComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SubjectsRoutingModule { }
