import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorMagazineListComponent } from './editor-magazine-list.component';

describe('EditorMagazineListComponent', () => {
  let component: EditorMagazineListComponent;
  let fixture: ComponentFixture<EditorMagazineListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorMagazineListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorMagazineListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
