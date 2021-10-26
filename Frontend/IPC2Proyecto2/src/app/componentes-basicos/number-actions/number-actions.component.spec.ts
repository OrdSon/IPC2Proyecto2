import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumberActionsComponent } from './number-actions.component';

describe('NumberActionsComponent', () => {
  let component: NumberActionsComponent;
  let fixture: ComponentFixture<NumberActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumberActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NumberActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
