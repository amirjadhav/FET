import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child-two',
  templateUrl: './child-two.component.html',
  styleUrls: ['./child-two.component.scss']
})
export class ChildTwoComponent implements OnInit {
  sum:number=0;
  first_number: number | undefined;
  second_number!: number;
  @Output() addtion=new EventEmitter<number>();


onClick_button():void{
  
}
  
  constructor() { }

  ngOnInit(): void {
  }

}
