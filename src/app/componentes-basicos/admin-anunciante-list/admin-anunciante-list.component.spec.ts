import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAnuncianteListComponent } from './admin-anunciante-list.component';

describe('AdminAnuncianteListComponent', () => {
  let component: AdminAnuncianteListComponent;
  let fixture: ComponentFixture<AdminAnuncianteListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAnuncianteListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAnuncianteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
