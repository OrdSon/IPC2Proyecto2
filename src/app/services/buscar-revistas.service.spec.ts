import { TestBed } from '@angular/core/testing';

import { BuscarRevistasService } from './buscar-revistas.service';

describe('BuscarRevistasService', () => {
  let service: BuscarRevistasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuscarRevistasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
