import { Injectable } from "@nestjs/common";
import { InjectModel } from "@nestjs/mongoose";
import { Model } from "mongoose";
import { Allocated_Stock, AllocatedStockDocument } from "../schemas/AllocatedStock.schema";
import { Main_Stock, MainStockDocument } from "../schemas/MainStock.schema";
import { Order, OrderDocument } from "../schemas/Order.schema";

@Injectable()
export class OrderRepository{

    constructor(@InjectModel(Order.name) private orderModel: Model<OrderDocument>, 
        @InjectModel(Allocated_Stock.name) private allocatedstockModel: Model<AllocatedStockDocument>, 
        @InjectModel(Main_Stock.name) private mainstockModel: Model<MainStockDocument>){}


    async findAll():Promise<Order[]>{
        return await this.orderModel.find();
    }

    async findOrderById(id:string){
        return this.orderModel.findById(id);
    }

    findMainStockByType(type:string){
        return this.mainstockModel.findOne({fuel_type: type});
    }

    // update the status in order table
    async findByIdAndUpdate(id:string, status:string): Promise<String>{
        await this.orderModel.findByIdAndUpdate(
            { _id: id },
            { status: status },
            
          );
          return "";
    }

    // update available stock in main stock by fuel type
    async findOneAndUpdate(fuel_type:string, updated_stock:number): Promise<String>{
        await this.mainstockModel.findOneAndUpdate(
            { fuel_type: fuel_type },
            { available_stock: updated_stock },
            
          );
          return "";
    }

    // delete particular row from allocated stock table 
    async findOneAndDelete(id:string): Promise<String>{
        await this.allocatedstockModel.findOneAndDelete({order_id: id})
        .then(data => console.log("done"))
        .catch(err => console.log(err));
        
        return "";
           
    }


    




}