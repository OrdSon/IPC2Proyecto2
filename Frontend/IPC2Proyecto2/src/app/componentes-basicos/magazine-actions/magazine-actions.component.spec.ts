import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagazineActionsComponent } from './magazine-actions.component';

describe('MagazineActionsComponent', () => {
  let component: MagazineActionsComponent;
  let fixture: ComponentFixture<MagazineActionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MagazineActionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MagazineActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
