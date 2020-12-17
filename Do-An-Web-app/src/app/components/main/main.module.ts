import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { MainComponent } from './main.component';
import {HeaderComponent} from './share/header/header.component';
import {FooterComponent} from './share/footer/footer.component';
import {MenuComponent} from './share/menu/menu.component';
import {NgbAccordionModule, NgbDropdownModule, NgbPaginationModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {PerfectScrollbarModule} from 'ngx-perfect-scrollbar';
import { UserComponent } from './user/user.component';
import { StudentComponent } from './student/student.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { UserDetailComponent } from './user/user-detail/user-detail.component';
import {FormsModule} from '@angular/forms';
import {TableModule} from 'primeng/table';
import {MatIconModule} from '@angular/material/icon';
import { StudentFormComponent } from './student/student-form/student-form.component';
import { DropdownModule } from 'primeng/dropdown';
import { StudyScoreComponent } from './student/study-score/study-score.component';
import {PanelModule} from 'primeng/panel';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {CalendarModule} from 'primeng/calendar';
import {RadioButtonModule} from 'primeng/radiobutton';

@NgModule({
  declarations: [
    MainComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    UserComponent,
    StudentComponent,
    UserInfoComponent,
    UserDetailComponent,
    StudentFormComponent,
    StudyScoreComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule,
    NgbDropdownModule,
    NgbAccordionModule,
    PerfectScrollbarModule,
    NgbPaginationModule,
    FormsModule,
    NgbTooltipModule,
    TableModule,
    MatIconModule,
    DropdownModule,
    PanelModule,
    ScrollPanelModule,
    CalendarModule,
    RadioButtonModule
  ]
})
export class MainModule { }
