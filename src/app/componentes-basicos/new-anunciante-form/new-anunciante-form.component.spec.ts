import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAnuncianteFormComponent } from './new-anunciante-form.component';

describe('NewAnuncianteFormComponent', () => {
  let component: NewAnuncianteFormComponent;
  let fixture: ComponentFixture<NewAnuncianteFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewAnuncianteFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewAnuncianteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
