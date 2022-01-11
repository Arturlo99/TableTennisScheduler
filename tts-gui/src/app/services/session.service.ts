import { formatDate } from '@angular/common';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  public loggedIn: boolean;

  constructor() { }

  getEmailFromSession() {
    return atob(sessionStorage.getItem('token')).split(':')[0];
  }

  getUserRole() {
    return sessionStorage.getItem('role')
  }

  toLocalDateTime(date: string, hour: string) {
    return formatDate(date, 'yyyy-MM-dd', 'en').concat('T' + hour.concat(':00'))
  }
}
