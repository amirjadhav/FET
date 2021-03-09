import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { OrderDeliveredComponent } from './order-delivered.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('OrderDeliveredComponent', () => {
  let component: OrderDeliveredComponent;
  let fixture: ComponentFixture<OrderDeliveredComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderDeliveredComponent ],
      imports: [MatDialogModule, HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderDeliveredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
