import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'curconvertor'
})
export class CurconvertorPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): number {
    return value / 75;
  }

}
