import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GlobalConstants } from '../common/global-constants';
import * as CryptoJS from 'crypto-js';
import { SessionService } from './session.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private loginUrl = GlobalConstants.apiURL + 'login'
  private registerUrl = GlobalConstants.apiURL + 'register'
  constructor(private http: HttpClient, private session: SessionService, private router: Router, private snackBar: MatSnackBar) { }

  public login(email: string, password: string) {
    return this.http.post<any>(this.loginUrl, { email: email, password: CryptoJS.SHA256(password).toString() }).subscribe(data => {
      if (data.loggedIn === 'true') {
        sessionStorage.setItem('token', btoa(email + ':' + CryptoJS.SHA256(password)));
        sessionStorage.setItem('role', data.role);
        this.session.loggedIn = true;
        this.router.navigate(['']);
        this.snackBar.open('Successfully logged in.', 'Ok', {
          duration: 2000,
        });
      } else {
        this.session.loggedIn = false;
        this.snackBar.open('Wrong credentials.', 'Ok', {
          duration: 2000,
        });
      }
    });
  }

  public createNewUser(registerForm: FormGroup): void {
    this.http.post<any>(this.registerUrl, {
      email: registerForm.value.email,
      password: CryptoJS.SHA256(registerForm.value.password).toString(),
      name: registerForm.value.name,
      lastName: registerForm.value.lastname,

    }).subscribe((response) => {
      this.snackBar.open('Successfully registered!', 'Ok', {
        duration: 2000,
      });
      this.router.navigate(['']);
    }, (error) => {
      if (error.status == 406) {
        this.snackBar.open('The email is already used.', 'Ok', {
          duration: 2000,
        });
      } else {
        this.snackBar.open('Unrecognized error occured.', 'Ok', {
          duration: 2000,
        });
      }
    })
  }
}
