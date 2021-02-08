import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { ChildComponent } from './components/child/child.component';

import { ConvertSpacePipe } from './utility/convert-space.pipe';
import { SearchCategoryPipe } from './utility/search-category.pipe';

@NgModule({
  declarations: [
   
    AppComponent,
  HeaderComponent,
  FooterComponent,
  MainComponent,
  ChildComponent,
    ConvertSpacePipe,
    SearchCategoryPipe

  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
