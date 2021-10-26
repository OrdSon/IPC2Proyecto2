import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorProfileViewComponent } from './editor-profile-view.component';

describe('EditorProfileViewComponent', () => {
  let component: EditorProfileViewComponent;
  let fixture: ComponentFixture<EditorProfileViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorProfileViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorProfileViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
