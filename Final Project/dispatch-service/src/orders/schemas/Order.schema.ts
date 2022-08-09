import { Prop, Schema, SchemaFactory } from "@nestjs/mongoose";
import { Document } from "mongoose";


export type OrderDocument = Order & Document;

@Schema()
export class Order{

    @Prop()
    id:string
    @Prop()
    station_name:string
    @Prop()
    fuel_capasity:number
    @Prop()
    fuel_type:string
    @Prop()
    scheduled_date:string
    @Prop()
    status:string

}

export const OrderSchema = SchemaFactory.createForClass(Order);