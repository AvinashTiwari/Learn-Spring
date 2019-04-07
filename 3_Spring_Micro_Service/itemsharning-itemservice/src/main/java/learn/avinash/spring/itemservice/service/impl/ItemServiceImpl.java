package learn.avinash.spring.itemservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import learn.avinash.spring.itemservice.client.UserFeignClient;
import learn.avinash.spring.itemservice.client.UserRestTemplateClient;
import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;
import learn.avinash.spring.itemservice.repositry.ItemRepository;
import learn.avinash.spring.itemservice.service.ItemService;
import learn.avinash.spring.itemservice.service.UserService;
import learn.avinash.spring.itemservice.util.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private UserRestTemplateClient userRestTemplateClient;

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
        return (List<Item> ) itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByUserName(String userName) {
        User user= userService.findByUserName(userName);

        return (List<Item> ) itemRepository.findByUser(user);
    }

    @Override
    public Item getByItem(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item upateItem(Item item) throws IOException {
        Item localitem = getByItem(item.getId());
        if(localitem == null){
           new IOException("Item not found");
        }else
        {
            localitem.setName(item.getName());
            localitem.setItemCondition(localitem.getItemCondition());
            localitem.setStatus(localitem.getStatus());
            localitem.setDescription(localitem.getDescription());
            return itemRepository.save(localitem);

        }

        return null;
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.delete(id);
    }

    @Override
    @HystrixCommand( fallbackMethod = "buildFallbackUser",
       threadPoolKey = "itemByUserThreadPool",
        threadPoolProperties ={  @HystrixProperty( name="coreSize", value="30"),
                @HystrixProperty( name="maxQueueSize", value="10")} )
    public User getUserByUsername(String username) {
        //randomlyRunLong();
        LOG.debug("ItemService.getUserByUsername Correlation id: {}", UserContextHolder.getContext().getCoorelationId());

//		return userFeignClient.getUserByUsername(username);
        return userRestTemplateClient.getUser(username);
    }

    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3-1) + 1)+1;
        if(randomNum == 3) sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private User buildFallbackUser(String username){
        User user = new User();
        user.setId(1234L);
        user.setFirstName("Temp Name");
        return  user;
    }
}
