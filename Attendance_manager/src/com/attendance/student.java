package com.attendance;

public class student {
       
	private String name;
	private int rollNo;
	private int attend;
	private int total;
	private double  percentage ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public student( int rollNo, String name) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		
	}
	public student(int rollNo,String name, int attend, int total, double percentage) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.attend = attend;
		this.total = total;
		this.percentage = percentage;
	}
	
	
	
	
}
