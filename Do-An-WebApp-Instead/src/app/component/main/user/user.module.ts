import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserIndexComponent } from './user-index/user-index.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserSearchComponent } from './user-search/user-search.component';
import {TranslocoModule} from '@ngneat/transloco';
import {FormsModule} from '@angular/forms';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    UserIndexComponent,
    UserFormComponent,
    UserSearchComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    TranslocoModule,
    FormsModule,
    NgbPaginationModule
  ]
})
export class UserModule { }
