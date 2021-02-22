import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';

@Component({
  selector: 'app-toprestaurants',
  templateUrl: './toprestaurants.component.html',
  styleUrls: ['./toprestaurants.component.scss']
})
export class ToprestaurantsComponent implements OnInit {
   public restaurant: any = [];
  constructor( private _restaurantService: RestaurantService) {
    this._restaurantService.getData().subscribe((res) => {
      this.restaurant = res;
    });
   }

  ngOnInit(): void {
      
  }
}
