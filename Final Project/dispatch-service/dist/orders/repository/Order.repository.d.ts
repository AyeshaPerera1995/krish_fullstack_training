/// <reference types="mongoose/types/aggregate" />
/// <reference types="mongoose/types/callback" />
/// <reference types="mongoose/types/collection" />
/// <reference types="mongoose/types/connection" />
/// <reference types="mongoose/types/cursor" />
/// <reference types="mongoose/types/document" />
/// <reference types="mongoose/types/error" />
/// <reference types="mongoose/types/expressions" />
/// <reference types="mongoose/types/helpers" />
/// <reference types="mongoose/types/middlewares" />
/// <reference types="mongoose/types/indexes" />
/// <reference types="mongoose/types/models" />
/// <reference types="mongoose/types/mongooseoptions" />
/// <reference types="mongoose/types/pipelinestage" />
/// <reference types="mongoose/types/populate" />
/// <reference types="mongoose/types/query" />
/// <reference types="mongoose/types/schemaoptions" />
/// <reference types="mongoose/types/schematypes" />
/// <reference types="mongoose/types/session" />
/// <reference types="mongoose/types/types" />
/// <reference types="mongoose/types/utility" />
/// <reference types="mongoose/types/validation" />
/// <reference types="mongoose/types/virtuals" />
/// <reference types="mongoose/types/inferschematype" />
import { Model } from "mongoose";
import { AllocatedStockDocument } from "../schemas/AllocatedStock.schema";
import { Main_Stock, MainStockDocument } from "../schemas/MainStock.schema";
import { Order, OrderDocument } from "../schemas/Order.schema";
export declare class OrderRepository {
    private orderModel;
    private allocatedstockModel;
    private mainstockModel;
    constructor(orderModel: Model<OrderDocument>, allocatedstockModel: Model<AllocatedStockDocument>, mainstockModel: Model<MainStockDocument>);
    findAll(): Promise<Order[]>;
    findOrderById(id: string): Promise<Order & import("mongoose").Document<any, any, any> & {
        _id: import("mongoose").Types.ObjectId;
    }>;
    findMainStockByType(type: string): import("mongoose").Query<Main_Stock & import("mongoose").Document<any, any, any> & {
        _id: import("mongoose").Types.ObjectId;
    }, Main_Stock & import("mongoose").Document<any, any, any> & {
        _id: import("mongoose").Types.ObjectId;
    }, {}, MainStockDocument>;
    findByIdAndUpdate(id: string, status: string): Promise<String>;
    findOneAndUpdate(fuel_type: string, updated_stock: number): Promise<String>;
    findOneAndDelete(id: string): Promise<String>;
}
