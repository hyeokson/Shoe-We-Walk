package spring.work.controller;

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
public class WorkController{

    private final WorkService workService;
    private final UserService userService;

    WorkController(WorkService workService, UserService userService){
        this.workService=workService;
        this.userService=userService;
    }

    @PostMapping("/api/regist/work")
    public ResponseEntity<Object> registWork(@RequestBody WorkRegisterRequest req) {
        if(!userService.isUserExist(req.getUser_id())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }

        workService.registWork(req);
        return ResponseEntity.ok(new MessageResponse("register work_data success"));
    }

    @GetMapping("/api/get/work")
    public ResponseEntity<Object> getWork(@RequestParam("user_id") long user_id,
                                          @RequestParam("work_date1") String work_date1, @RequestParam("work_date2") String work_date2) {
        if(!userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        List<Work> work;
        if((work=workService.getWork(user_id, work_date1, work_date2))==null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no work_data in DB"));
        }
        return ResponseEntity.ok(work);
    }
    @GetMapping("/api/get/weekwork")
    public ResponseEntity<Object> getWeekWork(@RequestParam("user_id") long user_id) {
        if(!userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(workService.getWeekWork(user_id));
    }
    @GetMapping("/api/get/monthwork")
    public ResponseEntity<Object> getMonthWork(@RequestParam("user_id") long user_id) {
        if(!userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(workService.getMonthWork(user_id));
    }
    @GetMapping("/api/get/yearwork")
    public ResponseEntity<Object> getYearWork(@RequestParam("user_id") long user_id) {
        if(!userService.isUserExist(user_id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponse("no user_data in DB"));
        }
        return ResponseEntity.ok(workService.getYearWork(user_id));
    }

}
