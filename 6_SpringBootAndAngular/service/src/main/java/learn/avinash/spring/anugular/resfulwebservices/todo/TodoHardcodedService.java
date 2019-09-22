package learn.avinash.spring.anugular.resfulwebservices.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos =new ArrayList<>();

    private static long idCounter = 0;

    static  {
        todos.add(new Todo(++idCounter, "Avinash", "Learn To Dance", new Date(),false));
        todos.add(new Todo(++idCounter, "Avinash", "MicroServices", new Date(),false));

        todos.add(new Todo(++idCounter, "Avinash", "Angular", new Date(),false));

    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo save(Todo todo){
        if(todo.getId() == -1){
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }

        return  todo;
    }

    public Todo deleteById(long  id){
        Todo todo = findBId(id);
        if(todo==null) return  null;
        if(todos.remove(todo)) {
            return todo;
        }

        return  null;


    }

    public Todo findBId(long id) {
        for(Todo todo:todos){
            if(todo.getId() == id){
                return  todo;
            }
        }

        return  null;
    }
}
