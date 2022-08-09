import { Module } from '@nestjs/common';
import { MongooseModule } from '@nestjs/mongoose';
import { MONGO_CONNECTION } from './app.properties';
import { OrdersModule } from './orders/orders.module';


@Module({
  imports: [OrdersModule, MongooseModule.forRoot(MONGO_CONNECTION)],
  controllers: []
})
export class AppModule {}
