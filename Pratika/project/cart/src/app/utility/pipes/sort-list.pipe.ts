
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sortList'
})
export class SortListPipe implements PipeTransform {

  transform(restaurant: any[]): any[] {
    return restaurant.sort((a: any,b: any)=>{
      return a.rating > b.rating ? -1 : 1;
    })
  }
}
