package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBHelp;

public class ComboModel {
	public String[] combo(String sql){
		String[] str = null;
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			int n = 0;
			while (rs.next()) {
				n++;
			}
			str = new String[n];
			rs = pst.executeQuery();
			int i = 0;
			while(rs.next()){
				str[i]=rs.getString(1);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
		return str;
	}
	
}
