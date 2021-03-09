import { Component, OnDestroy, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.scss']
})
export class RestaurantListComponent implements OnInit, OnDestroy {
  restaurant_list:any = [];
  time: Date = new Date();
  private timer: any;

  // Default sorting by time the restaurant opens or closes
  message: string = 'time';
  searchText: string='';
  
  constructor(private _restaurantService: RestaurantService) {
    this.timer = interval(1000).subscribe(() => this.time = new Date());
    this._restaurantService.getRestaurants().subscribe((res) => {
      this.restaurant_list = res;
    });
  }

  getStatus(event: string[]){
    this.message=event[0];
    this.searchText=event[1];
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.timer.unsubscribe();
  }
}
