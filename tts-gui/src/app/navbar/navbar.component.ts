import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private session: SessionService) {
    this.session.loggedIn = false;
  }

  ngOnInit(): void {
    if (sessionStorage.getItem('token') != null && sessionStorage.getItem('token') != '') {
      this.session.loggedIn = true;
    } else {
      sessionStorage.setItem('token', '');
      this.session.loggedIn = false;
    }
  }

  isLoggedIn() { return this.session.loggedIn; }

  logout() {
    sessionStorage.setItem('token', '');
    sessionStorage.setItem('role', '');
    this.session.loggedIn = false;
    this.router.navigateByUrl('');
  }

}
