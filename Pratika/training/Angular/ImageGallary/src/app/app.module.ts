
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { ChildComponent } from './components/child/child.component';

import { ConvertSpacePipe } from './utility/convert-space.pipe';
import { SearchCategoryPipe } from './utility/search-category.pipe';

import { AddImageComponent } from './components/add-image/add-image.component';
import { NavComponent } from './components/nav/nav.component';
import { ImageDetailsComponent } from './components/image-details/image-details.component';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';
import { UserComponent } from './components/user/user.component';
import {  HttpClientModule } from '@angular/common/http';
import { DeleteComponent } from './components/delete/delete.component';



@NgModule({
  declarations: [
   
    AppComponent,
  HeaderComponent,
  FooterComponent,
  MainComponent,
  ChildComponent,
    ConvertSpacePipe,
    SearchCategoryPipe,
    AddImageComponent,
    NavComponent,
    ImageDetailsComponent,
    ReactiveFormComponent,
    UserComponent,
    DeleteComponent,
 



  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
