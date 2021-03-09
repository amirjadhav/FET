import { Component, OnInit,ElementRef} from '@angular/core';
import { Router } from '@angular/router';
import {Chart} from 'chart.js'
import { DeliveryProfileService } from 'src/app/utility/services/Delivery/delivery-profile.service';

@Component({
  selector: 'app-profile-graph',
  templateUrl: './profile-graph.component.html',
  styleUrls: ['./profile-graph.component.scss']
})
export class ProfileGraphComponent implements OnInit {
  deliveryId:any;
  AverageRating:number=0;
  PieChart:any;
  labels:string[]=["1 Star", "2 start", "3 star","4 star","5 star"];
  BackgroundColors:string[]= ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"];
  mySelect:any=1;
  months:string[]=['January','February','March','April','May','June','July','August','Sept','October','November','December'];
  doDisplay=true;
  constructor(private elementRef: ElementRef,private orderRating:DeliveryProfileService,private _router:Router) {
    this.deliveryId=sessionStorage.getItem("id");
    if(this,this.deliveryId!=null)
    {
      if(sessionStorage.getItem("isUser")==='false')
      {
        this.selectChange();
      }
      else
      {
        this._router.navigate(['**']);
      }  
    }
    else
    {
      this._router.navigate(['deliveryLogin']);
    }
  }
 
  ngOnInit(): void {
   
  }

  //Find Month Of following date
  findMonth(date:Date){
    var date=new Date(date);
    var month=date.getMonth()+1;
    return month;
  }

  //Retrive Selected Months data
  selectChange():any{
    var orderData:number[]=[];
    var data:number[]=[0,0,0,0,0];
   this.orderRating.getOrders(this.deliveryId).subscribe((res)=>{
    res.forEach((rating:any) => {
      var month=this.findMonth(rating.orderdate);
      if(month==this.mySelect && rating.drating!==null)
      {
        orderData.push(rating.drating);
        data[rating.drating-1]++;
       
      }
    });
    this.CreateDoughnut(data,orderData);
    this.averageRating(orderData);
  })
  
 }
 
 //Creation of Doughnut Graph
  CreateDoughnut(data:any,orderData:any){
    let htmlRef = this.elementRef.nativeElement.querySelector(`#pieChart`);
    let noRef = this.elementRef.nativeElement.querySelector(`#no-data`);
    if(this.PieChart!==undefined)
      this.PieChart.destroy();
    this.PieChart = new Chart (htmlRef, {
      type:'doughnut',
      data: {
        labels:this.labels,
        datasets: [
          {
            label: "Ratings Per Months",
            backgroundColor:this.BackgroundColors,
            data: data
          }
        ]
      },
     
      options:
        {
         title:
         { 
            display:true,
            fontSize:20
         },
            cutoutPercentage: 40,
            animation: 
            {
              onProgress: function(animation) {
                var firstSet = animation.chart.config.data.datasets[0].data,
                    dataSum = data.reduce((accumulator, currentValue) => accumulator + currentValue);
                    
                if(typeof firstSet !== "object" || dataSum === 0){
                  htmlRef.style.display = 'none'
                  noRef.style.display='block'
                }
                else{
                  noRef.style.display='none'
                 
                }
            }
            },
             responsive: true,
             maintainAspectRatio: true,
             legend:{
               position:'right'
             }
        } 
    });
    
  }
 /*function to calculate Average rating on monthly basis*/
  averageRating(data:any){
    let sum:number=0;
    let count:number=0;
    if(data.length!==0)
    {
      this.doDisplay=true;
      for(let i=0;i<data.length;i++)
      {
        if(data[i]!=null)
        {
        sum+=data[i];
        count++;
        }
        else{
          continue;
        }
      }
      this.AverageRating=Math.round((sum /count)*10)/10;
    }
    else{
      this.doDisplay=false;
    }
  }
}
