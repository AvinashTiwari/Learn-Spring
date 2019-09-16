import { Injectable } from '@angular/core';
import { HelloWorldBean } from './data/welcome-data.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }

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


 

  executeAuthenticationService(username, password){
 
    let basicAuthHeader = 'Basic ' + window.btoa(username + ':' + password);

    let headers = new HttpHeaders({
      Authorization: basicAuthHeader
    })
    return this.http.get<AuthenticationBean>(`http://localhost:8081/basicauth`, {headers}).pipe(map(
      data => {
        sessionStorage.setItem('authenticatedUser', username)
        return data;
      }
    ))
    //console.log("Execute hello World Service");
  }


}

export class AuthenticationBean{
  constructor(public message:string){}
}
