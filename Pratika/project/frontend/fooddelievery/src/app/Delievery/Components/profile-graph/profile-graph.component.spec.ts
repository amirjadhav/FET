import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileGraphComponent } from './profile-graph.component';

describe('ProfileGraphComponent', () => {
  let component: ProfileGraphComponent;
  let fixture: ComponentFixture<ProfileGraphComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileGraphComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileGraphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
