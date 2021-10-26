import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAnuncioFormComponent } from './new-anuncio-form.component';

describe('NewAnuncioFormComponent', () => {
  let component: NewAnuncioFormComponent;
  let fixture: ComponentFixture<NewAnuncioFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewAnuncioFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewAnuncioFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
