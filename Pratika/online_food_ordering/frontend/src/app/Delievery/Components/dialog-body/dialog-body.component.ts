import { Component, Inject, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-body',
  templateUrl: './dialog-body.component.html',
  styleUrls: ['./dialog-body.component.scss']
})
export class DialogBodyComponent implements OnInit {
  deliveryAddress='';
  RestaurantAddress='';
  dratings:number=0;
  constructor(private dialogRef: MatDialogRef<DialogBodyComponent>,@Inject(MAT_DIALOG_DATA) {deliveryAddress,RestaurantAddress,dratings}:any) { 
    this.deliveryAddress=deliveryAddress;
    this.RestaurantAddress=RestaurantAddress;
    this.dratings=dratings;
  }

  ngOnInit(): void {
  }

}
//private dialogRef: MatDialogRef<DialogBodyComponent>,