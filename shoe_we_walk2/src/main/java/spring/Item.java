package spring;

public class Item {
	private long user_id;
	private int item_id;
	private int item_cnt;
	private int price;
	
	public Item(long user_id, int item_id, int item_cnt, int price) {
		this.user_id=user_id;
		this.item_id=item_id;
		this.item_cnt=item_cnt;
		this.price=price;
	}
	
	public Item(ItemRegisterRequest req) {
		this.user_id=req.getUser_id();
		this.item_id=req.getItem_id();
		this.item_cnt=req.getItem_cnt();
		this.price=req.getPrice();
	}
	
	void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	public int getItem_id() {
		return item_id;
	}
	
	public int getItem_cnt() {
		return item_cnt;
	}
	
	public int getPrice() {
		return price;
	}
	
	
}
