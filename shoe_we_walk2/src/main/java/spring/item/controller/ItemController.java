package spring.item.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.User;
import spring.UserDao;
import spring.UserRegisterRequest;
import spring.WeekStepNum;
import spring.Work;
import spring.WorkDao;
import spring.WorkRegisterRequest;
import spring.Item;
import spring.ItemDao;
import spring.ItemLocDao;
import spring.ItemLocRegisterRequest;
import spring.ItemRegisterRequest;
import spring.Service;
import spring.MessageResponse;

@RestController
public class ItemController{

    private final UserServie userServie;
    private final ItemService itemService;

    ItemController(UserService userService, ItemService itemService) {
        this.userServie=userService;
        this.itemService=itemService;
    }
    @GetMapping("/api/get/itemloc")
    public ResponseEntity<Object> getItemLoc(@RequestParam("user_id") long user_id) {
        if(!userServie.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(itemService.getItemLoc(user_id));
    }

    @PostMapping("/api/update/itemloc")
    public ResponseEntity<Object> updateItemLoc(@RequestBody ItemLocRegisterRequest req) {
        if(!userServie.isUserExist(req.getUser_id())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        itemService.updateItemLoc(req);
        return ResponseEntity.ok(new MessageResponse("update itemloc success"));
    }

    @GetMapping("/api/get/item")
    public ResponseEntity<Object> getItem(@RequestParam("user_id") long user_id, @RequestParam("item_id") int item_id) {
        if(!userServie.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(itemService.getItem(user_id, item_id));
    }

    @GetMapping("/api/getAll/item")
    public ResponseEntity<Object> getAllItem(@RequestParam("user_id") long user_id) {
        if(!userServie.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(itemService.getAllItem(user_id));
    }

    @GetMapping("/api/update/item")
    public ResponseEntity<Object> updateItem(@RequestParam("user_id") long user_id,
                                             @RequestParam("item_id") int item_id,
                                             @RequestParam("add") int add) {
        if(!userServie.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        itemService.updateItem(user_id, item_id, add);
        return ResponseEntity.ok(new MessageResponse("update item_data success"));
    }

}