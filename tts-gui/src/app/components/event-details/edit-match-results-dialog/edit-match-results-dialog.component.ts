import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-edit-match-results-dialog',
  templateUrl: './edit-match-results-dialog.component.html',
  styleUrls: ['./edit-match-results-dialog.component.css']
})
export class EditMatchResultsDialogComponent implements OnInit {
  resultsForm = this.formBuilder.group({
    result: ['', [Validators.required, Validators.pattern('[0-9]:[0-9]')]],
  })

  constructor(
    public dialogRef: MatDialogRef<EditMatchResultsDialogComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}