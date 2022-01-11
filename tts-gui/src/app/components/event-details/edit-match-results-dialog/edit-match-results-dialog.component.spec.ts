import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMatchResultsDialogComponent } from './edit-match-results-dialog.component';

describe('EditMatchResultsDialogComponent', () => {
  let component: EditMatchResultsDialogComponent;
  let fixture: ComponentFixture<EditMatchResultsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditMatchResultsDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMatchResultsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
