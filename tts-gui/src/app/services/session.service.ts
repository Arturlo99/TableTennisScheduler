import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  public loggedIn: boolean;

  constructor() {
    this.loggedIn = false;
  }

  getEmailFromSession() {
    return atob(sessionStorage.getItem('token')).split(':')[0];
  }
}
