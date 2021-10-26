import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorNumberPreviewComponent } from './editor-number-preview.component';

describe('EditorNumberPreviewComponent', () => {
  let component: EditorNumberPreviewComponent;
  let fixture: ComponentFixture<EditorNumberPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorNumberPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorNumberPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
