import { Component, OnInit } from '@angular/core';
import { HardcordedAuthenticationService } from '../service/hardcorded-authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private hardcordedAuthenticationService: HardcordedAuthenticationService) { }

  ngOnInit() {
    this.hardcordedAuthenticationService.logOut();
  }

}
