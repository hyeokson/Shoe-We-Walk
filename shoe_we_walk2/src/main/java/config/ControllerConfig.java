package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RestMemberController;
import spring.UserDao;
import spring.ItemDao;
import spring.ItemLocDao;
import spring.WorkDao;
import spring.Service;
import controller.SmsController;

@Configuration
public class ControllerConfig {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	WorkDao workDao;
	
	@Autowired
	ItemLocDao itemLocDao;
	
	@Autowired
	Service service;
	
	@Bean
	public RestMemberController restApi() {
		RestMemberController cont=new RestMemberController();
		cont.setUserDao(userDao);
		cont.setItemDao(itemDao);
		cont.setWorkDao(workDao);
		cont.setItemLocDao(itemLocDao);
		cont.setService(service);
		return cont;
	}
	
	@Bean
	public SmsController smsApi() {
		SmsController cont=new SmsController();
		return cont;
	}
	
}
