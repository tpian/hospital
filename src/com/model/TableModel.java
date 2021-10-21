package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.util.DBHelp;

public class TableModel {
	public Vector query(String sql,int i) {
		Vector list = new Vector();
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;

		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Vector v = new Vector();
				for(int j=1;j<=i;j++){
					v.add(rs.getString(j));
				}
				list.add(v);
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
}
