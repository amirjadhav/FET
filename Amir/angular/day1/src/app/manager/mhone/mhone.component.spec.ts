import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MhoneComponent } from './mhone.component';

describe('MhoneComponent', () => {
  let component: MhoneComponent;
  let fixture: ComponentFixture<MhoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MhoneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
