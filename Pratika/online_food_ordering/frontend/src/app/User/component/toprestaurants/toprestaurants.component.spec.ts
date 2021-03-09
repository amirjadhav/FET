import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ToprestaurantsComponent } from './toprestaurants.component';
import { SortRestaurantsPipe } from 'src/app/utility/pipes/sort-restaurants/sort-restaurants.pipe';
import { TimePipe } from 'src/app/utility/pipes/time/time.pipe';

describe('ToprestaurantsComponent', () => {
  let component: ToprestaurantsComponent;
  let fixture: ComponentFixture<ToprestaurantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToprestaurantsComponent, SortRestaurantsPipe ],
      imports: [HttpClientTestingModule],
      providers: [SortRestaurantsPipe, TimePipe]
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
