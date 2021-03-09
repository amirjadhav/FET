import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mysquare'
})
export class MysquarePipe implements PipeTransform {

  transform(value: any, ...args: any[]): unknown {
    return Math.pow(value, 2);
  }

}
