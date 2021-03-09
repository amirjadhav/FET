import { Component, NgModule, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';

@Component({
  selector: 'app-toprestaurants',
  templateUrl: './toprestaurants.component.html',
  styleUrls: ['./toprestaurants.component.scss']
})
export class ToprestaurantsComponent implements OnInit {
  
  restaurant: any = [];
  restaurantImages = [{"src": "carousel1.jpg"}, {"src": "carousel2.jpg"},{"src": "carousel3.jpg"},{"src": "carousel4.jpeg"},{"src": "carousel5.jpg"}];
  
  constructor( private _restaurantService: RestaurantService) {
    this._restaurantService.getRestaurants().subscribe((res) => {
      this.restaurant = res;
    });
   }

  ngOnInit(): void {
    
  }
}
