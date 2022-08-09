import { Component, OnInit } from '@angular/core';
import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-schedule-order',
  templateUrl: './schedule-order.component.html',
  styleUrls: ['./schedule-order.component.css']
})
export class ScheduleOrderComponent implements OnInit {

  schedule_orders:any;
  date:any;
  message:any;
  hidden:any ='hidden';
  msg_type:any = ''

  constructor(private scheduleService:ScheduleService) { }

  ngOnInit(): void {
    this.getScheduleOrders();
  }

  getScheduleOrders(){
    let response = this.scheduleService.getScheduleOrders();
    response.subscribe((data) => {this.schedule_orders = data});
  }

  updateOrderDateAndStatus(id:string){
    console.log('in comp');
    console.log(this.date);
    console.log(id)
    let response = this.scheduleService.updateOrderDateAndStatus(id,this.date);
    response.subscribe((data) => {
      this.schedule_orders = data, 
      this.message = `Reference Number ${id} is scheduled to delivery successfully.`, 
      this.hidden='', 
      this.msg_type='success'
      this.getScheduleOrders();
    
    });

  }

}
