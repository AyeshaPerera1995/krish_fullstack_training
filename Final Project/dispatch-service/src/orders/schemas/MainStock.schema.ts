import { Prop, Schema, SchemaFactory } from "@nestjs/mongoose";
import { Document } from "mongoose";


export type MainStockDocument = Main_Stock & Document;

@Schema()
export class Main_Stock{

    @Prop()
    id:string
    @Prop()
    fuel_type:string
    @Prop()
    available_stock:number


}

export const MainStockSchema = SchemaFactory.createForClass(Main_Stock);