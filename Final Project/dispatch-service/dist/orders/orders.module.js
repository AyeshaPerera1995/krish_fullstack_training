"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.OrdersModule = void 0;
const common_1 = require("@nestjs/common");
const mongoose_1 = require("@nestjs/mongoose");
const orders_controller_1 = require("./controller/orders.controller");
const orders_service_1 = require("./service/orders.service");
const Order_repository_1 = require("./repository/Order.repository");
const Order_schema_1 = require("./schemas/Order.schema");
const AllocatedStock_schema_1 = require("./schemas/AllocatedStock.schema");
const MainStock_schema_1 = require("./schemas/MainStock.schema");
let OrdersModule = class OrdersModule {
};
OrdersModule = __decorate([
    (0, common_1.Module)({
        imports: [mongoose_1.MongooseModule.forFeature([{ name: Order_schema_1.Order.name, schema: Order_schema_1.OrderSchema },
                { name: AllocatedStock_schema_1.Allocated_Stock.name, schema: AllocatedStock_schema_1.AllocatedStockSchema },
                { name: MainStock_schema_1.Main_Stock.name, schema: MainStock_schema_1.MainStockSchema }])],
        controllers: [orders_controller_1.OrdersController],
        providers: [orders_service_1.OrdersService, Order_repository_1.OrderRepository]
    })
], OrdersModule);
exports.OrdersModule = OrdersModule;
//# sourceMappingURL=orders.module.js.map