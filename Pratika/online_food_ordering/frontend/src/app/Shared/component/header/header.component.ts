import { Component, Input, OnInit } from '@angular/core';
import { AuthService } from 'src/app/utility/services/user-login/auth.service'
import { Router } from '@angular/router';
import { interval } from 'rxjs';
import { CartService } from 'src/app/utility/services/cart/cart.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  initial: any;
  userLength: any;
userid: any;
  cart_count:any
  timer: any;
  @Input() app_name;
  constructor(private _auth: AuthService, private _router: Router,private _cartService: CartService) { }
  



  ngOnInit(): void {
    if(this.isUser()){
    this.userid= (sessionStorage.getItem('id'))
   this._cartService.getCartItems(this.userid).subscribe(data => {
     sessionStorage.setItem('cartitems',data.items.length);
       });
}

    this.initial = this._auth.getDataFromSessionStorage('username');
    this.timer=interval(100).subscribe(() => 
    this.cart_count= (sessionStorage.getItem('cartitems')))
  }
  
  tabs: any = [
    {
      name: "Login",
      link: "userLogin",
      loggedin: false
    },
    {
      name: "Sign Up",
      link: "userSignUp",
      loggedin: false
    },
    {
      name: "Dashboard",
      link: (this.isUser()) ? "userProfile" : "deliveryProfile",
      loggedin: true
    }
  ];

  loggedIn() {
    return (this._auth.getDataFromSessionStorage('email') !== null);

  }
  
  //check if user or delivery person
  isUser() {
    return (this._auth.getDataFromSessionStorage('isUser') === "true");
  }

  logout() {
    this._auth.clearStorage()
    window.location.replace('/');
  }

  navigateHome() {
    if (this.loggedIn()) {
      if (this.isUser()) {
        return '/';
      }
      return 'delivery';
    }
    return '/';
  }
  ngOnDestroy(): void {
    this.timer.unsubscribe();
  }
}
