import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
export class HelloWorldBean {
  constructor(public message:string){}
}
@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor( private http: HttpClient) { }

  executeHelloWorldBeanService(){
    return this.http.get<HelloWorldBean>('http://localhost:8081/hello-world-bean')
    //console.log("Execute hello World Service");
  }

  executeHelloWorldWithPathVariable(name){
    let basicAuth = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders({
      Authorization: basicAuth
    })
    return this.http.get<HelloWorldBean>(`http://localhost:8081/hello-world-bean/path-variable/${name}`, {headers})
    //console.log("Execute hello World Service");
  }

  createBasicAuthenticationHttpHeader(){
   let username="Avinash";
   let password = "dummy";
   let basicAuthHeader = 'Basic ' + window.btoa(username + ':' + password);
   return basicAuthHeader;

  }
}
