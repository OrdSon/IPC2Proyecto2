import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteComentariosAdminComponent } from './reporte-comentarios-admin.component';

describe('ReporteComentariosAdminComponent', () => {
  let component: ReporteComentariosAdminComponent;
  let fixture: ComponentFixture<ReporteComentariosAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteComentariosAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteComentariosAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
