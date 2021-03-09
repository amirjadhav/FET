import { SortRestaurantsPipe } from './sort-restaurants.pipe';
import { inject, TestBed } from '@angular/core/testing';
import { TimePipe } from '../time/time.pipe';

describe('SortRestaurantsPipe', () => {
  const time = new TimePipe();
  const pipe = new SortRestaurantsPipe(time);
  const restaurant_list = [
    {
      name: "Vaishali"
    }, {
      name: "Sheetal"
    }, {
      name: "McDonald's"
    }
  ];
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortRestaurantsPipe ],
      providers: [TimePipe]
    })
    .compileComponents();
  });
  it('create an instance', inject([TimePipe], (timePipe) => {
    const pipe = new SortRestaurantsPipe(timePipe);
    expect(pipe).toBeTruthy();
  }));

  it('searches if Hotel Vaishali is in the restaurant list', () => { 
    const time = new Date();
    expect(pipe.transform(restaurant_list,"search",time, "Vaishali")).toEqual([{
      name: "Vaishali"
    }]);
  });

  it('searches "sh" in the restaurant list', () => { 
    const time = new Date();
    expect(pipe.transform(restaurant_list,"search",time, "sh")).toEqual([{
      name: "Vaishali"
    } ,{
      name: "Sheetal"
    }]);
  });
});
