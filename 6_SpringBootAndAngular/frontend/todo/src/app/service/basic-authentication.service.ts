import { Injectable } from '@angular/core';
import { HelloWorldBean } from './data/welcome-data.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import { API_URL } from '../app.constants';

export const TOKEN='token';
export const AUTHENTICATED_USER='authenticatedUser';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }



  isUserLoggedin(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER)
    return !(user === null)
  }

  logOut(){
    sessionStorage.removeItem(AUTHENTICATED_USER)
    sessionStorage.removeItem(TOKEN)

  }

  getAuthenticatedUser(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER)
    return user;
  }
 
  getAuthenticatedToken(){
    if(this.getAuthenticatedUser()){
    let token = sessionStorage.getItem(TOKEN)
    return token;
    }
    
  }

  executeAuthenticationService(username, password){
 
    let basicAuthHeader = 'Basic ' + window.btoa(username + ':' + password);

    let headers = new HttpHeaders({
      Authorization: basicAuthHeader
    })
    return this.http.get<AuthenticationBean>(`${API_URL}/basicauth`, {headers}).pipe(map(
      data => {
        sessionStorage.setItem(AUTHENTICATED_USER, username)
        sessionStorage.setItem(TOKEN, basicAuthHeader)

        return data;
      }
    ))
    //console.log("Execute hello World Service");
  }


}

export class AuthenticationBean{
  constructor(public message:string){}
}
