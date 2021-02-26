import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'curconverter'
})
export class CurconverterPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    return value / 75;
  }

}
