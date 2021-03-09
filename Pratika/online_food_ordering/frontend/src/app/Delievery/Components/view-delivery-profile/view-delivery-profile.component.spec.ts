import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ViewDeliveryProfileComponent } from './view-delivery-profile.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('ViewDeliveryProfileComponent', () => {
  let component: ViewDeliveryProfileComponent;
  let fixture: ComponentFixture<ViewDeliveryProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDeliveryProfileComponent ],
      imports: [HttpClientTestingModule, RouterTestingModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDeliveryProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
