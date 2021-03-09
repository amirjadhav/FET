import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserProfileService } from './../../../utility/services/user-profile/user-profile.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { CartService } from 'src/app/utility/services/cart/cart.service';
import { formatDate } from '@angular/common';
import { LOCALE_ID } from '@angular/core';
import { Inject } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';
import { interval } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartItems: any[] = [];
  cart: any;
  item_total: number[] = [];
  address_array: any[] = [];
  subtotal: number = 0;
  tax: number = 0;
  total: number = 0;
  public loading: boolean = false;
  showLoader: boolean = false;
  uid: any = 0;
  otherAddress:string='';
  address: string = '';
  options: boolean = true;
  selectedType: any = "Other";
  time: Date = new Date();
  private timer: any;
 restaurant_details: any;
 openModal:any=true;
 

 constructor(private _cartService: CartService, private ngxShowLoader: NgxSpinnerService, private _useraddress: UserProfileService, @Inject(LOCALE_ID) private locale: string,private router: Router, private _restaurantService: RestaurantService) {
    this.timer = interval(1000).subscribe(() => this.time = new Date());
   }

  ngOnInit(): void {
   this.uid = sessionStorage.getItem("id");
   let isUser=sessionStorage.getItem("isUser")
    if(this.uid!==null){
       if(isUser){
        this.getItems();
       this.getAddress();
      }
      else{
        this.router.navigate(['**']);
      }
     
     }
  
 }


  //get data from database
  getItems() {
    this._cartService.getCartItems(this.uid).subscribe(data => {
         this.cart=data;
          this.cartItems = data.items;
          this.calcTotal();
           this._restaurantService.getSpecificRestaurant("id",this.cart.rid).subscribe((res) => {
           this.restaurant_details = res;
        
      });
    });
  }


  //calculate total and subtotal 
  calcTotal() {
     this.subtotal = 0;
        this.tax = 0;
        this.total = 0;
        this.item_total = [];
    for (let item of this.cartItems) {
      this.item_total.push(item.menu.price * item.quantity)
      this.subtotal += item.menu.price * item.quantity
    }
    this.tax = (this.subtotal * 5) / 100;
    this.total += this.subtotal + this.tax +50;
  }


  //get address from databse
  getAddress() {
    this._useraddress.getSpecificUser(this.uid).subscribe(data => {
     
      for (let address of data.address) {
        this.address_array.push(address)
        if (address.type === this.selectedType) {
          this.address = address.address
          
        }
      }
    });
  }



  //delete item in cart
  deleteItem(mid: any,srno:number,changeCount:boolean) {
   this._cartService.deleteItem(this.cart.oid,mid).subscribe(()=>{
    this.cartItems =this.cartItems.filter(item=>(item.srno!==srno)) ;
      this.calcTotal();
   });
   if(changeCount){
   let count:any= (sessionStorage.getItem('cartitems'));
      count=parseInt(count)-1;
      sessionStorage.setItem('cartitems',count);
   }
  }




  showModal(){
    if( this.selectedType==="Other"){
      this.otherAddress= this.otherAddress.replace(/\s/g, "");
      if(this.otherAddress.length===0 ){
        this.openModal=false;
     }
     else {
       this.openModal=true;
     }
    }
   
  
  }

  //spinner after place order and change status of order
  orderProcessing() {
    this.showLoader = true;
    this.ngxShowLoader.show();
    setTimeout(() => {
      this.showLoader = false;
      this.ngxShowLoader.hide();
      this.router.navigate([''])
    }, 5000);
    sessionStorage.setItem('cartitems',"0");
    let dateString = formatDate(Date.now(), 'yyyy-MM-dd', this.locale);
    let timeString = formatDate(Date.now(), 'hh:mm a', this.locale);
    if( this.selectedType==="Other"){
      this.address=this.otherAddress;
    }
    this._cartService.updateStatus(this.cart.oid, { "ordertime": timeString, "orderdate": dateString, "price": this.total,"address":this.address, "status": "Ordered" }).subscribe();
    this._cartService.createNewCart({ "uid": this.uid }).subscribe();

  }


  //Change in quantity
  getQuantity( quantity: number,srno:number) {
       if(quantity===0){
        this.deleteItem(0,srno,false)
       }else{
        this.cartItems.forEach((item) => {
          if(item.srno=== srno) {
           item.quantity=quantity
          }
      });
        this.calcTotal();
       }
      
  }


  selecteAddress() {
   for (let address of this.address_array) {
      if (address.type === this.selectedType) {
        this.address = address.address;
        this.openModal=true;
      }
     }
  }


  //validation of payment form 
  paymentForm = new FormGroup({
    cardNumber: new FormControl('', Validators.pattern('([0-9]){4}[\\s-]?([0-9]){4}[\\s-]?([0-9]){4}[\\s-]?([0-9]){4}')),
    expiryDate: new FormControl('', Validators.pattern('([0-9]){2}/([0-9]){4}')),
    CVV: new FormControl('', Validators.pattern('[0-9]{3}')),
    ownerName: new FormControl('', Validators.pattern('^[a-zA-Z]{2,}(?: [a-zA-Z]+){0,2}$'))
  })

  get cardNumber() {
    return this.paymentForm.get('cardNumber')
  }

  checkDisability(status: string): boolean {
    return (status === "true");
  }
  ngOnDestroy(): void {
    this.timer.unsubscribe();
  }

 
 
}