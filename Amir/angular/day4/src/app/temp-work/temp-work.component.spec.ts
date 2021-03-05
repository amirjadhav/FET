import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TempWorkComponent } from './temp-work.component';

describe('TempWorkComponent', () => {
  let component: TempWorkComponent;
  let fixture: ComponentFixture<TempWorkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TempWorkComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TempWorkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
