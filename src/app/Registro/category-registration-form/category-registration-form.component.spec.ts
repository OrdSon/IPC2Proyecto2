import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryRegistrationFormComponent } from './category-registration-form.component';

describe('CategoryRegistrationFormComponent', () => {
  let component: CategoryRegistrationFormComponent;
  let fixture: ComponentFixture<CategoryRegistrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategoryRegistrationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
