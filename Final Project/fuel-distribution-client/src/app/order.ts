export class Order{

    constructor(
        public station_name:string,
        public fuel_type:string,
        public fuel_capasity:number,
        public status:string,
        public scheduled_date:string
    ){}

}