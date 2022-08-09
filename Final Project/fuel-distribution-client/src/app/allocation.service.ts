import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AllocatedStock } from './allocated-stock';

@Injectable({
  providedIn: 'root'
})
export class AllocationService {

  constructor(private http: HttpClient) { }

  public saveAllocatedStock(allocated_stock:AllocatedStock){
    let response = this.http.post("http://localhost:9191/services/allocations",allocated_stock, {responseType:'text' as 'json'});   
    return response;
  }

  public getTotalAllocatedStock(fuel_type:string){
    return this.http.get("http://localhost:9191/services/allocations/total_allocated_stock/"+fuel_type, {responseType:'text' as 'json'});
  }

  public getMainStock(fuel_type:string){
    return this.http.get("http://localhost:9191/services/allocations/main_stock/"+fuel_type, {responseType:'text' as 'json'});
  }

  public getUsableStock(fuel_type:string){
    return this.http.get("http://localhost:9191/services/allocations/usable_stock/"+fuel_type);
  }

}
