import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SaveOrderComponent } from './save-order/save-order.component';
import { SearchOrderComponent } from './search-order/search-order.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { OrderService } from './order.service';
import { CheckOrderComponent } from './check-order/check-order.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AllocationService } from './allocation.service';
import { ScheduleOrderComponent } from './schedule-order/schedule-order.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { ScheduleService } from './schedule.service';
import { DispatchService } from './dispatch.service';

@NgModule({
  declarations: [
    AppComponent,
    SaveOrderComponent,
    SearchOrderComponent,
    HomeComponent,
    PageNotFoundComponent,
    CheckOrderComponent,
    AdminHomeComponent,
    ScheduleOrderComponent,
    DispatchOrderComponent,
    OrderSummaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [OrderService, AllocationService, ScheduleService, DispatchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
