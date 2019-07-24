import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcordedAuthenticationService {

  constructor() { }

  authenticate(username, password){
    //console.log("Before " + this.isUserLoggedin())
    
    if(username === 'Avinash' && password === 'dummy'){
      sessionStorage.setItem('authenticatedUser', username)

      //console.log("After " + this.isUserLoggedin())
      return true;

    }

    console.log("After " + this.isUserLoggedin())

    return false;
  }

  isUserLoggedin(){
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user === null)
  }

  logOut(){
    sessionStorage.removeItem('authenticatedUser')
  }
}
