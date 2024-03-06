package spring;

import java.util.List;

public class YearStepNum {
	public int month1;
	public int month2;
	public int month3;
	public int month4;
	public int month5;
	public int month6;
	public int month7;
	public int month8;
	public int month9;
	public int month10;
	public int month11;
	public int month12;
	
	public YearStepNum(List<Integer> list) {	
		month1=list.get(0);
		month2=list.get(1);
		month3=list.get(2);
		month4=list.get(3);
		month5=list.get(4);
		month6=list.get(5);
		month7=list.get(6);
		month8=list.get(7);
		month9=list.get(8);
		month10=list.get(9);
		month11=list.get(10);
		month12=list.get(11);
	}
}
