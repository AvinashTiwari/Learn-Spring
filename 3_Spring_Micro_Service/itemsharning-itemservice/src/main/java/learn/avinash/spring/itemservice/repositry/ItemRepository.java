package learn.avinash.spring.itemservice.repositry;

import learn.avinash.spring.itemservice.model.Item;
import learn.avinash.spring.itemservice.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByUser(User user);
    Item findByName(String name);
}
