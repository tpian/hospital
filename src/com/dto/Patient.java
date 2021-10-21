package com.dto;

import java.util.Date;

public class Patient {
	private int id;
	private int bed;
	private String room;
	private String doctor;
	private String name;//姓名
	private String sex;//性别
	private Date enetertime;//入院时间
	private String section;//病人所属科室
	private String cation;//病人状况

	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getEnetertime() {
		return enetertime;
	}
	public void setEnetertime(Date enetertime) {
		this.enetertime = enetertime;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCation() {
		return cation;
	}
	public void setCation(String cation) {
		this.cation = cation;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
