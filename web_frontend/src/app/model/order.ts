export class Order {
    brand: string;
    model: string;
    productionYear: string;
    vin: string;
    registrationNumber: string;
    description: string;
    parts: string;

    constructor(){
      this.brand = "";
      this.model = "";
      this.productionYear = "";
      this.vin = "";
      this.registrationNumber = "";
      this.description = "";
      this.parts = "";
    }
  }