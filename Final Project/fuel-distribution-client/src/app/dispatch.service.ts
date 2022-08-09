import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class DispatchService {

  constructor(private http: HttpClient) { }

//   public saveOrder(order:Order){
//     console.log('order service');
//     let response = this.http.post("http://localhost:9090/services/orders",order);   
//     return response;
//   }

  public getAllScheduledOrders(){
    return this.http.get("http://localhost:3000/services/dispatch?status=Delivery Scheduled");
  }

  public updateOrderStatus(id:string){
    return this.http.get("http://localhost:3000/services/dispatch/"+id+"/status");
  }

}
