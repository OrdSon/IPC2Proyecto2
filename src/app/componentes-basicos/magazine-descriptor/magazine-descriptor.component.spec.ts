import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagazineDescriptorComponent } from './magazine-descriptor.component';

describe('MagazineDescriptorComponent', () => {
  let component: MagazineDescriptorComponent;
  let fixture: ComponentFixture<MagazineDescriptorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MagazineDescriptorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MagazineDescriptorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
