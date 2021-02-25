import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MhoneComponent } from './mhone/mhone.component';



@NgModule({
  declarations: [MhoneComponent],
  imports: [
    CommonModule
  ],
  exports: [MhoneComponent]
})
export class ManagerModule { }
