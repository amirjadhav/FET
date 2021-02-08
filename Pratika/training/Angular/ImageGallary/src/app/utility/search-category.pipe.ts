import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchCategory'
})
export class SearchCategoryPipe implements PipeTransform {

  transform(images: any[],args?: any): any {
    if(!images)return null;
    if(!args)return images;

    args = args.toLowerCase();

    return images.filter(function(item:any){
        return item['imgCategory'].toLowerCase().includes(args);
    });

   
  }

}
