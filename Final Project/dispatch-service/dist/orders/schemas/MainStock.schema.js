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
exports.MainStockSchema = exports.Main_Stock = void 0;
const mongoose_1 = require("@nestjs/mongoose");
let Main_Stock = class Main_Stock {
};
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", String)
], Main_Stock.prototype, "id", void 0);
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", String)
], Main_Stock.prototype, "fuel_type", void 0);
__decorate([
    (0, mongoose_1.Prop)(),
    __metadata("design:type", Number)
], Main_Stock.prototype, "available_stock", void 0);
Main_Stock = __decorate([
    (0, mongoose_1.Schema)()
], Main_Stock);
exports.Main_Stock = Main_Stock;
exports.MainStockSchema = mongoose_1.SchemaFactory.createForClass(Main_Stock);
//# sourceMappingURL=MainStock.schema.js.map