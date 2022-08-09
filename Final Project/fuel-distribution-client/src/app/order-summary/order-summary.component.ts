import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

  orders:any;

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
    this.getOrders()
  }

  getOrders(){
    let response = this.orderService.getOrders();
    console.log(response);
    response.subscribe((data) => this.orders = data);
  }


}
