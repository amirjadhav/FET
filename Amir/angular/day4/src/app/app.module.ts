import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TempWorkComponent } from './temp-work/temp-work.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
@NgModule({
  declarations: [
    AppComponent,
    TempWorkComponent,
    ReactiveFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
