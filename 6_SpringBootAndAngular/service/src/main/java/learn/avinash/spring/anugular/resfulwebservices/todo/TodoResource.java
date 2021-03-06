package learn.avinash.spring.anugular.resfulwebservices.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
      return todoService.findAll();
    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable  String username, @PathVariable long id){
        Todo todo = todoService.deleteById(id);
        if(todo !=null){
            return ResponseEntity.noContent().build();
        }

        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodos(@PathVariable  String username, @PathVariable long id){

        return  todoService.findBId(id);
    }
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> UpdateTodo(@PathVariable  String username, @PathVariable long id, @RequestBody Todo todo){

        Todo todoUpdate = todoService.save(todo);
        return  new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> UpdateTodo(@PathVariable  String username,  @RequestBody Todo todo){

        Todo createdTodo = todoService.save(todo);

        return  ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri()).build();
    }


}
