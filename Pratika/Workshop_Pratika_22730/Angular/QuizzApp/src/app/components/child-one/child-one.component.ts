import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-child-one',
  templateUrl: './child-one.component.html',
  styleUrls: ['./child-one.component.scss']
})
export class ChildOneComponent implements OnInit {
  // ViewCities(){
  //   console.log("completed")
  //    }
     // ViewCities(){
  //   console.log("completed")
  //    }
  @Input() cities_parent: string[]=[];
  constructor() { }

  ngOnInit(): void {
  }

}
