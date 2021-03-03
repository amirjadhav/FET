import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { HeaderComponent } from './header/header.component';
import { AdminModule } from '../admin/admin.module';
import { FooterComponent } from '../admin/footer/footer.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [LandingpageComponent, HeaderComponent],
  imports: [
    CommonModule,
    AdminModule,
    SharedModule
  ],
  exports: [HeaderComponent, LandingpageComponent, FooterComponent]
})
export class UserModule { }
