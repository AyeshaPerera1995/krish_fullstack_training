import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from './order';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient) { }

  public updateOrderDateAndStatus(id:string,date:any){
    console.log('status to schedule');
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);
    queryParams = queryParams.append("date",date);
    let response = this.http.get("http://localhost:9292/services/schedule/update",{params:queryParams});   
    return response;
  }

  public getScheduleOrders(){
    return this.http.get("http://localhost:9292/services/schedule");
  }

}
