package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Dept;
import com.util.DBHelp;

public class DeptModel {
	public List<Dept> queryAll(String kind) {
		List<Dept> list = new ArrayList<Dept>();
		String sql = "select name,kind from dept where kind=?";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, kind);
			rs = pst.executeQuery();
			while (rs.next()) {
				Dept one = new Dept();
				one.setName(rs.getString(1));
				one.setKind(rs.getString(2));
				list.add(one);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return list;
	}
	public List queryAll() {
		List list = new ArrayList();
		String sql = "select name from dept";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {	
				list.add(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return list;
	}
}
