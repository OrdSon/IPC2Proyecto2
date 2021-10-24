import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuscipcionActionsComponent } from './suscipcion-actions.component';

describe('SuscipcionActionsComponent', () => {
  let component: SuscipcionActionsComponent;
  let fixture: ComponentFixture<SuscipcionActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuscipcionActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuscipcionActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
