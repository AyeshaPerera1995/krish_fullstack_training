import { OrderUpdateDto } from '../dto/OrderUpdate.dto';
import { OrderRepository } from '../repository/Order.repository';
import { Order } from '../schemas/Order.schema';
export declare class OrdersService {
    private orderRepository;
    constructor(orderRepository: OrderRepository);
    getAllOrders(): Promise<Order[]>;
    getOrderById(id: string): Promise<Order & import("mongoose").Document<any, any, any> & {
        _id: import("mongoose").Types.ObjectId;
    }>;
    updateOrderStatus(orderUpdateDto: OrderUpdateDto): Promise<void>;
}
