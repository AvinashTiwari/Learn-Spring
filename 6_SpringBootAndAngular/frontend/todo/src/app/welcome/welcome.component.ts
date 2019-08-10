import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';



@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name = ''
  welcomeMessageFromService = ''
  constructor(private route : ActivatedRoute,
              private service: WelcomeDataService) { }

  ngOnInit() {
   //console.log(this.route.snapshot.params['name'])
   this.name = this.route.snapshot.params['name'];
  }
 
  getWelcomeMessage() {
    console.log(this.service.executeHelloWorldBeanService())
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSucessfullResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSucessfullResponse(resposnse){
    console.log(resposnse.message);
    this.welcomeMessageFromService = resposnse.message;

  }

  handleErrorResponse(error){
    
    this.welcomeMessageFromService = error.error.message;

  }


  getWelcomeMessageWithParameter() {
    console.log(this.service.executeHelloWorldBeanService())
    this.service.executeHelloWorldWithPathVariable(this.name).subscribe(
      response => this.handleSucessfullResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

}
