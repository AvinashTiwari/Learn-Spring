import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcordedAuthenticationService {

  constructor() { }

  authenticate(username, password){
    if(username === 'Avinash' && password === 'dummy'){
      return true;

    }

    return false;
  }
}
