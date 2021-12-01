import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  public loggedIn: boolean;

  constructor() {
    if (sessionStorage.getItem('token') != null && sessionStorage.getItem('token') != '') {
      this.loggedIn = true;
    } else {
      sessionStorage.setItem('token', '');
      this.loggedIn = false;
    }
  }

  getEmailFromSession() {
    return atob(sessionStorage.getItem('token')).split(':')[0];
  }
}
