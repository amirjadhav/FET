import { UserProfileService } from './../../../utility/services/user-profile/user-profile.service';
import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { CartService } from 'src/app/utility/services/cart/cart.service';
import {formatDate} from '@angular/common';
import { LOCALE_ID } from '@angular/core';
import { Inject } from '@angular/core';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartItems: any[] = [];
  length: number = 0;
  item_total: number[] = [];
  subtotal: number = 0;
  tax: number = 0;
  total: number = 0;
  public loading: boolean = false;
  showLoader: boolean = false;
  uid: number=0;
  orderid: number = 0;
  address:string='';
 

  keys(): Array<string> {
    return Object.keys(this.cartItems);
  }

  //delete item in cart
  deleteItem(id: any) {
    this._cartService.deleteItem(id).subscribe();
    location.reload();
  }

  //spinner after place order and change status of order
  orderProcessing() {
    this.showLoader = true;
    this.ngxShowLoader.show();
    setTimeout(() => {
      this.showLoader = false;
      this.ngxShowLoader.hide();
      location.reload();
    }, 5000);
    console.log("orderid" + this.orderid)
   let dateString = formatDate(Date.now(),'yyyy-MM-dd',this.locale);
    let timeString = formatDate(Date.now(),'hh:mm a',this.locale);
    console.log("date"+dateString)
    console.log("date"+timeString)

    this._cartService.updateStatus(this.orderid,timeString,dateString,this.total,"Ordered").subscribe();
    this._cartService.deleteAllItem(this.orderid).subscribe();
  }

  //Change in quantity
  changeQuantity(srno: number, quantity: number) {
    console.log("quantity" + quantity)
    console.log("srno" + srno)

    if (quantity === 0) {
      this.deleteItem(srno);
    }
    this._cartService.updateQuantity(srno, quantity).subscribe(() => {
      this.subtotal = 0;
      this.tax = 0;
      this.total = 0;
      this.item_total = [];
      this.getItems();
    });

  }

  //calculate total and subtotal 
  calcTotal() {
    //find sub total price
    for (let item of this.cartItems) {
      this.item_total.push(item.menu.price * item.quantity)
      this.subtotal += item.menu.price * item.quantity
    }
    //add tax and calculate total price 
    this.tax = (this.subtotal * 5) / 100;
    this.total += this.subtotal + this.tax + 150;
   }



  //get data from database
  getItems() {
     this._cartService.getCartItems().subscribe(data => {
      for (let item of data) {
        if (item.uid === this.uid) {
          this.orderid = item.oid
          this.cartItems = item.items;
        }
      }
      this.calcTotal()
    });
  }

  //get address from databse
  getAddress(){
   this._useraddress.getSpecificUser(this.uid).subscribe(data => {
  
     for(let address of data.address){
           if(address.type==="Home"){
           this.address=address.address
       }
     }
  
    });
  }




  constructor(private _cartService: CartService, private ngxShowLoader: NgxSpinnerService ,private _useraddress:UserProfileService,@Inject(LOCALE_ID) private locale: string) { }

  ngOnInit(): void {
    this.uid=1002;
    this.getItems()
    this.getAddress()
    
  }
}
