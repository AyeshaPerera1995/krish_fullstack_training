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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.OrderRepository = void 0;
const common_1 = require("@nestjs/common");
const mongoose_1 = require("@nestjs/mongoose");
const mongoose_2 = require("mongoose");
const AllocatedStock_schema_1 = require("../schemas/AllocatedStock.schema");
const MainStock_schema_1 = require("../schemas/MainStock.schema");
const Order_schema_1 = require("../schemas/Order.schema");
let OrderRepository = class OrderRepository {
    constructor(orderModel, allocatedstockModel, mainstockModel) {
        this.orderModel = orderModel;
        this.allocatedstockModel = allocatedstockModel;
        this.mainstockModel = mainstockModel;
    }
    async findAll() {
        return await this.orderModel.find();
    }
    async findOrderById(id) {
        return this.orderModel.findById(id);
    }
    findMainStockByType(type) {
        return this.mainstockModel.findOne({ fuel_type: type });
    }
    async findByIdAndUpdate(id, status) {
        await this.orderModel.findByIdAndUpdate({ _id: id }, { status: status });
        return "";
    }
    async findOneAndUpdate(fuel_type, updated_stock) {
        await this.mainstockModel.findOneAndUpdate({ fuel_type: fuel_type }, { available_stock: updated_stock });
        return "";
    }
    async findOneAndDelete(id) {
        await this.allocatedstockModel.findOneAndDelete({ order_id: id })
            .then(data => console.log("done"))
            .catch(err => console.log(err));
        return "";
    }
};
OrderRepository = __decorate([
    (0, common_1.Injectable)(),
    __param(0, (0, mongoose_1.InjectModel)(Order_schema_1.Order.name)),
    __param(1, (0, mongoose_1.InjectModel)(AllocatedStock_schema_1.Allocated_Stock.name)),
    __param(2, (0, mongoose_1.InjectModel)(MainStock_schema_1.Main_Stock.name)),
    __metadata("design:paramtypes", [mongoose_2.Model,
        mongoose_2.Model,
        mongoose_2.Model])
], OrderRepository);
exports.OrderRepository = OrderRepository;
//# sourceMappingURL=Order.repository.js.map