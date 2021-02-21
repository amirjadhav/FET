import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListComponent } from './User/component/restaurant-list/restaurant-list.component';
import { UserProfileComponent } from './User/component/user-profile/user-profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { UserGraphComponent } from './User/component/user-profile/user-graph/user-graph.component';
import { ViewProfileComponent } from './User/component/user-profile/view-profile/view-profile.component';
import { OrderHistoryComponent } from './User/component/user-profile/order-history/order-history.component'
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule} from '@angular/material/sort';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DeliveryProfileComponent } from './Delievery/Components/delivery-profile/delivery-profile.component';
import { ProfileGraphComponent } from './Delievery/Components/profile-graph/profile-graph.component'
import { ChartsModule } from 'ng2-charts';
import { HeaderComponent } from './Shared/component/header/header.component';
import { FooterComponent } from './Shared/component/footer/footer.component';
import { UserLoginComponent } from './Shared/component/user-login/user-login.component';
import { DeliveryLoginComponent } from './Shared/component/delivery-login/delivery-login.component';
import { UserSignupComponent } from './Shared/component/user-signup/user-signup.component';
import { DeliverySignupComponent } from './Shared/component/delivery-signup/delivery-signup.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { RatingComponent } from './User/component/rating/rating.component';
import { CartComponent } from './User/component/cart/cart.component';
import { ToprestaurantsComponent } from './User/component/toprestaurants/toprestaurants.component';
import { SortListPipe } from './utility/pipes/sort-list.pipe';
import { MenuListComponent } from './User/component/menu-list/menu-list.component';
import { NgxSpinnerModule } from "ngx-spinner";
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { FormsModule} from '@angular/forms';
import { TimePipe } from './utility/pipes/time/time.pipe';
import { QuantityScrollComponent } from './User/component/quantity-scroll/quantity-scroll.component';

// import {MatBadgeModule} from '@angular/material/badge';
@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    UserProfileComponent,
    UserGraphComponent,
    OrderHistoryComponent,
    DeliveryProfileComponent,
    ViewProfileComponent,
    ProfileGraphComponent,
    HeaderComponent,
    FooterComponent,
    UserLoginComponent,
    DeliveryLoginComponent,
    UserSignupComponent,
    DeliverySignupComponent,
    RatingComponent,
    CartComponent,
    ToprestaurantsComponent,
    SortListPipe,
    MenuListComponent,
    TimePipe,
    QuantityScrollComponent
  
    // MatBadgeModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
    ChartsModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    NgbModule,
    MatProgressSpinnerModule,
    NgxSpinnerModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
