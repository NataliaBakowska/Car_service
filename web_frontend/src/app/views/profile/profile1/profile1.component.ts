import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-profile1',
  templateUrl: './profile1.component.html',
  styleUrls: ['./profile1.component.scss']
})
export class Profile1Component implements OnInit {
  public cars: any = [];
  constructor(private http: HttpClient) {

    this.getCars();
  }

  ngOnInit() {
  }

  getCars() {
    this.http.get('http://192.168.43.178:8080/car/all').subscribe(onFullFiled => {
      this.cars = onFullFiled;
      console.log(this.cars);
    }, onRejected => {

    });
  }

}
