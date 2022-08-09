import { NgModule } from '@angular/core';
import { RouterModule, Route } from '@angular/router';
import { SaveOrderComponent } from './save-order/save-order.component';
import { SearchOrderComponent } from './search-order/search-order.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CheckOrderComponent } from './check-order/check-order.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { ScheduleOrderComponent } from './schedule-order/schedule-order.component';
import { DispatchOrderComponent } from './dispatch-order/dispatch-order.component';
import { OrderSummaryComponent } from './order-summary/order-summary.component';

const routes: Route[] = [
  {path: '', redirectTo:'/home', pathMatch:'full'},
  {path: 'home', component:HomeComponent},
  {path: 'place_order', component:SaveOrderComponent},
  {path: 'view_orders', component:SearchOrderComponent},
  {path: 'check_status', component:CheckOrderComponent},

  {path: 'admin_panel', component:AdminHomeComponent},
  {path: 'schedule_orders', component:ScheduleOrderComponent},
  {path: 'dispatch_orders', component:DispatchOrderComponent},
  {path: 'order_summary', component:OrderSummaryComponent},
  
  {path: '**', component:PageNotFoundComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
