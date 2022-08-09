import { Prop, Schema, SchemaFactory } from "@nestjs/mongoose";
import { Document } from "mongoose";


export type AllocatedStockDocument = Allocated_Stock & Document;

@Schema()
export class Allocated_Stock{

    @Prop()
    id:string
    @Prop()
    order_id:string
    @Prop()
    allocated_stock:number
    @Prop()
    fuel_type:string

}

export const AllocatedStockSchema = SchemaFactory.createForClass(Allocated_Stock);