import { Pipe, PipeTransform } from '@angular/core';
import { element } from 'protractor';

@Pipe({
  name: 'sortMenu'
})
export class SortMenuPipe implements PipeTransform {

  transform(value: any[], ...args: any[]): any[] {
    var menu: any[] = [];
    if (value) {
      value.forEach((element) => {
        if (element.category.cname === args[0]) {
          if (args[1] === true) {
            if(element.foodtype === "Veg" ) {
               menu.push(element);
            }
          } else {
            menu.push(element);
          }
        }
      });
      if(args[2]!==''){
        return menu.slice().filter((item)=>{
          return item['itemname'].toLowerCase().includes(args[2].toLowerCase());
        })
      }
      else
       return menu;
    }
    return [];
  }
}
