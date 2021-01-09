import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UnitRoutingModule } from './unit-routing.module';
import { UnitSearchComponent } from './unit-search/unit-search.component';
import { UnitFormComponent } from './unit-form/unit-form.component';
import { UnitIndexComponent } from './unit-index/unit-index.component';
import {TranslocoModule} from '@ngneat/transloco';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [UnitSearchComponent, UnitFormComponent, UnitIndexComponent],
  imports: [
    CommonModule,
    UnitRoutingModule,
    TranslocoModule,
    NgbPaginationModule,
    FormsModule
  ]
})
export class UnitModule { }
