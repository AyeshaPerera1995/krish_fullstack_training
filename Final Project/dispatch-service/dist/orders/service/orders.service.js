"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.OrdersService = void 0;
const common_1 = require("@nestjs/common");
const Order_repository_1 = require("../repository/Order.repository");
let OrdersService = class OrdersService {
    constructor(orderRepository) {
        this.orderRepository = orderRepository;
    }
    async getAllOrders() {
        return await this.orderRepository.findAll();
    }
    async getOrderById(id) {
        let order = this.orderRepository.findOrderById(id);
        if (!order) {
            throw new common_1.NotFoundException(`${id} is not exist!`);
        }
        return await order;
    }
    async updateOrderStatus(orderUpdateDto) {
        const { id, status } = orderUpdateDto;
        this.orderRepository.findByIdAndUpdate(id, status);
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
        this.orderRepository.findOneAndDelete(id);
    }
};
OrdersService = __decorate([
    (0, common_1.Injectable)(),
    __metadata("design:paramtypes", [Order_repository_1.OrderRepository])
], OrdersService);
exports.OrdersService = OrdersService;
//# sourceMappingURL=orders.service.js.map