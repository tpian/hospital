package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Drug;
import com.dto.Employer;
import com.dto.Instrument;
import com.util.DBHelp;
import com.util.StringHelp;

public class EmployerModel {
	// 增加员工
	public boolean addEmployer(Employer emp) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into employer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getId());
			pst.setString(2, emp.getDept());
			pst.setString(3, emp.getName());
			pst.setString(4, emp.getSex());
			pst.setString(5, emp.getIdcard());
			pst.setDate(6, StringHelp.convertFormUtilDate(emp.getBirthday()));
			pst.setString(7, emp.getOrigo());
			pst.setString(8, emp.getNationality());
			pst.setString(9, emp.getNation());
			pst.setString(10, emp.getMarriage());
			pst.setString(11, emp.getHealth());
			pst.setDate(12, StringHelp.convertFormUtilDate(emp.getWorktime()));
			pst.setString(13, emp.getAddress());
			pst.setString(14, emp.getTel());

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
	//根据员工号查员工信息
	public Employer queryOne(String id) {
		Employer emp = new Employer();
		String sql = "select id,dept,name,sex,idcard,birthday,origo,nationlity,nation,marriage,health,worktime,address,tel from employer where id="+id;
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(3));
				emp.setBirthday(rs.getDate(6));
				emp.setWorktime(rs.getDate(12));
				emp.setAddress(rs.getString(13));
				emp.setIdcard(rs.getString(5));
				emp.setTel(rs.getString(14));
				emp.setSex(rs.getString(4));
				emp.setDept(rs.getString(2));
				emp.setOrigo(rs.getString(7));
				emp.setNation(rs.getString(9));
				emp.setNationality(rs.getString(8));
				emp.setMarriage(rs.getString(10));
				emp.setHealth(rs.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return emp;
	}
	//删除员工
	public boolean DelEmployer(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM employer WHERE id = "+id;
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
//修改员工信息
	public boolean uptemployer(Employer emp, String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update employer set id=?,dept=?,name=?,sex=?," +
					"idcard=?,birthday=?,origo=?,nationlity=?,nation=?," +
					"marriage=?,health=?,worktime=?,address=?,tel=? where id= "+id;
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getId());
			pst.setString(2, emp.getDept());
			pst.setString(3, emp.getName());
			pst.setString(4, emp.getSex());
			pst.setString(5, emp.getIdcard());
			pst.setDate(6, StringHelp.convertFormUtilDate(emp.getBirthday()));
			pst.setString(7, emp.getOrigo());
			pst.setString(8, emp.getNationality());
			pst.setString(9, emp.getNation());
			pst.setString(10, emp.getMarriage());
			pst.setString(11, emp.getHealth());
			pst.setDate(12,StringHelp.convertFormUtilDate(emp.getWorktime()));
			pst.setString(13, emp.getAddress());
			pst.setString(14, emp.getTel());

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
}
