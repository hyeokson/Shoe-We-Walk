package spring;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
	private UserDao userDao;
	private WorkDao workDao;
	private ItemDao itemDao;
	private ItemLocDao itemLocDao;

	public Service(UserDao userDao, WorkDao workDao, ItemDao itemDao, ItemLocDao itemLocDao) {
		this.userDao = userDao;
		this.workDao = workDao;
		this.itemDao = itemDao;
		this.itemLocDao=itemLocDao;
	}
	//user
	public boolean isUserExist(long user_id) {
		if(userDao.select(user_id)==null)
			return false;
		return true;
	}
	public void registUser(UserRegisterRequest req) {
		User user=new User(req);
		userDao.insert(user);
		List<Integer> price= new ArrayList<>();
		price.add(250); 
		price.add(400); 
		price.add(50); 
		price.add(100); 
		price.add(50);
		price.add(50); 
		price.add(200); 
		price.add(300); 
		price.add(150); 
		price.add(120);
		for(int i=1; i<=10; i++) {
			itemDao.insert(new Item(req.getUser_id(), i, 0, price.get(i-1)));
		}
		itemLocDao.insert(new ItemLoc(req.getUser_id(), 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0));
	}
	public User getUser(long user_id) {
		return userDao.select(user_id);
	}
	public void updateUser(UserRegisterRequest req) {
		int item_cnt;
		int balance;
		User user;
		user=userDao.select(req.getUser_id()); 
		item_cnt=user.getTotal_item();
		balance=user.getBalance();
		
		User user2=new User(req, item_cnt, balance);
		userDao.update(user2);
	}
	//item_loc
	public void updateItemLoc(ItemLocRegisterRequest req) {
		itemLocDao.update(req);
	}
	public ItemLoc getItemLoc(long user_id) {
		return itemLocDao.select(user_id);
	}
	//item
	public void updateItem(long user_id, int item_id, int add) {
		Item item=itemDao.select(user_id, item_id);
		int price=item.getPrice();
		Item item2=new Item(user_id, item_id, item.getItem_cnt()+add, price);
		itemDao.update(item2);
		
		User user=userDao.select(user_id);
		User user2=new User(user_id, user.getName(), user.getGender(), user.getAge(), user.getHeight(),
				user.getWeight(), user.getTotal_item()+add, user.getBalance()-price);
		userDao.update(user2);
	}
	public Item getItem(long user_id, int item_id) {
		return itemDao.select(user_id, item_id);
	}
	public List<Item> getAllItem(long user_id) {
		return itemDao.select_all(user_id);
	}
	//work
	public void registWork(WorkRegisterRequest req) {
		workDao.insert(req);
		User user=userDao.select(req.getUser_id());
		User user2=new User(user.getUser_id(), user.getName(), user.getGender(), user.getAge(), user.getHeight(),
				user.getWeight(), user.getTotal_item(), user.getBalance()+req.getStep_num()/1000);
		userDao.update(user2);
	}
	public List<Work> getWork(long user_id, String work_date1, String work_date2){
		return workDao.select(user_id, work_date1, work_date2);
	}
	//월요일부터 일요일까지 1~7
	public WeekStepNum getWeekWork(long user_id) {
		List<Integer> list=new ArrayList<>();
		LocalDateTime dateTime = LocalDateTime.now();
		DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();
		if(dayOfWeekNumber==7)
			dayOfWeekNumber=0;
		for(int i=0; i<7; i++) {
			LocalDateTime t1, t2;
			if(dayOfWeekNumber-i>=0) {
				t1=dateTime.minusDays(dayOfWeekNumber-i).withHour(0).withMinute(0).withSecond(0);
				t2=dateTime.minusDays(dayOfWeekNumber-i).withHour(23).withMinute(59).withSecond(59);
			}
			else {
				t1=dateTime.plusDays(i-dayOfWeekNumber).withHour(0).withMinute(0).withSecond(0);
				t2=dateTime.plusDays(i-dayOfWeekNumber).withHour(23).withMinute(59).withSecond(59);
			}
			List<Work> work=workDao.select(user_id, t1, t2);
			int stepSum=0;
			if(work!=null)
				for(Work w : work) {
					stepSum+=w.getStep_num();
				}
			list.add(stepSum);
		}
		WeekStepNum week_step_num=new WeekStepNum(list);
		return week_step_num;
	}
	public MonthStepNum getMonthWork(long user_id) {
		List<Integer> list=new ArrayList<>();
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDate date=dateTime.toLocalDate();
		int endDate=date.lengthOfMonth();
		
		DayOfWeek dayOfWeek = date.withDayOfMonth(1).getDayOfWeek();
		int dayOfWeekNumber = dayOfWeek.getValue();
		if(dayOfWeekNumber==7)
			dayOfWeekNumber=0;
		
		for(int i=0; i<5; i++) {
			LocalDateTime t1, t2;
			boolean calculateEnd=false;
			if(i==0) {
				t1=dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
				t2=dateTime.withDayOfMonth(1).plusDays(6-dayOfWeekNumber).withHour(23).withMinute(59).withSecond(59);
			}
			else if((7-dayOfWeekNumber+(i-1)*7+1)<=endDate && (7-dayOfWeekNumber+i*7)>=endDate){
				t1=dateTime.withDayOfMonth(7-dayOfWeekNumber+(i-1)*7+1).withHour(0).withMinute(0).withSecond(0);
				t2=dateTime.withDayOfMonth(endDate).withHour(23).withMinute(59).withSecond(59);
				calculateEnd=true;
			}
			else {
				t1=dateTime.withDayOfMonth(7-dayOfWeekNumber+(i-1)*7+1).withHour(0).withMinute(0).withSecond(0);
				t2=dateTime.withDayOfMonth(7-dayOfWeekNumber+i*7).withHour(23).withMinute(59).withSecond(59);
			}
			
			List<Work> work=workDao.select(user_id, t1, t2);
			int stepSum=0;
			if(work!=null)
				for(Work w : work) {
					stepSum+=w.getStep_num();
				}
			list.add(stepSum);
			
			if(calculateEnd) {
				if(i==3)
					list.add(0);
				break;
			}
		}
		MonthStepNum month_step_num=new MonthStepNum(list);
		return month_step_num;
	}
	public YearStepNum getYearWork(long user_id) {
		List<Integer> list=new ArrayList<>();
		LocalDateTime dateTime = LocalDateTime.now();
		for(int i=0; i<12; i++) {
			LocalDateTime t1, t2;
			LocalDate date=dateTime.toLocalDate().withMonth(i+1);
			int endDate=date.lengthOfMonth();
			t1=dateTime.withMonth(i+1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
			t2=dateTime.withMonth(i+1).withDayOfMonth(endDate).withHour(23).withMinute(59).withSecond(59);
			List<Work> work=workDao.select(user_id, t1, t2);
			int stepSum=0;
			if(work!=null)
				for(Work w : work) {
					stepSum+=w.getStep_num();
				}
			list.add(stepSum);
		}
		YearStepNum year_step_num=new YearStepNum(list);
		return year_step_num;
	}
}
