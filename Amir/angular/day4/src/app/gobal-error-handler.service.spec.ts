import { TestBed } from '@angular/core/testing';

import { GobalErrorHandlerService } from './gobal-error-handler.service';

describe('GobalErrorHandlerService', () => {
  let service: GobalErrorHandlerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GobalErrorHandlerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
