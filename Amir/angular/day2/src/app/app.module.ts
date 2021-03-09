import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { FormsModule } from '@angular/forms';
import { MysquarePipe } from './mysquare.pipe';
import { CurconverterPipe } from './curconverter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    AboutComponent,
    ContactComponent,
    MysquarePipe,
    CurconverterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
