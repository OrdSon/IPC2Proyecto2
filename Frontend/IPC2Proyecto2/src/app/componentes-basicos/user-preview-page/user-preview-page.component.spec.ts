import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPreviewPageComponent } from './user-preview-page.component';

describe('UserPreviewPageComponent', () => {
  let component: UserPreviewPageComponent;
  let fixture: ComponentFixture<UserPreviewPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPreviewPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPreviewPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
