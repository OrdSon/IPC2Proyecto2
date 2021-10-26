import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProfileViewerComponent } from './admin-profile-viewer.component';

describe('AdminProfileViewerComponent', () => {
  let component: AdminProfileViewerComponent;
  let fixture: ComponentFixture<AdminProfileViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminProfileViewerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProfileViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
