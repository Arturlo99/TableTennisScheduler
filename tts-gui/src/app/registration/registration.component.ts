import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatchingValidator } from './matching.validator';
import crypto from 'crypto-js';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerForm: FormGroup

  constructor(private httpClient: HttpClient, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmpassword: ['', [Validators.required]]
    }, {
      validator: MatchingValidator('password', 'confirmpassword')
    })
  }

  public createNewUser(): void {
    this.httpClient.post<any>('http://localhost:8080/users/register', {
      email: this.registerForm.value.email,
      password: this.encodeUsingSha256(this.registerForm.value.password.toString()),
      name: this.registerForm.value.name,
      lastName: this.registerForm.value.lastname,
      role: 'user',
      creationDate: new Date()

    }).subscribe(response => {
      alert('Successfully registered!')
      this.router.navigate(['']);
    }, (error) => {
      if (error.status == 406) {
        alert('The email is already used.')
      } else {
        alert('Something went wrong.')
      }
    })
  }

  encodeUsingSha256(data) {
    return crypto.SHA256(data).toString();
  }

  // convenient getter for easy access to form fields
  get f() { return this.registerForm.controls; }

}
