import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToprestaurantsComponent } from './toprestaurants.component';

describe('ToprestaurantsComponent', () => {
  let component: ToprestaurantsComponent;
  let fixture: ComponentFixture<ToprestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToprestaurantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ToprestaurantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
