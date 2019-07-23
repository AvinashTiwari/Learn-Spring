import { Component, OnInit } from '@angular/core';
import { HardcordedAuthenticationService } from '../service/hardcorded-authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  //isUserLoggedIn: boolean = false;

  constructor(private hardcordedAuthenticationService: HardcordedAuthenticationService) { }

  ngOnInit() {
   // this.isUserLoggedIn = this.hardcordedAuthenticationService.isUserLoggedin();
  }

}
