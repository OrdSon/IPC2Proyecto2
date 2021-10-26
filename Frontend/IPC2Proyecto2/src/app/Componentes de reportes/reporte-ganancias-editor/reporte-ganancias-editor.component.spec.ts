import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteGananciasEditorComponent } from './reporte-ganancias-editor.component';

describe('ReporteGananciasEditorComponent', () => {
  let component: ReporteGananciasEditorComponent;
  let fixture: ComponentFixture<ReporteGananciasEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteGananciasEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteGananciasEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
