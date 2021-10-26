import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciasTotalesComponent } from './reporte-ganancias-totales.component';

describe('ReporteGananciasTotalesComponent', () => {
  let component: ReporteGananciasTotalesComponent;
  let fixture: ComponentFixture<ReporteGananciasTotalesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciasTotalesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciasTotalesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
