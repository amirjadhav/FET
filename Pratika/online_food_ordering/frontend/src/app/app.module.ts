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
import { NgbModule, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
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
import { MatDialogModule } from '@angular/material/dialog';
import { RatingComponent } from './User/component/rating/rating.component';
import { CartComponent } from './User/component/cart/cart.component';
import { OrderDeliveredComponent } from './Delievery/Components/order-delivered/order-delivered.component';
import { OrdersListComponent } from './Delievery/Components/orders-list/orders-list.component';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { ProfileEditorComponent } from './User/component/user-profile/profile-editor/profile-editor.component';
import { ToprestaurantsComponent } from './User/component/toprestaurants/toprestaurants.component';
import { UpdateProfileComponent } from './Delievery/Components/update-profile/update-profile.component';
import { ViewDeliveryProfileComponent } from './Delievery/Components/view-delivery-profile/view-delivery-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MenuListComponent } from './User/component/menu-list/menu-list.component';
import { FilterSearchComponent } from './User/component/filter-search/filter-search.component';
import { NgxSpinnerModule } from "ngx-spinner";
import { MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { TimePipe } from './utility/pipes/time/time.pipe';
import { QuantityScrollComponent } from './User/component/quantity-scroll/quantity-scroll.component';
import { DialogBodyComponent } from './Delievery/Components/dialog-body/dialog-body.component';
import { SortRestaurantsPipe } from './utility/pipes/sort-restaurants/sort-restaurants.pipe';
import { RestaurantDetailsComponent } from './User/component/restaurant-details/restaurant-details.component';
import { SortMenuPipe } from './utility/pipes/sort-menu/sort-menu.pipe';
import {MatBadgeModule} from '@angular/material/badge';
import { OtpConfirmModalComponent } from './Delievery/Components/otp-confirm-modal/otp-confirm-modal.component';
import { ViewDeliveryDetailsModalComponent } from './Delievery/Components/view-delivery-details-modal/view-delivery-details-modal.component';
import { RouterModule} from '@angular/router';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { NotfoundComponent } from './Shared/component/notfound/notfound.component';
import { ModalDeleteCartComponent } from './User/component/modal-delete-cart/modal-delete-cart.component';
import { ShortNamePipe } from './utility/pipes/short-name/short-name.pipe';

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
    OrderDeliveredComponent,
    OrdersListComponent,
    ProfileEditorComponent,
    ToprestaurantsComponent,
    UpdateProfileComponent,
    ViewDeliveryProfileComponent,
    MenuListComponent,
    FilterSearchComponent,
    TimePipe,
    QuantityScrollComponent,
    DialogBodyComponent,
    SortRestaurantsPipe,
    RestaurantDetailsComponent,
    SortMenuPipe,
    OtpConfirmModalComponent,
    ViewDeliveryDetailsModalComponent,
    NotfoundComponent,
    ShortNamePipe,
    ModalDeleteCartComponent,
    
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
    MatCardModule,
    MatGridListModule,
    ReactiveFormsModule,
    MatProgressSpinnerModule,
    MatSlideToggleModule,
    NgxSpinnerModule,
    FormsModule,
    MatDialogModule,
    MatBadgeModule,
    RouterModule
  ],
  providers: [TimePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
