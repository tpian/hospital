package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.Drug;
import com.util.DBHelp;

public class DrugModel {
	// 增加药剂
	public boolean addDrug(Drug drug) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into drug values(?,?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, drug.getReplace());
			pst.setString(2, drug.getName());
			pst.setFloat(3, drug.getPrice());
			pst.setInt(4, drug.getNum());
			pst.setString(5, drug.getRemarks());

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

	// 根据代号查找出药剂
	public Drug queryOne(String replace) {
		Drug one = new Drug();
		String sql = "select replace,name,price,num,remarks from drug where replace = ?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, replace);
			rs = pst.executeQuery();
			while (rs.next()) {
				one.setReplace(rs.getString(1));
				one.setName(rs.getString(2));
				one.setPrice(rs.getInt(3));
				one.setNum(rs.getInt(4));
				one.setRemarks(rs.getString(5));
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

	// 更新药剂
	public boolean uptDrug(Drug drug, String replace) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update drug set replace=?,name=?,price=?,num=?,remarks=? where replace = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, drug.getReplace());
			pst.setString(2, drug.getName());
			pst.setFloat(3, drug.getPrice());
			pst.setInt(4, drug.getNum());
			pst.setString(5, drug.getRemarks());
			pst.setString(6, replace);

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

	// 删除药剂信息
	public boolean DelStudent(String replace) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM drug WHERE replace = ?;";
			pst = conn.prepareStatement(sql);
			pst.setString(1, replace);
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
}
