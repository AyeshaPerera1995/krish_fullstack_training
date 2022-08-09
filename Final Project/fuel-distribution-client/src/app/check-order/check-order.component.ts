import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-check-order',
  templateUrl: './check-order.component.html',
  styleUrls: ['./check-order.component.css']
})
export class CheckOrderComponent implements OnInit {

  status:any;
  hidden:any ='hidden';
  ref_id:string="";

  constructor(private orderService:OrderService) { }

  ngOnInit(): void {
  }

  checkOrderStatusById(id:string){
    console.log(id);
    let response = this.orderService.checkOrderStatusById(id);
    response.subscribe((data) => {this.status = data, this.hidden = ''});
  }

}
