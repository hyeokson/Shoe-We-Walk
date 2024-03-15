package spring;

import java.util.List;

public class StepByYearResponse {
	public int jan;
	public int feb;
	public int mar;
	public int apr;
	public int may;
	public int jun;
	public int jul;
	public int aug;
	public int sep;
	public int oct;
	public int nov;
	public int dec;
	
	public StepByYearResponse(List<Integer> list) {
		jan=list.get(0);
		feb=list.get(1);
		mar=list.get(2);
		apr=list.get(3);
		may=list.get(4);
		jun=list.get(5);
		jul=list.get(6);
		aug=list.get(7);
		sep=list.get(8);
		oct=list.get(9);
		nov=list.get(10);
		dec=list.get(11);
	}
}
