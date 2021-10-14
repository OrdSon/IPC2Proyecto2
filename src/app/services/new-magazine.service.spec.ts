import { TestBed } from '@angular/core/testing';

import { NewMagazineService } from './new-magazine.service';

describe('NewMagazineService', () => {
  let service: NewMagazineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewMagazineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
