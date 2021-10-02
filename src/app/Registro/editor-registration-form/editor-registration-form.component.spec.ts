import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorRegistrationFormComponent } from './editor-registration-form.component';

describe('EditorRegistrationFormComponent', () => {
  let component: EditorRegistrationFormComponent;
  let fixture: ComponentFixture<EditorRegistrationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorRegistrationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorRegistrationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
