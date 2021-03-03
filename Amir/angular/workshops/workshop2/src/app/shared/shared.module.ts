import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CurconvertorPipe } from './curconvertor.pipe';



@NgModule({
  declarations: [CurconvertorPipe],
  imports: [
    CommonModule
  ],
  exports: [CurconvertorPipe]
})
export class SharedModule { }
