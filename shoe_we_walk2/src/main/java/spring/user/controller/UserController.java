package spring.user.controller;

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
public class UserController{

    UserService userService;

    UserController(UserService userService) {this.userService=userService;}

    @GetMapping("/api/exist/user")
    public ResponseEntity<Object> isUserExist(@RequestParam("user_id") long user_id){
        if(userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new MessageResponse("already user_data in DB"));
        }
        return ResponseEntity.ok(new MessageResponse("register user_data available"));
    }
    @PostMapping("/api/regist/user")
    public ResponseEntity<Object> registUser(@RequestBody UserRegisterRequest req) {
        userService.registUser(req);
        return ResponseEntity.ok(new MessageResponse("register user_data success"));
    }
    @GetMapping("/api/get/user")
    public ResponseEntity<Object> getUser(@RequestParam("user_id") long user_id){
        if(!userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(service.getUser(user_id));
    }
    @PostMapping("/api/update/user")
    public ResponseEntity<Object> updateUser(@RequestBody UserRegisterRequest req) {
        if(!userService.isUserExist(req.getUser_id())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }

        userService.updateUser(req);
        return ResponseEntity.ok(new MessageResponse("update user_data success"));
    }
}