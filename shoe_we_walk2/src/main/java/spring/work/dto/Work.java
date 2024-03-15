package spring.work.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Work {
	private long user_id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime work_date;
	private int step_num;
	private float work_dist;
	private int calories;
	
	public Work(long user_id, LocalDateTime work_date, int step_num,
				float work_dist, int calories) {
		this.user_id=user_id;
		this.work_date=work_date;
		this.step_num=step_num;
		this.work_dist=work_dist;
		this.calories=calories;
	}
	
	public Work(WorkRegisterRequest req) {
	this.user_id=req.getUser_id();
	this.work_date=req.getWork_date();
	this.step_num=req.getStep_num();
	this.work_dist=req.getWork_dist();
	this.calories=req.getCalories();
}
	
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	public LocalDateTime getWork_date() {
		return work_date;
	}
	
	public int getStep_num() {
		return step_num;
	}
	
	public float getWork_dist() {
		return work_dist;
	}
	
	public int getCalories() {
		return calories;
	}
}
