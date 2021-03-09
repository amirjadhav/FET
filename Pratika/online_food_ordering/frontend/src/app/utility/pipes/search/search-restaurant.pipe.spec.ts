import { SearchRestaurantPipe } from './search-restaurant.pipe';

describe('SearchRestaurantPipe', () => {
  const pipe = new SearchRestaurantPipe();
  const restaurant_list = [
    {
      name: "Vaishali"
    }, {
      name: "Sheetal"
    }, {
      name: "McDonald's"
    }
  ];

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('searches if Hotel Vaishali is in the restaurant list', () => {
    expect(pipe.transform(restaurant_list, "Vaishali")).toEqual([{
      name: "Vaishali"
    }]);
  });

  it('search for string sh is in the restaurant list', () => {
    expect(pipe.transform(restaurant_list, "sh")).toEqual([{
      name: "Vaishali"
    }, {
      name: "Sheetal"
    }]);
  });
});
