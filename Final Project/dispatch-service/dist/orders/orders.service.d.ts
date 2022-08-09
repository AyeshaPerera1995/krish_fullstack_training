import { OrderRepository } from './repository/Order.repository';
import { Order } from './schemas/Order.schema';
export declare class OrdersService {
    private empRepository;
    constructor(empRepository: OrderRepository);
    getAllOrders(): Promise<Order[]>;
}
