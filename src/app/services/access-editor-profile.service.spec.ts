import { TestBed } from '@angular/core/testing';

import { AccessEditorProfileService } from './access-editor-profile.service';

describe('AccessEditorProfileService', () => {
  let service: AccessEditorProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccessEditorProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
