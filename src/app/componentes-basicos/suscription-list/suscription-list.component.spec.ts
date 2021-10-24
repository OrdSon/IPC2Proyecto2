import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuscriptionListComponent } from './suscription-list.component';

describe('SuscriptionListComponent', () => {
  let component: SuscriptionListComponent;
  let fixture: ComponentFixture<SuscriptionListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuscriptionListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuscriptionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
