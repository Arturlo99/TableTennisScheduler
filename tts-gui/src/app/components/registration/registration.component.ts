import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatchingValidator } from './matching.validator';
import crypto from 'crypto-js';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registerForm: FormGroup

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmpassword: ['', [Validators.required]]
    }, {
      validator: MatchingValidator('password', 'confirmpassword')
    })
  }

  public createNewUser(): void {
    this.userService.createNewUser(this.registerForm)
  }

  encodeUsingSha256(data) {
    return crypto.SHA256(data).toString();
  }

  // convenient getter for easy access to form fields
  get f() { return this.registerForm.controls; }
}
