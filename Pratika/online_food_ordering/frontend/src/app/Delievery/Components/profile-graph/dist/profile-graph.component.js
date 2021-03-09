"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.ProfileGraphComponent = void 0;
var core_1 = require("@angular/core");
var chart_js_1 = require("chart.js");
var ProfileGraphComponent = /** @class */ (function () {
    function ProfileGraphComponent(elementRef, orderRating, _router) {
        this.elementRef = elementRef;
        this.orderRating = orderRating;
        this._router = _router;
        this.AverageRating = 0;
        this.labels = ["1 Star", "2 start", "3 star", "4 star", "5 star"];
        this.BackgroundColors = ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"];
        this.mySelect = 1;
        this.months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'Sept', 'October', 'November', 'December'];
        this.doDisplay = true;
        this.deliveryId = sessionStorage.getItem("id");
        if (this, this.deliveryId != null) {
            if (sessionStorage.getItem("isUser") === 'false') {
                this.selectChange();
            }
            else {
                this._router.navigate(['**']);
            }
        }
        else {
            this._router.navigate(['deliveryLogin']);
        }
    }
    ProfileGraphComponent.prototype.ngOnInit = function () {
    };
    //Find Month Of following date
    ProfileGraphComponent.prototype.findMonth = function (date) {
        var date = new Date(date);
        var month = date.getMonth() + 1;
        return month;
    };
    //Retrive Selected Months data
    ProfileGraphComponent.prototype.selectChange = function () {
        var _this = this;
        var orderData = [];
        var data = [0, 0, 0, 0, 0];
        this.orderRating.getOrders(this.deliveryId).subscribe(function (res) {
            res.forEach(function (rating) {
                var month = _this.findMonth(rating.orderdate);
                if (month == _this.mySelect && rating.drating !== null) {
                    orderData.push(rating.drating);
                    data[rating.drating - 1]++;
                }
            });
            _this.CreateDoughnut(data, orderData);
            _this.averageRating(orderData);
        });
    };
    //Creation of Doughnut Graph
    ProfileGraphComponent.prototype.CreateDoughnut = function (data, orderData) {
        var htmlRef = this.elementRef.nativeElement.querySelector("#pieChart");
        var noRef = this.elementRef.nativeElement.querySelector("#no-data");
        if (this.PieChart !== undefined)
            this.PieChart.destroy();
        this.PieChart = new chart_js_1.Chart(htmlRef, {
            type: 'doughnut',
            data: {
                labels: this.labels,
                datasets: [
                    {
                        label: "Ratings Per Months",
                        backgroundColor: this.BackgroundColors,
                        data: data
                    }
                ]
            },
            options: {
                title: {
                    display: true,
                    fontSize: 20
                },
                cutoutPercentage: 40,
                animation: {
                    onProgress: function (animation) {
                        var firstSet = animation.chart.config.data.datasets[0].data, dataSum = data.reduce(function (accumulator, currentValue) { return accumulator + currentValue; });
                        if (typeof firstSet !== "object" || dataSum === 0) {
                            htmlRef.style.display = 'none';
                            noRef.style.display = 'block';
                        }
                        else {
                            noRef.style.display = 'none';
                        }
                    }
                },
                responsive: true,
                maintainAspectRatio: true,
                legend: {
                    position: 'right'
                }
            }
        });
    };
    /*function to calculate Average rating on monthly basis*/
    ProfileGraphComponent.prototype.averageRating = function (data) {
        var sum = 0;
        var count = 0;
        if (data.length !== 0) {
            this.doDisplay = true;
            for (var i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    sum += data[i];
                    count++;
                }
                else {
                    continue;
                }
            }
            this.AverageRating = Math.round((sum / count) * 10) / 10;
        }
        else {
            this.doDisplay = false;
        }
    };
    ProfileGraphComponent = __decorate([
        core_1.Component({
            selector: 'app-profile-graph',
            templateUrl: './profile-graph.component.html',
            styleUrls: ['./profile-graph.component.scss']
        })
    ], ProfileGraphComponent);
    return ProfileGraphComponent;
}());
exports.ProfileGraphComponent = ProfileGraphComponent;
