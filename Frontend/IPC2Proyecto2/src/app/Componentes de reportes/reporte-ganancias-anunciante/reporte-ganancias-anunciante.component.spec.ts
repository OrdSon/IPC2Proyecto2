import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciasAnuncianteComponent } from './reporte-ganancias-anunciante.component';

describe('ReporteGananciasAnuncianteComponent', () => {
  let component: ReporteGananciasAnuncianteComponent;
  let fixture: ComponentFixture<ReporteGananciasAnuncianteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciasAnuncianteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciasAnuncianteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
