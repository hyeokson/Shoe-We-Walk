package spring;

import java.util.List;

public class MonthStepNum {
	public int week1;
	public int week2;
	public int week3;
	public int week4;
	public int week5;
	
	public MonthStepNum(List<Integer> list) {	
		week1=list.get(0);
		week2=list.get(1);
		week3=list.get(2);
		week4=list.get(3);
		week5=list.get(4);
	}
}
