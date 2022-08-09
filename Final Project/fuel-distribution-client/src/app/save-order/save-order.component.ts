import { Component, OnInit } from '@angular/core';
import { AllocatedStock } from '../allocated-stock';
import { AllocationService } from '../allocation.service';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-save-order',
  templateUrl: './save-order.component.html',
  styleUrls: ['./save-order.component.css']
})
export class SaveOrderComponent implements OnInit {

  order:Order = new Order("","",0,"","");
  allocated_stock:AllocatedStock = new AllocatedStock("",0,"");
  message:any;
  hidden:any ='hidden';
  msg_type:any = '';
  savedOrder:any;

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
   
  }

public saveOrder(){
  let response2 = this.orderService.saveOrder(this.order);
  response2.subscribe((data) => {
    this.savedOrder = data,
    this.message = `Reference Number ${this.savedOrder.id} order submitted successfully.`,
    this.hidden='', 
    this.msg_type='success'
  });
}

}
