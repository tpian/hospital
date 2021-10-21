package com.dto;

import java.util.Vector;

public class Title {
	
	public static Vector drugtitle(){
		String[] names = { "药剂代号", "药剂名称", "药剂价格", "数量", "备注"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		title.add(names[3]);
		title.add(names[4]);
		return title;
	}
	
	public static Vector employertitle(){
		String[] names = { "员工号", "部门", "姓名", "性别", "身份证号","生日","籍贯","国籍",
				"民族","婚姻状况","健康状况","工作时间","家庭住址","电话"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		title.add(names[3]);
		title.add(names[4]);
		title.add(names[5]);
		title.add(names[6]);
		title.add(names[7]);
		title.add(names[8]);
		title.add(names[9]);
		title.add(names[10]);
		title.add(names[11]);
		title.add(names[12]);
		title.add(names[13]);
		return title;
	}
	public static Vector patienttitle(){
		String[] names = { "病例号", "姓名", "性别", "主治医生", "所属科室","入院时间","病房","病床","症状"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		title.add(names[3]);
		title.add(names[4]);
		title.add(names[5]);
		title.add(names[6]);
		title.add(names[7]);
		title.add(names[8]);
		return title;
	}	
	
	public static Vector salarytitle(){
		String[] names = { "员工号", "姓名", "部门", "工资级别", "金额"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		title.add(names[3]);
		title.add(names[4]);
		return title;
	}
	public static Vector bedtitle(){
		String[] names = { "病房号", "病床号", "病人病例号", "病人姓名", "科室","主治医生","状况","入院时间"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		title.add(names[3]);
		title.add(names[4]);
		title.add(names[5]);
		title.add(names[6]);
		title.add(names[7]);
		return title;
	}
	
	public static Vector admintitle(){
		String[] names = { "编号", "用户名", "权限"};
		Vector title = new Vector();
		title.add(names[0]);
		title.add(names[1]);
		title.add(names[2]);
		return title;
	}
}
