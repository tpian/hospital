package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Drug;
import com.dto.Salary;
import com.util.DBHelp;

public class SalaryModel {
	//增加工资信息
	public boolean addSalary(Salary salary) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into salary values(?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, salary.getEmployerid());
			pst.setString(2, salary.getLevel());
			pst.setFloat(3, salary.getMoney());
			if (pst.executeUpdate() > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return flag;
	}
	//删除工资信息
	public boolean DelSalary(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM salary WHERE employid = "+id;
			pst = conn.prepareStatement(sql);
			if (pst.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return flag;
	}

	// 更新药剂
	public boolean uptSalary(Salary salary, String employerid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update salary set level=?,money=? where employid = "+employerid;
			pst = conn.prepareStatement(sql);
			pst.setString(1, salary.getLevel());
			pst.setFloat(2, salary.getMoney());


			if (pst.executeUpdate() > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return flag;
	}
	//根据员工号查找工资信息
	public Salary queryOne(String employerid) {
		Salary one = new Salary();
		String sql = "select employid,level,money from salary where employid = "+employerid;
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				one.setEmployerid(rs.getString(1));
				one.setLevel(rs.getString(2));
				one.setMoney(rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return one;
	}
}
