import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteAnunciosComponent } from './reporte-anuncios.component';

describe('ReporteAnunciosComponent', () => {
  let component: ReporteAnunciosComponent;
  let fixture: ComponentFixture<ReporteAnunciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteAnunciosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteAnunciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
