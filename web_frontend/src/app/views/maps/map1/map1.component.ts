import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-map1',
  templateUrl: './map1.component.html',
  styleUrls: ['./map1.component.scss']
})
export class Map1Component implements OnInit {

  public customers: any = [];
  constructor(private http: HttpClient) {
    this.getListOfUsers();
  }

  ngOnInit() {
  }



  getListOfUsers() {
    this.http.get('http://192.168.43.178:8080/customer/all').subscribe(onFullFiled => {
      this.customers = onFullFiled;
      console.log(this.customers);
    }, onRejected => {

    });
  }
}
