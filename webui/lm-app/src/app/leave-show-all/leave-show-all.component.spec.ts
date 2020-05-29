import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveShowAllComponent } from './leave-show-all.component';

describe('LeaveShowAllComponent', () => {
  let component: LeaveShowAllComponent;
  let fixture: ComponentFixture<LeaveShowAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveShowAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveShowAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
