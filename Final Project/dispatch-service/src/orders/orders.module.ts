import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { OrdersController } from './controller/orders.controller';
import { OrdersService } from './service/orders.service';
import { OrderRepository } from './repository/Order.repository';
import { Order, OrderSchema } from './schemas/Order.schema';
import { Allocated_Stock, AllocatedStockSchema } from './schemas/AllocatedStock.schema';
import { Main_Stock, MainStockSchema } from './schemas/MainStock.schema';

@Module({
  imports: [MongooseModule.forFeature([{name:Order.name, schema:OrderSchema}, 
          {name:Allocated_Stock.name, schema:AllocatedStockSchema}, 
          {name:Main_Stock.name, schema:MainStockSchema}])],
  controllers: [OrdersController],
  providers: [OrdersService, OrderRepository]
})
export class OrdersModule {}
