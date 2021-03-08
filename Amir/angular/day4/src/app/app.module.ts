import { ErrorHandler, NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TempWorkComponent } from './temp-work/temp-work.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { HomepageComponent } from './homepage/homepage.component';
import { GobalErrorHandlerService } from './gobal-error-handler.service';
@NgModule({
  declarations: [
    AppComponent,
    TempWorkComponent,
    ReactiveFormComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: ErrorHandler,
      useClass: GobalErrorHandlerService
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
