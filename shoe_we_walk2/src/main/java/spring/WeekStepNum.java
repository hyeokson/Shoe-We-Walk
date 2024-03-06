package spring;

import java.util.List;

public class WeekStepNum {
	public int day1;
	public int day2;
	public int day3;
	public int day4;
	public int day5;
	public int day6;
	public int day7;
	
	public WeekStepNum(List<Integer> list) {	
		day1=list.get(0);
		day2=list.get(1);
		day3=list.get(2);
		day4=list.get(3);
		day5=list.get(4);
		day6=list.get(5);
		day7=list.get(6);
	}
}
