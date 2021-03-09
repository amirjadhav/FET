import { Component, EventEmitter, OnChanges, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-filter-search',
  templateUrl: './filter-search.component.html',
  styleUrls: ['./filter-search.component.scss']
})
export class FilterSearchComponent implements OnInit {
  
  ratingClass: string='';
  priceClass: string='';
  filterMessage: string='';
  
  
  @Output()
  status = new EventEmitter<string[]>();

  search = new FormControl('');
  constructor() {
    this.search.valueChanges.subscribe((res)=>{
      this.sendStatus("search",res);
    })
   }
  
  ngOnInit(): void {
  }

  
  
  sendStatus(event: string, searchText: string=''){
    //this.status.emit(event);
    console.log(event, this.ratingClass,this.priceClass);
    if(event === 'rating' && this.ratingClass===''){
      this.ratingClass = 'btn-click';
      this.priceClass = '';
      this.filterMessage="Ratings: High to Low";
    }
    else if(event === 'perperson' && this.priceClass===''){
     this.priceClass = 'btn-click';
     this.ratingClass = '';
     this.filterMessage="Pricing: Low to High";
   
     
    }
    else if(event==='search'){
      //event='time';
      this.ratingClass = '';
      this.priceClass = '';
      
      //this.toggle='hide';
      this.filterMessage="";
      if(searchText===''){
        event='time';
      }
    }
    else{
      //console.log("hellooooo");
      this.ratingClass = '';
      this.priceClass = '';
      event='time';
      //this.toggle='hide';
      this.filterMessage="";
    }
    console.log(event);
    this.status.emit([event,searchText]);
}


}

