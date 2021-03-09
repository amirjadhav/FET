import { Injectable, Pipe, PipeTransform } from '@angular/core';
import { TimePipe } from '../time/time.pipe';

@Pipe({
  name: 'sortRestaurants'
})
@Injectable({
  providedIn: 'root'
})
export class SortRestaurantsPipe implements PipeTransform {
  constructor(private _timePipe: TimePipe) {  }

  sortByTime(list: any[], now: Date): any[] {
    var available: any[] = [];
    var not_available: any[] = [];
    
    list.forEach((element) => {
      const timeArray = this._timePipe.initTime(now, element.starttime, element.endtime);
      if ((timeArray[0]-timeArray[1]) < 0 || (timeArray[2]-timeArray[0]) <= 0) {
        not_available.push(element);
      } else {
        available.push(element);
      }
    });
    return available.concat(not_available);
  }

  transform(value: any[], ...args: any[]): any[] {
    // Default
    if (args[0] === 'time') {
      return this.sortByTime(value, args[1]);
    }
    // Sorting according to rating or price
    else if (args[0] === "rating"){ 
      return value.slice().sort((a: any,b: any)=>{
        return a[args[0]] > b[args[0]] ? -1 : 1;
      })
    }
    else if(args[0] === "perperson"){
      return value.slice().sort((a: any,b: any)=>{
        return a[args[0]] < b[args[0]] ? -1 : 1;
      })
    }
    // Search restaurant by name
    else if (args[0]=== "search") {
      return value.slice().filter(restaurant => {
        return restaurant['name'].toLowerCase().includes(args[2].toLowerCase());
      });
    }
   return value;
  }
}
