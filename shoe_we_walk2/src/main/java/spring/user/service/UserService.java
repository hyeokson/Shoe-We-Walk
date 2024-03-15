package spring.user.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserExist(long user_id) {
        if(userRepository.select(user_id)==null)
            return false;
        return true;
    }

    public void registUser(UserRegisterRequest req) {
        User user=new User(req);
        userRepository.insert(user);
        List<Integer> price = new ArrayList<>(Arrays.asList(250, 450, 50, 100, 50, 50, 200, 300, 150, 120));
        for(int i=1; i<=10; i++) {
            itemDao.insert(new Item(req.getUser_id(), i, 0, price.get(i-1)));
        }
        itemLocDao.insert(new ItemLoc(req.getUser_id(), 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0));
    }

    public User getUser(long user_id) {
        return userRepository.select(user_id);
    }

    public void updateUser(UserRegisterRequest req) {
        int item_cnt;
        int balance;
        User user;
        user=userRepository.select(req.getUser_id());
        item_cnt=user.getTotal_item();
        balance=user.getBalance();

        User user2=new User(req, item_cnt, balance);
        userRepository.update(user2);
    }
}