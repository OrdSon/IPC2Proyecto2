import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagazineReaderComponent } from './magazine-reader.component';

describe('MagazineReaderComponent', () => {
  let component: MagazineReaderComponent;
  let fixture: ComponentFixture<MagazineReaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MagazineReaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MagazineReaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
