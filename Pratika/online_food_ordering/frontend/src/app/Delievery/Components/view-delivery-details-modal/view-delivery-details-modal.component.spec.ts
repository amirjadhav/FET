import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ViewDeliveryDetailsModalComponent } from './view-delivery-details-modal.component';

describe('ViewDeliveryDetailsModalComponent', () => {
  let component: ViewDeliveryDetailsModalComponent;
  let fixture: ComponentFixture<ViewDeliveryDetailsModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDeliveryDetailsModalComponent ],
      providers: [NgbActiveModal]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDeliveryDetailsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
