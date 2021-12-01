import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import crypto from 'crypto-js';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup

  constructor(private session: SessionService, private http: HttpClient, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    sessionStorage.setItem('token', '')
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    })
  }

  login() {
    let url = 'http://localhost:8080/login';
    this.http.post<any>(url, {
      email: this.loginForm.value.email,
      password: this.encodeUsingSha256(this.loginForm.value.password)
    }).subscribe(data => {
      if (data.loggedIn === 'true') {
        sessionStorage.setItem('token',
          btoa(this.loginForm.value.email + ':' + this.encodeUsingSha256(this.loginForm.value.password)));
        sessionStorage.setItem('role', data.role);
        this.session.loggedIn = true;
        this.router.navigate(['']);
      } else {
        this.session.loggedIn = false;
        alert('Wrong credentials');
      }
    });
  }

  get f() { return this.loginForm.controls; }

  encodeUsingSha256(data) {
    return crypto.SHA256(data).toString();
  }
}

