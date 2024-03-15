package spring.item.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService{

    private final ItemRepository itemRepository;
    private final ItemLocRepository itemLocRepository;

    public UserService(ItemRepository itemRepository, ItemLocRepository itemLocRepository) {
        this.itemRepository=itemRepository;
        this.itemLocRepository=itemLocRepository;
    }

    public void updateItemLoc(ItemLocRegisterRequest req) {
        itemLocRepository.update(req);
    }

    public ItemLoc getItemLoc(long user_id) {
        return itemLocRepository.select(user_id);
    }

    public void updateItem(long user_id, int item_id, int add) {
        Item item=itemRepository.select(user_id, item_id);
        int price=item.getPrice();
        Item item2=new Item(user_id, item_id, item.getItem_cnt()+add, price);
        itemRepository.update(item2);

        User user=itemRepository.select(user_id);
        User user2=new User(user_id, user.getName(), user.getGender(), user.getAge(), user.getHeight(),
                user.getWeight(), user.getTotal_item()+add, user.getBalance()-price);
        itemRepository.update(user2);
    }

    public Item getItem(long user_id, int item_id) {
        return itemRepository.select(user_id, item_id);
    }

    public List<Item> getAllItem(long user_id) {
        return itemRepository.select_all(user_id);
    }

}