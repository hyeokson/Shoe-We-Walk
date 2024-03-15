package spring.work.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkRegisterRequest {
	private long user_id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime work_date;
	private int step_num;
	private float work_dist;
	private int calories;
	
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getUser_id() {
		return user_id;
	}
	
	public LocalDateTime getWork_date() {
		return work_date;
	}
	
	public void setWork_date(LocalDateTime work_date) {
		this.work_date=work_date;
	}
	
	public int getStep_num() {
		return step_num;
	}
	
	public void setStep_num(int step_num) {
		this.step_num=step_num;
	}
	
	public float getWork_dist() {
		return work_dist;
	}
	
	public void setWork_dist(float work_dist) {
		this.work_dist=work_dist;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setCalories(int calories) {
		this.calories=calories;
	}
}
