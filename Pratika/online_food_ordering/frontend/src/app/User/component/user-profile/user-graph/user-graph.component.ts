
import { Component, OnInit ,ElementRef} from '@angular/core';
import * as Chart from 'chart.js';
import { RestaurantService } from 'src/app/utility/services/restaurant/restaurant.service';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service';






@Component({
  selector: 'app-user-graph',
  templateUrl: './user-graph.component.html',
  styleUrls: ['./user-graph.component.scss']
})
export class UserGraphComponent implements OnInit {
  Barchart:any;
  allDeliveredOrders : any;
  alldelivered: any;
  restaurantRating: any;
  restaurantRatingarr:any;
  restaurantRatingArray: any= [];
  restaurantName: any=[];
  restaurantRates: any=[];
  executionGraph: any=false;
  constructor(private elementRef: ElementRef,private _userRatingService: UserProfileService, private _getRestaurantsRating :RestaurantService) { 
   this._userRatingService.getAllOrders().subscribe(res=>{
     this.allDeliveredOrders=res;
   });


   this._getRestaurantsRating.getRestaurants().subscribe(res=>{
     this.restaurantRating=res;
   });
  }
  
  ngOnInit(): void {
    
    setTimeout(()=>{ 
    if(this.executionGraph==false){
  
      for(var i=0;i<this.restaurantRating.length;i++)
    {
        this.restaurantName.push(this.restaurantRating[i].name);
        this.restaurantRates.push(this.restaurantRating[i].rating);
      
    }
      let barchart= this.elementRef.nativeElement.querySelector("#barchart");
       this.Barchart= new Chart(barchart, {
          type: 'bar',
          data: {
            labels: this.restaurantName,
            datasets: [
              {
                label: "Ratings (average)",
                backgroundColor: "#3cba9f",
                data: this.restaurantRates
              }
            ]
          },
          options: {
            legend: { display: true },
            title: {
              display: true,
              text: 'Ratings(average)'
            },
            scales: {
              yAxes: [{
                  ticks: {
                      beginAtZero: true,
                  },
                  scaleLabel: {
                    display: true,
                    labelString: 'Rating'
                  }
              }],
              xAxes:[{
                scaleLabel: {
                  display: true,
                  labelString: 'Restaurant'
                }
              }]
          }
          }
      });
    
      this.executionGraph=true;
    }
    
    else{
    }
    
  }, 1000);

}

}