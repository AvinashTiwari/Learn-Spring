import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'Avinash'
  password = ''
  errorMessage ='Invalid credentials'
  invalidLogin = false
  constructor(private router: Router) { }

  ngOnInit() {
  }

  handleLogin(){
    if(this.username === 'Avinash' && this.password === 'dummy'){
      this.router.navigate(['welcome', this.username]);
      this.invalidLogin = false;
    }else{
      this.invalidLogin = true
    }
    console.log(this.username)
    console.log(this.password)
  }


}
