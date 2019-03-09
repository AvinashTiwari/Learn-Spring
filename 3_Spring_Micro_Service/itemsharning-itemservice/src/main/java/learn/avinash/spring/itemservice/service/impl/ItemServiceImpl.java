package learn.avinash.spring.itemservice.service.impl;

import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.repositry.ItemRepository;
import learn.avinash.spring.itemservice.service.ItemService;
import learn.avinash.spring.itemservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;



    @Override
    public Item addItembyUser(Item item, String username) {
        Item localItem = itemRepository.findByName(item.getName());
        if(localItem != null){
        LOG.info("User already exist nothing will done , {} ", localItem.getName());
        }else{
            Date today = new Date();
            item.setAddDate(today);
            User user = userService.findByUserName(username);
            item.setUser(user);

            Item newitem = itemRepository.save(item);
            return  newitem;


        }

        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public List<Item> getItemsByUserName(String userName) {
        return null;
    }

    @Override
    public Item getByItem(Long id) {
        return null;
    }

    @Override
    public Item upateItem(Item item) throws IOException {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
