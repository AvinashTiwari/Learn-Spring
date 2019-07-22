import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcordedAuthenticationService } from '../service/hardcorded-authentication.service';

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
  constructor(private router: Router , private hardcordedAuthenticationService: HardcordedAuthenticationService) { }
  

  ngOnInit() {
  }

  handleLogin(){
    //if(this.username === 'Avinash' && this.password === 'dummy'){
      if(this.hardcordedAuthenticationService.authenticate(this.username, this.password)){
    this.router.navigate(['welcome', this.username]);
      this.invalidLogin = false;
    }else{
      this.invalidLogin = true
    }
    console.log(this.username)
    console.log(this.password)
  }


}
