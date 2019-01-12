import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../../../model/order';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Component({
  selector: 'app-dashboard1',
  templateUrl: './dashboard1.component.html',
  styleUrls: ['./dashboard1.component.scss']
})
export class Dashboard1Component implements OnInit {

  public description: string = "sdas";
  public parts: string = "";
  public brand: string = "";
  public model: string = "";
  public productionYear = "";
  public vin: string = "";

  public header = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
    'Access-Control-Allow-Methods': 'POST, GET',
    'Access-Control-Allow-Origin': 'localhost:4200'
  });

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
  }

  public addOrder( description, parts) {
    var dataToSend: Order = new Order();

    // dataToSend.brand = brand;
    // dataToSend.model = model;
    // dataToSend.productionYear = productionYear;
    // dataToSend.vin = vin;
    // dataToSend.registrationNumber = registrationNumber;
    // dataToSend.firstName = registrationNumber.firstName;
    // dataToSend.lastName = registrationNumber.lastName;
    dataToSend.description = description;
    dataToSend.parts = parts;

    var data = {
      'costs': 0,
      'description': description,
      'endDate': 'string',
      'id': 0,
      'startDate': 'string',
      'units': parts
    }

    const jsonData = JSON.stringify(data);
    this.http.post('http://192.168.43.178:8080/repair/save/3', jsonData, { headers: this.header }).subscribe(onfullFiled => {

    }, rejected => {

    });
  }

  public addUser(fristName, lastName, phone) {

    // var data = {
    //   'costs': 0,
    //   'description': description,
    //   'endDate': 'string',
    //   'id': 0,
    //   'startDate': 'string',
    //   'units': parts
    // }

    var data = {
      'firstName': fristName,
      'id': 0,
      'lastName': lastName,
      'telephoneNumber': phone
    }
    console.log(data);
    const jsonData = JSON.stringify(data);
    this.http.post('http://192.168.43.178:8080/customer/save', jsonData, { headers: this.header }).subscribe(onfullFiled => {

    }, rejected => {

    });
  }

  public addCar(brand, model, productionYear, vin, regiestrationNumber) {

    var data = {
      "brand": brand,
      "id": 0,
      "model": model,
      "productionYear": productionYear,
      "registrationNumber": regiestrationNumber,
      "vin": vin
    }

    const jsonData = JSON.stringify(data);
    this.http.post('http://192.168.43.178:8080/car/save/7', jsonData, { headers: this.header }).subscribe(onfullFiled => {

    }, rejected => {

    });

  }

}
