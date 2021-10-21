package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Admin;
import com.dto.Drug;
import com.util.DBHelp;

public class AdminModel {
	//校验用户
	public Admin validate(Admin admin) {
		Admin a = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "select id,name,password,power from admin where name=? and password=? and power=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getPassword());
			pst.setString(3, admin.getPower());
			rs = pst.executeQuery();
			if (rs.next()) {
				a = new Admin();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setPassword(rs.getString("password"));
				a.setPower(rs.getString("power"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return a;
	}
	//增加用户
	public boolean addAdmin(Admin admin) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into admin(name,password,power) values(?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getPassword());
			pst.setString(3, admin.getPower());
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
	//删除用户
	public boolean DelAdmin(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM admin WHERE id = "+id;
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
	//更新用户信息
	public boolean uptAdmin(Admin admin, int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update admin set power=? where id = "+id;
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getPower());
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
	//根据id找用户
	//校验用户
	public Admin queryOne(int id) {
		Admin a = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "select id,name,power from admin where id="+id;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				a = new Admin();
				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setPower(rs.getString("power"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return a;
	}
}
