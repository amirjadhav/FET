import { Component, ViewChild ,OnInit, AfterViewInit } from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'

export interface UserData {
  foodname: string;
  orderid: number;
  restaurantid: number;
  deliveryid: number;
  price: number;
  categoryid: number
}

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})


export class OrderHistoryComponent implements AfterViewInit {
 

  userOrder: any =[];
  
  

  constructor(private _userorderService:UserProfileService) { 
     
    this._userorderService.getUserOrder().subscribe((res)=>{
        this.userOrder=res
     // console.log(this.userOrder);
    })

  }

  ngAfterViewInit() {
    
  }

  ngOnInit(): void {
  }

}
