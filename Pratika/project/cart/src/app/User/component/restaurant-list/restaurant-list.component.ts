import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.scss']
})
export class RestaurantListComponent implements OnInit {
  restaurant_list:any = [];

  constructor(private _restaurantService: RestaurantService) {
    this._restaurantService.getData().subscribe((res) => {
      this.restaurant_list = res;
      console.log(this.restaurant_list);
    });
  }

  time = new Date();
  getTime(restaurant: any): void {
    const start_time = restaurant.starttime;
    //console.log(Date.parse(`20 Aug 2000 ${start_time.slice(0, 2)}:${start_time.slice(2, 4)}`));
  }

  ngOnInit(): void {
  }

}
