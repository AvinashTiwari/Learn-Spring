package learn.avinash.spring.itemservice.service;

import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;

import java.io.IOException;
import java.util.List;

public interface ItemService {
    Item addItembyUser(Item item, String username);
    List<Item> getAllItems();
    List<Item> getItemsByUserName(String userName);
    Item getByItem(Long id);
    Item upateItem(Item item) throws IOException;
    void deleteItemById(Long id);
    User getUserByUsername(String username);
}
