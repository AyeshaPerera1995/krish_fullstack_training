import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-search-order',
  templateUrl: './search-order.component.html',
  styleUrls: ['./search-order.component.css']
})
export class SearchOrderComponent implements OnInit {

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
