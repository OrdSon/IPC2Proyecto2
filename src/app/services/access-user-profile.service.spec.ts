import { TestBed } from '@angular/core/testing';

import { AccessUserProfileService } from './access-user-profile.service';

describe('AccessUserProfileService', () => {
  let service: AccessUserProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccessUserProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
