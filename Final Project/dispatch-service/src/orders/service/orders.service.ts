import { Injectable, NotFoundException } from '@nestjs/common';
import { OrderUpdateDto } from '../dto/OrderUpdate.dto';
import { OrderRepository } from '../repository/Order.repository';
import { Order } from '../schemas/Order.schema';

@Injectable()
export class OrdersService {

    constructor(private orderRepository: OrderRepository){}

    async getAllOrders():Promise<Order[]>{
        return await this.orderRepository.findAll();
    }

    async getOrderById(id:string){
        let order = this.orderRepository.findOrderById(id);
        if(!order){
            throw new NotFoundException(`${id} is not exist!`);
        }
        return await order;
    }

    async updateOrderStatus(orderUpdateDto:OrderUpdateDto){
        // we called this as destruct 
        const {id, status} = orderUpdateDto;
        this.orderRepository.findByIdAndUpdate(id,status); 

        let order = await this.getOrderById(id);
        console.log(order);
        console.log(order.fuel_type);
        let main_stock = await this.orderRepository.findMainStockByType(order.fuel_type);
        console.log(main_stock);
        console.log(main_stock.available_stock);
        console.log(order.fuel_capasity);
        let updated_stock = (main_stock.available_stock - order.fuel_capasity);
        console.log(updated_stock);
        this.orderRepository.findOneAndUpdate(order.fuel_type, updated_stock);
        // console.log(id);
        this.orderRepository.findOneAndDelete(id);      

    }

}
