import { Component,AfterViewInit } from '@angular/core';
import { EventEmitter,Output} from '@angular/core';
import { UserProfileService } from 'src/app/utility/services/user-profile/user-profile.service'

export interface UserData {
  foodname: string;
  orderid: number;
  restaurantid: number;
  deliveryid: number;
  price: number;
  categoryid: number
}

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.scss']
})


export class OrderHistoryComponent implements AfterViewInit {
 
  uid: any = sessionStorage.getItem("id");
  @Output() orderindexEmitter : EventEmitter <number> = new EventEmitter<number>();

  
  public sendOrderIndex(i :number ) {  
    this.orderindexEmitter.emit(i);
   
  };

  userOrder: any =[];
  
  constructor(private _userorderService:UserProfileService) {   
    this._userorderService.getUserOrder(this.uid).subscribe((res)=>{
    this.userOrder=res;
     this.userOrder.forEach((order:any) => {
      this._userorderService.getRestaurantDetails(order.rid).subscribe((res)=>{
      order["Restaurant"]=res;     
  });
  })
  })  
  }
  
  

  updateRating(event: any, oid: number , id: number, name: string) {
    var data: any = {};
    data[name] = event;
    this._userorderService.updateOrder(oid, data).subscribe(() => {
    });
    setTimeout(()=>{  this.getAverage(name,id); }, 1200);
   
  }

  //getaverage rating
  getAverage(name: string,id: number) {
    this._userorderService.getAllOrders().subscribe((res)=>{
       var ratingList: any= []; 
       
       res.forEach((element: any) => { 
         if(element[(name==="rrating")?"rid":"did"]===id)
         { 
           if(element[name]!==0)
            ratingList.push(element[name]); 
         }              
       });
    
       var sum = 0;
        for( var i = 0; i < ratingList.length; i++ ){
        sum += parseInt( ratingList[i], 10 ); 
         }
        var avg = sum/ratingList.length;
       
        if(name==="rrating"){
         this._userorderService.updateRestaurantRating(id,{rrating:avg}).subscribe(()=>{
         });
        }
        else if(name==="drating"){
          this._userorderService.updateDeliveryRating(id,{drating:avg}).subscribe(()=>{
          });
        }       
        }
        );      
       }

  ngAfterViewInit() {
    
  }
  ngOnInit(): void {
     
  }

}
