import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteLikesAdminComponent } from './reporte-likes-admin.component';

describe('ReporteLikesAdminComponent', () => {
  let component: ReporteLikesAdminComponent;
  let fixture: ComponentFixture<ReporteLikesAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteLikesAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteLikesAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
