import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { EmployeeComponent } from './employees/employee.component';
import { LkrFormatterPipe } from './shared/lkr-formatter.pipe';
import { ProgressBarComponent } from './shared/progress-bar/progress-bar.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { CreateEmployeeGuard } from './employees/create-employee.guard';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LkrFormatterPipe,
    ProgressBarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'employees', component: EmployeeComponent },
      // { path: 'employees/:id', component: EmployeeComponent },
      { path: 'employees/:id', component: EmployeeComponent, canActivate: [CreateEmployeeGuard] },
      { path: 'home', component: HomeComponent },
      { path: '', redirectTo: 'home', pathMatch: 'full' },
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

