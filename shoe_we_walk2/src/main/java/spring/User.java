package spring;


public class User {
	private long user_id;
	private String name;
	private String gender;
	private int age;
	private int height;
	private double weight;
	private int total_item;
	private int balance;

	public User(long user_id, String name, String gender, int age, int height, double weight,
			int total_item, int balance) {
		this.user_id=user_id;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.height=height;
		this.weight=weight;
		this.total_item=total_item;
		this.balance=balance;
	}
	
	public User(UserRegisterRequest req) {
		this.user_id=req.getUser_id();
		this.name=req.getName();
		this.gender=req.getGender();
		this.age=req.getAge();
		this.height=req.getHeight();
		this.weight=req.getWeight();
		this.total_item=0;
		this.balance=0;
	}
	
	public User(UserRegisterRequest req, int total_item, int balance) {
		this.user_id=req.getUser_id();
		this.name=req.getName();
		this.gender=req.getGender();
		this.age=req.getAge();
		this.height=req.getHeight();
		this.weight=req.getWeight();
		this.total_item=total_item;
		this.balance=balance;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getTotal_item() {
		return total_item;
	}
	
	public int getBalance() {
		return balance;
	}
}
