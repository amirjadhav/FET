import { stringify } from '@angular/compiler/src/util';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertSpace'
})
export class ConvertSpacePipe implements PipeTransform {

  transform(value: string): unknown {
    return value.replace(' ',"---");
  }

}
