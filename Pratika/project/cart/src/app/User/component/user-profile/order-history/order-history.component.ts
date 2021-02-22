import { Component, ViewChild ,OnInit, AfterViewInit } from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

export interface UserData {
  foodname: string;
  orderid: number;
  restaurantid: number;
  deliveryid: number;
  price: number;
  categoryid: number
}

const ELEMENT_DATA: UserData[] = [
  {foodname: 'pizza',  orderid:1 , restaurantid: 1, deliveryid: 1, price: 100, categoryid: 11},
  {foodname: 'choclate',  orderid:2 , restaurantid: 2, deliveryid: 2, price: 101, categoryid: 12},
  {foodname: 'coffee',  orderid:3 , restaurantid: 3, deliveryid: 3, price: 103, categoryid: 11},
  
  
];

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})


export class OrderHistoryComponent implements AfterViewInit {

  displayedColumns: string[] = ['foodname','orderid' , 'restaurantid','deliveryid','price','categoryid'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
 
  constructor() { }

  ngAfterViewInit() {
    this.dataSource.sort=this.sort;
  }

  ngOnInit(): void {
  }

}
