import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaReportesAdminComponent } from './lista-reportes-admin.component';

describe('ListaReportesAdminComponent', () => {
  let component: ListaReportesAdminComponent;
  let fixture: ComponentFixture<ListaReportesAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaReportesAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaReportesAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
