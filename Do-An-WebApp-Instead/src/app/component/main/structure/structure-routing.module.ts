import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'courses', loadChildren: () => import('./course/course.module').then(m => m.CourseModule)},
  {path: 'units', loadChildren: () => import('./unit/unit.module').then(m => m.UnitModule)},
  {path: 'subjects', loadChildren: () => import('./subjects/subjects.module').then(m => m.SubjectsModule)},
  {path: 'departments', loadChildren: () => import('./department/department.module').then(m => m.DepartmentModule)}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StructureRoutingModule { }
