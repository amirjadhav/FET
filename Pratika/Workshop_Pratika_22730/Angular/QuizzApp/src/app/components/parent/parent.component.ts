import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
export class ParentComponent implements OnInit {


  cities :string[]=["Pune","Mumbai","Delhi","solapur"]
  constructor() { }
sum=0;

 displaySum(sum:any) {
        console.log(sum);
    }

  ngOnInit(): void {
  }

}
