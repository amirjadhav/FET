import { CartService } from './../../utility/cart.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  cartItems:any;
 
  constructor(private cartser:CartService) { }

  ngOnInit(): void {
   
    
    this.cartser.getCartItems().subscribe(data=>{
      this.cartItems=data;
   console.log("images"+JSON.stringify(this.cartItems))
    });
  }

}
