import { OrdersService } from './orders.service';
export declare class OrdersController {
    private orderService;
    constructor(orderService: OrdersService);
    getAllOrders(): Promise<import("./schemas/Order.schema").Order[]>;
}
