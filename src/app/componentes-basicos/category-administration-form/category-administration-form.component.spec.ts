import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryAdministrationFormComponent } from './category-administration-form.component';

describe('CategoryAdministrationFormComponent', () => {
  let component: CategoryAdministrationFormComponent;
  let fixture: ComponentFixture<CategoryAdministrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CategoryAdministrationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryAdministrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
