import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './footer/footer.component';
import { HomepageComponent } from './homepage/homepage.component';
import { HeaderComponent } from './header/header.component';



@NgModule({
  declarations: [FooterComponent, HomepageComponent, HeaderComponent],
  imports: [
    CommonModule
  ]
  , exports: [FooterComponent, HomepageComponent, HeaderComponent]
})
export class AdminModule { }
