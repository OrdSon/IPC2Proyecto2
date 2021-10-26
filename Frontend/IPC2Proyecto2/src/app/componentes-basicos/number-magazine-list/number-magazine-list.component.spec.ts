import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumberMagazineListComponent } from './number-magazine-list.component';

describe('NumberMagazineListComponent', () => {
  let component: NumberMagazineListComponent;
  let fixture: ComponentFixture<NumberMagazineListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumberMagazineListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NumberMagazineListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
