import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteLikesComponent } from './reporte-likes.component';

describe('ReporteLikesComponent', () => {
  let component: ReporteLikesComponent;
  let fixture: ComponentFixture<ReporteLikesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteLikesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReporteLikesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
