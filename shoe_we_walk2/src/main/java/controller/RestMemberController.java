package controller;

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
public class RestMemberController {
	
	UserDao userDao;
	ItemDao itemDao;
	WorkDao workDao;
	ItemLocDao itemLocDao;
	Service service;
	
	@GetMapping("/api/exist/user")
	public ResponseEntity<Object> isUserExist(@RequestParam("user_id") long user_id){
		if(service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(new MessageResponse("already user_data in DB"));
		}
		return ResponseEntity.ok(new MessageResponse("register user_data available"));
	}
	@PostMapping("/api/regist/user")
	public ResponseEntity<Object> registUser(@RequestBody UserRegisterRequest req) {
		service.registUser(req);
		return ResponseEntity.ok(new MessageResponse("register user_data success"));
	}
	@GetMapping("/api/get/user")
	public ResponseEntity<Object> getUser(@RequestParam("user_id") long user_id){
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getUser(user_id));
	}
	@PostMapping("/api/update/user")
	public ResponseEntity<Object> updateUser(@RequestBody UserRegisterRequest req) {
		if(!service.isUserExist(req.getUser_id())) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		
		service.updateUser(req);
		return ResponseEntity.ok(new MessageResponse("update user_data success"));
	}
	
	@GetMapping("/api/get/itemloc")
	public ResponseEntity<Object> getItemLoc(@RequestParam("user_id") long user_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getItemLoc(user_id));
	}
	
	@PostMapping("/api/update/itemloc")
	public ResponseEntity<Object> updateItemLoc(@RequestBody ItemLocRegisterRequest req) {
		if(!service.isUserExist(req.getUser_id())) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		service.updateItemLoc(req);
		return ResponseEntity.ok(new MessageResponse("update itemloc success"));
	}
	
	@GetMapping("/api/get/item")
	public ResponseEntity<Object> getItem(@RequestParam("user_id") long user_id, @RequestParam("item_id") int item_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getItem(user_id, item_id));
	}
	
	@GetMapping("/api/getAll/item")
	public ResponseEntity<Object> getAllItem(@RequestParam("user_id") long user_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getAllItem(user_id));
	}
	
	@GetMapping("/api/update/item")
	public ResponseEntity<Object> updateItem(@RequestParam("user_id") long user_id, 
			@RequestParam("item_id") int item_id,
			@RequestParam("add") int add) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		service.updateItem(user_id, item_id, add);
		return ResponseEntity.ok(new MessageResponse("update item_data success"));
	}
	
	@PostMapping("/api/regist/work")
	public ResponseEntity<Object> registWork(@RequestBody WorkRegisterRequest req) {
		if(!service.isUserExist(req.getUser_id())) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		
		service.registWork(req);
		return ResponseEntity.ok(new MessageResponse("register work_data success"));
	}
	
	@GetMapping("/api/get/work")
	public ResponseEntity<Object> getWork(@RequestParam("user_id") long user_id, 
			@RequestParam("work_date1") String work_date1, @RequestParam("work_date2") String work_date2) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		List<Work> work;
		if((work=service.getWork(user_id, work_date1, work_date2))==null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no work_data in DB"));
		}
		return ResponseEntity.ok(work);
	}
	@GetMapping("/api/get/weekwork")
	public ResponseEntity<Object> getWeekWork(@RequestParam("user_id") long user_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getWeekWork(user_id));
	}
	@GetMapping("/api/get/monthwork")
	public ResponseEntity<Object> getMonthWork(@RequestParam("user_id") long user_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getMonthWork(user_id));
	}
	@GetMapping("/api/get/yearwork")
	public ResponseEntity<Object> getYearWork(@RequestParam("user_id") long user_id) {
		if(!service.isUserExist(user_id)) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse("no user_data in DB"));
		}
		return ResponseEntity.ok(service.getYearWork(user_id));
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao=itemDao;
	}
	
	public void setWorkDao(WorkDao workDao) {
		this.workDao=workDao;
	}
	
	public void setItemLocDao(ItemLocDao itemLocDao) {
		this.itemLocDao=itemLocDao;
	}

	public void setService(Service service) {
		this.service=service;
	}
	
	
}
