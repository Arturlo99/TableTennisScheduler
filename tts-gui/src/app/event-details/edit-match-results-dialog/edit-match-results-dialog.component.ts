import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Match } from 'src/app/models/match';

@Component({
  selector: 'app-edit-match-results-dialog',
  templateUrl: './edit-match-results-dialog.component.html',
  styleUrls: ['./edit-match-results-dialog.component.css']
})
export class EditMatchResultsDialogComponent implements OnInit {
  finalResult: string

  constructor(
    public dialogRef: MatDialogRef<EditMatchResultsDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {match: Match},
  ) { this.finalResult = data.match.finalResult }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}