import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorRegistrationFormComponent } from './administrator-registration-form.component';

describe('AdministratorRegistrationFormComponent', () => {
  let component: AdministratorRegistrationFormComponent;
  let fixture: ComponentFixture<AdministratorRegistrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorRegistrationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
