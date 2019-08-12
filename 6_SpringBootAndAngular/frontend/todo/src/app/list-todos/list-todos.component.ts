import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';

export class Todo{
  constructor(
    public id: number,
    public description:string,
    public done: boolean,
    public targetDate:Date
  ){

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos :Todo[]//[
    //new Todo(1,'Learn to Dance',false, new Date()),
    //new Todo(2,'Expert',false, new Date()),
    //new Todo(3,'vist UK, Europe',false, new Date())
//  ]
 // todo ={
  //  id: 1,
   // description: 'Learn to Dance'

  //}

  constructor(private todoService: TodoDataService) { }

  ngOnInit() {
     this.todoService.retriveAllTodos('Avinash').subscribe(

      response =>{
        console.log(response);
        this.todos = response;
      }
     )
  }

}
