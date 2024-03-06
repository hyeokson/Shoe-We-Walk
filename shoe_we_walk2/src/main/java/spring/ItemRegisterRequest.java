package spring;

public class ItemRegisterRequest {
	private long user_id;
	private int item_id;
	private int item_cnt;
	private int price;
	
	void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	public void setItem_id(int item_id) {
		this.item_id=item_id;
	}
	
	public int getItem_id() {
		return item_id;
	}
	
	public int getItem_cnt() {
		return item_cnt;
	}
	
	public void setItem_cnt(int item_cnt) {
		this.item_cnt=item_cnt;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
}
