import { TestBed } from '@angular/core/testing';

import { NewTitleService } from './new-title.service';

describe('NewTitleService', () => {
  let service: NewTitleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewTitleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
