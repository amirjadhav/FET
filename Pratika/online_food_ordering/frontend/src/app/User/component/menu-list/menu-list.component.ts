import { Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { interval } from 'rxjs';
import { CartService } from 'src/app/utility/services/cart/cart.service';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.scss']
})
export class MenuListComponent implements OnInit {
  categories: any;
  restaurant_details: any;
  isVeg: boolean = false;
  
  top: number = 260;
  headerHeight: number = 90;

  oid: number = 0;
  cartData:any;
  search = new FormControl('');
  searchText: string='';

  time: Date = new Date();
  private timer: any;

  @ViewChild('restaurantDetails') details!: ElementRef;

  constructor(private _route: ActivatedRoute, private _restaurantService: RestaurantService, private _cartService: CartService, private _elementRef : ElementRef, private router: Router) {
    this.timer = interval(1000).subscribe(() => this.time = new Date());
    
    const uid: any = sessionStorage.getItem("id");
    if (uid !== null) {
      if (sessionStorage.getItem("isUser") === "true") {
        this._cartService.getCartItems(uid).subscribe(data => {
          this.oid = data.oid;
          this.cartData=data;
        });
      }
    }

    this.search.valueChanges.subscribe((res)=>{
      this.searchText= res;
    })

    this._restaurantService.getCategories().subscribe((res) => {
      this.categories = res;
    });

    this._route.params.subscribe(params => {
      this._restaurantService.getSpecificRestaurant("name", params['name']).subscribe((res) => {
        this.restaurant_details = res;
        this._restaurantService.getMenu("id", res.rid).subscribe((res) => {
          this.restaurant_details["menu"] = res;
        });
      });
    });
  }

  foodType(type: string): string {
    const imagePath = "assets/images/";

    if (type === "Veg") {
      return `${imagePath}veg-logo.png`;
    } else {
      return `${imagePath}non-veg-logo.png`;
    }
  }

  smoothScroll(category: string, duration: number): void {
    const target = this._elementRef.nativeElement.querySelector(`#section-${category.split(' ').join('_').toLowerCase()}`);
    const start = this._elementRef.nativeElement.children[0];
    var targetPosition = target.getBoundingClientRect().top;
    var startPoint = start.getBoundingClientRect().bottom;
    var startPosition = window.pageYOffset;
    var distance = targetPosition - startPosition;
    var startTime: any = null;
    var padding: number = (startPosition < this.headerHeight) ? 125 : 110;

    let animation = (currentTime: any) => {
      if (startTime === null) startTime = currentTime;
      var timeElapsed = currentTime - startTime;
      var run = this.ease(timeElapsed, startPosition, distance-startPoint-padding, duration);
      window.scrollTo(0, run);
      if (timeElapsed < duration) requestAnimationFrame(animation);
    }

    requestAnimationFrame(animation);
  }

  ease(t: any, b: any, c: any, d: any): any {
    t /= d/2;
    if (t < 1) return c / 2 * t * t + b;
    t--;
    return -c /2 * (t * (t - 2) - 1) + b;
  }

  putQuantity(mid: number): number{
    let quantity=0;

    if (this.cartData !== undefined) {
      this.cartData.items.forEach((element:any)=> {
        if(element.mid===mid) quantity=element.quantity;
      });
    }
    return quantity;
  }

  checkDisability(status: string): boolean {
    return (status === "true");
  }

  ngOnInit(): void {
    
  }

  ngOnDestroy(): void {
    this.timer.unsubscribe();
  }

  @HostListener('window:scroll', ['$event'])
  checkScroll() {
    const padding: number = window.pageYOffset;
    const startPosition = 260;

    if (padding < this.headerHeight) {
      this.top = startPosition - padding;
    } else {
      this.top = startPosition - this.headerHeight;
    }
  }
}
