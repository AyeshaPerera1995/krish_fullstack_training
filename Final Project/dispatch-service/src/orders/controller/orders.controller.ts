import { Body, Controller, Get, Param, Put, Query } from '@nestjs/common';
import { OrderUpdateDto } from '../dto/OrderUpdate.dto';
import { Order } from '../schemas/Order.schema';
import { OrdersService } from '../service/orders.service';

@Controller('services/dispatch')

export class OrdersController {
   
    constructor(private orderService:OrdersService){}

    @Get()
    async getAllOrders(): Promise<Order[]>{
        return await this.orderService.getAllOrders();
    }

    @Get('/:id/status')
    updateOrderStatus(@Param('id') id:string, @Body() orderUpdateDto: OrderUpdateDto): string{
        orderUpdateDto.id = id;
        orderUpdateDto.status = "Order Dispatched";
        this.orderService.updateOrderStatus(orderUpdateDto);
        return "";
    }

}
