import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UnitIndexComponent} from './unit-index/unit-index.component';

const routes: Routes = [
  {path: '', children: [
      {path: '', component: UnitIndexComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UnitRoutingModule { }
