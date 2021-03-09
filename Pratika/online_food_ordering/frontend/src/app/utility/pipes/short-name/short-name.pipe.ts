import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shortName'
})
export class ShortNamePipe implements PipeTransform {

  transform(fullname: any): any {
    return fullname
      .split(" ")
      .map((n: any[]) => n[0])
      .join("");
  }
}
