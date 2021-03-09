import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { DeliveryProfileService } from 'src/app/utility/services/Delivery/delivery-profile.service';
import { DialogBodyComponent } from '../dialog-body/dialog-body.component';

@Component({
  selector: 'app-order-delivered',
  templateUrl: './order-delivered.component.html',
  styleUrls: ['./order-delivered.component.scss']
})

export class OrderDeliveredComponent implements OnInit {
  orderdetails:any;
  starRating:number=0;
  deliveryId:any

  constructor(private matDialog: MatDialog,private Order:DeliveryProfileService,private _router:Router) { 
    this.deliveryId=sessionStorage.getItem("id");
    if(this.deliveryId!=null)
    {
      if(sessionStorage.getItem("isUser")==='false')
      {
        this.getDetails();
      }
      else
      {
        this._router.navigate(['**']);
      }  
    }
    else
    {
      this._router.navigate(['deliveryLogin']); 
    }
  }

  ngOnInit(): void {}

   /*Get the delivered Order data with restaurant Info*/
   getDetails(){
    this.Order.getOrders(this.deliveryId).subscribe((res)=>{
      this.orderdetails=res;
      this.orderdetails.forEach((order:any) => {
          this.Order.getRestaurant(order.rid).subscribe((res)=>{
        order["restaurant"]=res;
        });
       
      })
    })
  }

  /*Dialogue Box for More Information About Order Delivered*/
  openDialog(deliveryAddress:any,RestaurantAddress:any,dratings:any) {
   
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data={
      deliveryAddress,RestaurantAddress,dratings
    }
    this.matDialog.open(DialogBodyComponent, dialogConfig);
  }

}
