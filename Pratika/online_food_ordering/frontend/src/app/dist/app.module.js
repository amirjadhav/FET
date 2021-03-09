"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.AppModule = void 0;
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var app_routing_module_1 = require("./app-routing.module");
var app_component_1 = require("./app.component");
var http_1 = require("@angular/common/http");
var restaurant_list_component_1 = require("./User/component/restaurant-list/restaurant-list.component");
var user_profile_component_1 = require("./User/component/user-profile/user-profile.component");
var animations_1 = require("@angular/platform-browser/animations");
var tabs_1 = require("@angular/material/tabs");
var icon_1 = require("@angular/material/icon");
var user_graph_component_1 = require("./User/component/user-profile/user-graph/user-graph.component");
var view_profile_component_1 = require("./User/component/user-profile/view-profile/view-profile.component");
var order_history_component_1 = require("./User/component/user-profile/order-history/order-history.component");
var input_1 = require("@angular/material/input");
var table_1 = require("@angular/material/table");
var sort_1 = require("@angular/material/sort");
var ng_bootstrap_1 = require("@ng-bootstrap/ng-bootstrap");
var delivery_profile_component_1 = require("./Delievery/Components/delivery-profile/delivery-profile.component");
var profile_graph_component_1 = require("./Delievery/Components/profile-graph/profile-graph.component");
var ng2_charts_1 = require("ng2-charts");
var header_component_1 = require("./Shared/component/header/header.component");
var footer_component_1 = require("./Shared/component/footer/footer.component");
var user_login_component_1 = require("./Shared/component/user-login/user-login.component");
var delivery_login_component_1 = require("./Shared/component/delivery-login/delivery-login.component");
var user_signup_component_1 = require("./Shared/component/user-signup/user-signup.component");
var delivery_signup_component_1 = require("./Shared/component/delivery-signup/delivery-signup.component");
var toolbar_1 = require("@angular/material/toolbar");
var button_1 = require("@angular/material/button");
var menu_1 = require("@angular/material/menu");
var dialog_1 = require("@angular/material/dialog");
var rating_component_1 = require("./User/component/rating/rating.component");
var cart_component_1 = require("./User/component/cart/cart.component");
var order_delivered_component_1 = require("./Delievery/Components/order-delivered/order-delivered.component");
var orders_list_component_1 = require("./Delievery/Components/orders-list/orders-list.component");
var card_1 = require("@angular/material/card");
var grid_list_1 = require("@angular/material/grid-list");
var profile_editor_component_1 = require("./User/component/user-profile/profile-editor/profile-editor.component");
var toprestaurants_component_1 = require("./User/component/toprestaurants/toprestaurants.component");
//import { SortListPipe } from './utility/pipes/sort-list.pipe';
var update_profile_component_1 = require("./Delievery/Components/update-profile/update-profile.component");
var view_delivery_profile_component_1 = require("./Delievery/Components/view-delivery-profile/view-delivery-profile.component");
var forms_1 = require("@angular/forms");
var menu_list_component_1 = require("./User/component/menu-list/menu-list.component");
var filter_search_component_1 = require("./User/component/filter-search/filter-search.component");
var ngx_spinner_1 = require("ngx-spinner");
var progress_spinner_1 = require("@angular/material/progress-spinner");
var time_pipe_1 = require("./utility/pipes/time/time.pipe");
var quantity_scroll_component_1 = require("./User/component/quantity-scroll/quantity-scroll.component");
var dialog_body_component_1 = require("./Delievery/Components/dialog-body/dialog-body.component");
// import {MatBadgeModule} from '@angular/material/badge';
var sort_restaurants_pipe_1 = require("./utility/pipes/sort-restaurants/sort-restaurants.pipe");
var restaurant_details_component_1 = require("./User/component/restaurant-details/restaurant-details.component");
var sort_menu_pipe_1 = require("./utility/pipes/sort-menu/sort-menu.pipe");
// import {MatBadgeModule} from '@angular/material/badge';
var search_restaurant_pipe_1 = require("./utility/pipes/search/search-restaurant.pipe");
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            declarations: [
                app_component_1.AppComponent,
                restaurant_list_component_1.RestaurantListComponent,
                user_profile_component_1.UserProfileComponent,
                user_graph_component_1.UserGraphComponent,
                order_history_component_1.OrderHistoryComponent,
                delivery_profile_component_1.DeliveryProfileComponent,
                view_profile_component_1.ViewProfileComponent,
                profile_graph_component_1.ProfileGraphComponent,
                header_component_1.HeaderComponent,
                footer_component_1.FooterComponent,
                user_login_component_1.UserLoginComponent,
                delivery_login_component_1.DeliveryLoginComponent,
                user_signup_component_1.UserSignupComponent,
                delivery_signup_component_1.DeliverySignupComponent,
                rating_component_1.RatingComponent,
                cart_component_1.CartComponent,
                order_delivered_component_1.OrderDeliveredComponent,
                orders_list_component_1.OrdersListComponent,
                profile_editor_component_1.ProfileEditorComponent,
                toprestaurants_component_1.ToprestaurantsComponent,
                update_profile_component_1.UpdateProfileComponent,
                view_delivery_profile_component_1.ViewDeliveryProfileComponent,
                //SortListPipe,
                menu_list_component_1.MenuListComponent,
                filter_search_component_1.FilterSearchComponent,
                time_pipe_1.TimePipe,
                quantity_scroll_component_1.QuantityScrollComponent,
                dialog_body_component_1.DialogBodyComponent,
                sort_restaurants_pipe_1.SortRestaurantsPipe,
                restaurant_details_component_1.RestaurantDetailsComponent,
                sort_menu_pipe_1.SortMenuPipe,
                // MatBadgeModule
                search_restaurant_pipe_1.SearchRestaurantPipe
            ],
            imports: [
                platform_browser_1.BrowserModule,
                app_routing_module_1.AppRoutingModule,
                http_1.HttpClientModule,
                animations_1.BrowserAnimationsModule,
                tabs_1.MatTabsModule,
                icon_1.MatIconModule,
                input_1.MatInputModule,
                table_1.MatTableModule,
                sort_1.MatSortModule,
                ng2_charts_1.ChartsModule,
                toolbar_1.MatToolbarModule,
                button_1.MatButtonModule,
                menu_1.MatMenuModule,
                ng_bootstrap_1.NgbModule,
                card_1.MatCardModule,
                grid_list_1.MatGridListModule,
                forms_1.ReactiveFormsModule,
                progress_spinner_1.MatProgressSpinnerModule,
                ngx_spinner_1.NgxSpinnerModule,
                forms_1.FormsModule,
                dialog_1.MatDialogModule
            ],
            providers: [time_pipe_1.TimePipe],
            bootstrap: [app_component_1.AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
