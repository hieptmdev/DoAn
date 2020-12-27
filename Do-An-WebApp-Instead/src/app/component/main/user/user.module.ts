import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserIndexComponent } from './user-index/user-index.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserSearchComponent } from './user-search/user-search.component';


@NgModule({
  declarations: [
    UserIndexComponent,
    UserFormComponent,
    UserSearchComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule
  ]
})
export class UserModule { }
