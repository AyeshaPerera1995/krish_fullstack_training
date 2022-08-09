import { Component, OnInit } from '@angular/core';
import { DispatchService } from '../dispatch.service';

@Component({
  selector: 'app-dispatch-order',
  templateUrl: './dispatch-order.component.html',
  styleUrls: ['./dispatch-order.component.css']
})
export class DispatchOrderComponent implements OnInit {

  schedule_orders:any;
  message:any;
  hidden:any ='hidden';
  msg_type:any = '';
  btn_color:any = 'btn-danger';    
  btn_text:any = 'Dispatch'; 

  constructor(private dispatchService:DispatchService) { }

  ngOnInit(): void {
    this.getScheduleOrders();
  }


  getScheduleOrders(){
    let response = this.dispatchService.getAllScheduledOrders();
    response.subscribe((data) => {this.schedule_orders = data});
  }

  updateOrderStatus(id:string){
    let response = this.dispatchService.updateOrderStatus(id);
    response.subscribe((data) => {
      this.schedule_orders = data, 
      this.message = `Reference Number ${id} order is dispatched successfully.`, 
      this.hidden='', 
      this.msg_type='success',
      // this.btn_color = 'btn-success'
      // this.btn_text = 'Sent';
      this.getScheduleOrders();
    
    });
  }


}
