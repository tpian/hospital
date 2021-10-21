package com.dto;

public class Salary {
	private String employerid;//员工号
	private String level;//工资级别
	private float money;//工资金额

	public String getEmployerid() {
		return employerid;
	}
	public void setEmployerid(String employerid) {
		this.employerid = employerid;
	}

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
}
