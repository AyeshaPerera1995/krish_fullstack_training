import { OrderUpdateDto } from '../dto/OrderUpdate.dto';
import { Order } from '../schemas/Order.schema';
import { OrdersService } from '../service/orders.service';
export declare class OrdersController {
    private orderService;
    constructor(orderService: OrdersService);
    getAllOrders(): Promise<Order[]>;
    updateOrderStatus(id: string, orderUpdateDto: OrderUpdateDto): string;
}
