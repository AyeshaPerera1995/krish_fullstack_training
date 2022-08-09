import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  public saveOrder(order:Order){
    console.log('order service');
    let response = this.http.post("http://localhost:9090/services/orders",order);   
    return response;
  }

  public getOrders(){
    return this.http.get("http://localhost:9090/services/orders");
  }

  public checkOrderStatusById(id:string){
    return this.http.get("http://localhost:9090/services/orders/status/"+id, {responseType:'text' as 'json'});
  }

}
