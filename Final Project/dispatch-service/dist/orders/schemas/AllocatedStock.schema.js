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
exports.AllocatedStockSchema = exports.Allocated_Stock = void 0;
const mongoose_1 = require("@nestjs/mongoose");
let Allocated_Stock = class Allocated_Stock {
};
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", String)
], Allocated_Stock.prototype, "id", void 0);
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", String)
], Allocated_Stock.prototype, "order_id", void 0);
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", Number)
], Allocated_Stock.prototype, "allocated_stock", void 0);
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", String)
], Allocated_Stock.prototype, "fuel_type", void 0);
Allocated_Stock = __decorate([
    (0, mongoose_1.Schema)()
], Allocated_Stock);
exports.Allocated_Stock = Allocated_Stock;
exports.AllocatedStockSchema = mongoose_1.SchemaFactory.createForClass(Allocated_Stock);
//# sourceMappingURL=AllocatedStock.schema.js.map