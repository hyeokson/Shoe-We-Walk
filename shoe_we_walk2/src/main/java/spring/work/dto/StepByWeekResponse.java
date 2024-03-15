package spring;

import java.util.List;

public class StepByWeekResponse {
	public int sun;
	public int mon;
	public int tue;
	public int wed;
	public int thu;
	public int fri;
	public int sat;
	
	public StepByWeekResponse(List<Integer> list) {
		sun=list.get(0);
		mon=list.get(1);
		tue=list.get(2);
		wed=list.get(3);
		thu=list.get(4);
		fri=list.get(5);
		sat=list.get(6);
	}
}
