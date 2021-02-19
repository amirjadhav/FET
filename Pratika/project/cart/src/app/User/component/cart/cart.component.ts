import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CartService } from '../../utility/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartItems: any;
  length: number = 0;
  sum: number = 0;

  keys(): Array<string> {
    return Object.keys(this.cartItems);
  }

  deleteItem(id:any){

    this._cartser.getDeleteItems(id).subscribe(data => {
      
   });



    alert("DELTED")
  }


  constructor(private _cartser: CartService) { }

  ngOnInit(): void {

    this._cartser.getCartItems().subscribe(data => {

      for (let item of data) {
        this.cartItems = item.items;
      }
       //find total price
      for (let item of this.cartItems) {
        console.log(JSON.stringify(item.menu));
        this.sum = item.menu.price + this.sum;
      }

      console.log("total" + this.sum)

    });

  }


  

}
