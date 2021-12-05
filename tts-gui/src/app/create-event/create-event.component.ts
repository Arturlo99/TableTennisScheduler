import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {

  nameFormControl = new FormControl('', [Validators.required]);
  cityFormControl = new FormControl('', [Validators.required]);
  streetFormControl = new FormControl('', [Validators.required]);
  dateFormControl = new FormControl('', [Validators.required]);
  timeFormControl = new FormControl('', [Validators.required]);
  maxPlayersFormControl = new FormControl('', [Validators.required]);
  descriptionFormControl = new FormControl('', []);
  matcher = new MyErrorStateMatcher();

  constructor(private session: SessionService,private httpClient: HttpClient, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  myFilter = (d: Date | null): boolean => {
    const date = (d || new Date());
    // Prevent Saturday and Sunday from being selected.
    return date > new Date();
  };

  createNewTournament() {
    this.httpClient.post<any>('http://localhost:8080/create-event', {
      name: this.nameFormControl.value,
      city: this.cityFormControl.value,
      street: this.streetFormControl.value,
      date: this.session.toLocalDateTime(this.dateFormControl.value, this.timeFormControl.value),
      maxPlayers: this.maxPlayersFormControl.value,
      description: this.descriptionFormControl.value,
      organizerEmail: this.session.getEmailFromSession() 
    }).subscribe((response) => {
      this.snackBar.open('Successfully created new tournament!', 'Ok', {
        duration: 2000,
      });
      this.router.navigate(['']);
    }, (error) => {
      this.snackBar.open('You are not allowed to create new tournament.', 'Ok', {
        duration: 2000,
      });
    })
  }

  formInvalid() {
    return (this.nameFormControl.invalid || this.cityFormControl.invalid || this.streetFormControl.invalid || this.timeFormControl.invalid || this.dateFormControl.invalid || this.maxPlayersFormControl.invalid)
  }
}

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
