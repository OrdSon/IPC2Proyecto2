import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileCreationFormComponent } from './profile-creation-form.component';

describe('ProfileCreationFormComponent', () => {
  let component: ProfileCreationFormComponent;
  let fixture: ComponentFixture<ProfileCreationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileCreationFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileCreationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
