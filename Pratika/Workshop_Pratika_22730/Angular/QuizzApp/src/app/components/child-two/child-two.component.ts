import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child-two',
  templateUrl: './child-two.component.html',
  styleUrls: ['./child-two.component.scss']
})
export class ChildTwoComponent implements OnInit {
 sum:number=0;
  first_number: any | undefined;
  second_number!: any;
  @Output() valueChange = new EventEmitter();
  changeValue() { 
    // You can give any function name
    console.log("in value change")
    this.sum =this.first_number+this.second_number;
    this.valueChange.emit(this.sum);
}


  
  constructor() { }

  ngOnInit(): void {
  }

}
