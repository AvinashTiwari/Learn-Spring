package learn.avinash.spring.itemservice.controller;

import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.service.ItemService;
import learn.avinash.spring.itemservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.POST)
    public Item  addItem(@RequestBody Item item){
        String user  = "jadams";
        return  itemService.addItembyUser(item, user);
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Item> getAllItemByUser(@RequestBody Item item){
        String user  = "jadams";
        return  itemService.getItemsByUserName( user);
    }


    @RequestMapping("/all")
    public List<Item> getAll(){
        return  itemService.getAllItems();
    }


    @RequestMapping("/{id}")
    public Item getItemById(@PathVariable long id){

        return  itemService.getByItem(id);
    }

    @RequestMapping(value="/{id}", method =  RequestMethod.PUT)
    public Item updateItem(@PathVariable long id, @RequestBody Item item) throws IOException {
         item.setId(id);
        return  itemService.upateItem(item);
    }


    @RequestMapping(value="/{id}", method =  RequestMethod.DELETE)
    public void deleteItem(@PathVariable long id) throws IOException {

          itemService.deleteItemById(id);
    }



    @RequestMapping(value="/user/{username}")
    public User getUser(@PathVariable String userName) throws IOException {

       return itemService.getUserByUsername(userName);
    }
}
