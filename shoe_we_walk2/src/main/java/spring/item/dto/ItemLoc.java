package spring.item.dto;

public class ItemLoc {
	private long user_id;
	private int loc_1;
	private int loc_2;
	private int loc_3;
	private int loc_4;
	private int loc_5;
	private int loc_6;
	private int loc_7;
	private int loc_8;
	private int loc_9;
	private int loc_10;
	
	public ItemLoc(long user_id,
			int loc_1, int loc_2, int loc_3, int loc_4, int loc_5,
			int loc_6, int loc_7, int loc_8, int loc_9, int loc_10) {
		this.user_id=user_id;
		this.loc_1=loc_1;
		this.loc_2=loc_2;
		this.loc_3=loc_3;
		this.loc_4=loc_4;
		this.loc_5=loc_5;
		this.loc_6=loc_6;
		this.loc_7=loc_7;
		this.loc_8=loc_8;
		this.loc_9=loc_9;
		this.loc_10=loc_10;
	}
	
	public ItemLoc(ItemLocRegisterRequest req) {
		this.user_id=req.getUser_id();
		this.loc_1=req.getLoc_1();
		this.loc_2=req.getLoc_2();
		this.loc_3=req.getLoc_3();
		this.loc_4=req.getLoc_4();
		this.loc_5=req.getLoc_5();
		this.loc_6=req.getLoc_6();
		this.loc_7=req.getLoc_7();
		this.loc_8=req.getLoc_8();
		this.loc_9=req.getLoc_9();
		this.loc_10=req.getLoc_10();
	}
	
	void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	public int getLoc_1() {return loc_1;}
	public int getLoc_2() {return loc_2;}
	public int getLoc_3() {return loc_3;}
	public int getLoc_4() {return loc_4;}
	public int getLoc_5() {return loc_5;}
	public int getLoc_6() {return loc_6;}
	public int getLoc_7() {return loc_7;}
	public int getLoc_8() {return loc_8;}
	public int getLoc_9() {return loc_9;}
	public int getLoc_10() {return loc_10;}
}
