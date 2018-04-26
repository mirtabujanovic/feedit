import { TestBed, inject } from '@angular/core/testing';

import { FeeditService } from './feedit.service';

describe('FeeditService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FeeditService]
    });
  });

  it('should be created', inject([FeeditService], (service: FeeditService) => {
    expect(service).toBeTruthy();
  }));
});
