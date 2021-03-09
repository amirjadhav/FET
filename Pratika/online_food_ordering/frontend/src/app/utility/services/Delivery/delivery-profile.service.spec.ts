import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { DeliveryProfileService } from './delivery-profile.service';

describe('DeliveryProfileServiceService', () => {
  let service: DeliveryProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(DeliveryProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
