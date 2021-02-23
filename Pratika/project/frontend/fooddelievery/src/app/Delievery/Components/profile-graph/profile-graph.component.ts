import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js'

@Component({
  selector: 'app-profile-graph',
  templateUrl: './profile-graph.component.html',
  styleUrls: ['./profile-graph.component.scss']
})
export class ProfileGraphComponent implements OnInit {
  data:number[]=[10,20,30,6];
  PieChart:any=[];
  constructor() { }

  ngOnInit(): void {
    this.PieChart = new Chart ('pieChart', {


      type:'doughnut',
   
   
      data:{ 
   
   
        labels:["Blue", "Green", "Pink","Red"],
   
   
        datasets:[{
   
   
          label: 'Vote Now',
   
   
          data:this.data,
   
   
          backgroundColor:[
   
   
            'rgba(40,23,244,0.9)',
   
   
            'rgba(192,255,0,0.9)',
   
   
            'rgba(239,23,240,0.9)',

            'rgba(255, 0, 0, 0.9)',
   
   
          ], }] },
   
   
      options:{ title:{ text: 'Bar Chart',
   
   
        display:true },
   
   
        scales:{  yAxes:[{ ticks:{ beginAtZero:true
   
   
            }  
          }]   
        }, 
          
          
          } 
        });
  }

}
