import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor {

  constructor(private basicAuthService: BasicAuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler){
    let username=this.basicAuthService.getAuthenticatedUser();
  // let password = "dummy";
  // let basicAuthHeader = 'Basic ' + window.btoa(username + ':' + password);
   let basicAuthHeader =  this.basicAuthService.getAuthenticatedToken()
   if(basicAuthHeader && username){
   request = request.clone({
     setHeaders:{
      Authorization: basicAuthHeader
     }
   })
  }


    return next.handle(request);
  }
}
