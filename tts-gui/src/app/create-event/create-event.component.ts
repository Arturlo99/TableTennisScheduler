import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
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

  name: string
  city: string
  street: string
  date: string
  time: string
  maxPlayers: number
  description: string

  constructor(private session: SessionService,private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  myFilter = (d: Date | null): boolean => {
    const date = (d || new Date());
    // Prevent Saturday and Sunday from being selected.
    return date > new Date();
  };

  createNewTournament() {
    this.httpClient.post<any>('http://localhost:8080/create-event', {
      name: this.name,
      city: this.city,
      street: this.street,
      date: this.toLocalDateTime(this.date, this.time),
      maxPlayers: this.maxPlayers,
      description: this.description,
      organizerEmail: this.session.getEmailFromSession() 
    }).subscribe((response) => {
      alert('Successfully created new tournament!');
      this.router.navigate(['']);
    }, (error) => {
      alert('Something went wrong.');
    })
  }

  formInvalid() {
    return (this.nameFormControl.invalid || this.cityFormControl.invalid || this.streetFormControl.invalid || this.timeFormControl.invalid || this.dateFormControl.invalid || this.maxPlayersFormControl.invalid)
  }

  toLocalDateTime(date: string, hour: string) {
    return formatDate(date, 'yyyy-MM-dd', 'en').concat('T'+ hour.concat(':00'))
  }

}

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
