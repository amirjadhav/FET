import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.scss']
})
export class ChildComponent implements OnInit {
@Input() cart_count:number=0;
@Output() increment=new EventEmitter<number>();


onClick_button():void{
  this.cart_count++;

}
  constructor() { }

  ngOnInit(): void {
  }

}
