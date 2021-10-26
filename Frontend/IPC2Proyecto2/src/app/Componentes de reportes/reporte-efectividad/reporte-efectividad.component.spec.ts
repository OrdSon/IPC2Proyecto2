import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteEfectividadComponent } from './reporte-efectividad.component';

describe('ReporteEfectividadComponent', () => {
  let component: ReporteEfectividadComponent;
  let fixture: ComponentFixture<ReporteEfectividadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteEfectividadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteEfectividadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
