import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-basic-table',
  templateUrl: './basic-table.component.html',
  styleUrls: ['./basic-table.component.scss']
})
export class BasicTableComponent implements OnInit {

  public ordersArray: any = [];
  constructor(private http: HttpClient) {

    this.getListOfOrders();
  }

  ngOnInit() {
  }

  getListOfOrders() {
    this.http.get('http://192.168.43.178:8080/customer/all').subscribe(onFullFiled => {
     console.log(onFullFiled);
    }, onRejected => {

    });
  }

}
