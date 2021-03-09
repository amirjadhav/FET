import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MainSectionComponent } from './main-section/main-section.component';
import { ManagerModule } from './manager/manager.module';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HeaderComponent,
    FooterComponent,
    MainSectionComponent
  ],
  imports: [
    BrowserModule,
    ManagerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
