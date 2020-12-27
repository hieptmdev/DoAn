import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainRoutingModule } from './main-routing.module';
import { StudentComponent } from './student/student.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserComponent } from './user/user.component';
import { ClassSubjectComponent } from './class-subject/class-subject.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SubjectComponent } from './subject/subject.component';
import { NavbarComponent } from './partials/navbar/navbar.component';
import { SidebarComponent } from './partials/sidebar/sidebar.component';
import { FooterComponent } from './partials/footer/footer.component';
import {MainComponent} from './main.component';

@NgModule({
  declarations: [
    MainComponent,
    StudentComponent,
    UserProfileComponent,
    UserComponent,
    ClassSubjectComponent,
    DashboardComponent,
    SubjectComponent,
    NavbarComponent,
    SidebarComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    MainRoutingModule
  ]
})
export class MainModule { }
