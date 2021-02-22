import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuantityScrollComponent } from './quantity-scroll.component';

describe('QuantityScrollComponent', () => {
  let component: QuantityScrollComponent;
  let fixture: ComponentFixture<QuantityScrollComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuantityScrollComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuantityScrollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
