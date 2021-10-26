import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciasRevistasComponent } from './reporte-ganancias-revistas.component';

describe('ReporteGananciasRevistasComponent', () => {
  let component: ReporteGananciasRevistasComponent;
  let fixture: ComponentFixture<ReporteGananciasRevistasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciasRevistasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciasRevistasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
