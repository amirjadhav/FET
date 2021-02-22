import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { CartService } from 'src/app/utility/services/cart/cart.service';
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
  uid: number = 1002;
  orderid:number=0;

  constructor(private _cartService: CartService, private ngxShowLoader: NgxSpinnerService) { }

  ngOnInit(): void {
    this.getItems()
  }

    //get data from database
  getItems() {

    this._cartService.getCartItems().subscribe(data => {
      console.log("get items called")

      for (let item of data) {
       
        if (item.uid ===this.uid) {
          this.orderid=item.oid
          this.cartItems = item.items;
        }
      }
      this.calcTotal()

    });
  }

  keys(): Array<string> {
    return Object.keys(this.cartItems);
  }

  //delete item in cart
  deleteItem(id: any) {
    //alert("hello" + id)
    this._cartService.getDeleteItems(id).subscribe();
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
    },5000);
      console.log("orderid"+this.orderid)
     this._cartService.updateStatus(this.orderid,"Ordered").subscribe();
     
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
  calcTotal() 
  {
    console.log("calctotal")
    //find sub total price
    for (let item of this.cartItems) {
      this.item_total.push(item.menu.price * item.quantity)
      this.subtotal += item.menu.price * item.quantity
    //  console.log("total" + this.item_total)

    }
    //add tax and calculate total price 
    this.tax = (this.subtotal * 5) / 100;
    this.total += this.subtotal + this.tax +50;

  }

//address
    //  valueChanged()
    // {
    //     if($('.coupon_question').is(":checked"))   
    //         $(".answer").show();
    //     else
    //         $(".answer").hide();
    // }










}
