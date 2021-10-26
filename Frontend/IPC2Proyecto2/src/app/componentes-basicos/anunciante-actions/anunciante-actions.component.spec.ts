import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnuncianteActionsComponent } from './anunciante-actions.component';

describe('AnuncianteActionsComponent', () => {
  let component: AnuncianteActionsComponent;
  let fixture: ComponentFixture<AnuncianteActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnuncianteActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnuncianteActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
