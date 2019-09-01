import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

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

  todos :Todo[]
  messsage: string

  constructor(private todoService: TodoDataService, private router:Router) { }

  ngOnInit() {
    this.refreshTodos();
  }

  refreshTodos(){
    this.todoService.retriveAllTodos('Avinash').subscribe(

      response =>{
        console.log(response);
        this.todos = response;
      }
     )
  }

  deleteTodo(id){
    this.todoService.deleteTodo('avinash',id).subscribe(
      response => {
        console.log(response);
        this.refreshTodos();
        this.messsage = `Delete Successful ${id}`
      }
    )
  }

  updateTodo(id){
    this.router.navigate(['todos', id])
  }

  addTodo(){
    
    this.router.navigate(['todos',-1]);

}

}
