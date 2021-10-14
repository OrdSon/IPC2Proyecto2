import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTitleFormComponent } from './new-title-form.component';

describe('NewTitleFormComponent', () => {
  let component: NewTitleFormComponent;
  let fixture: ComponentFixture<NewTitleFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewTitleFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTitleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
