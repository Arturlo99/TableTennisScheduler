import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit(): void {
    sessionStorage.setItem('token', '')
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    })
  }

  login() {
    this.userService.login(this.loginForm.value.email, this.loginForm.value.password)
  }

  get f() { return this.loginForm.controls; }
}

