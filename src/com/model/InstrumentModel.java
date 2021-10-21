package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dto.Instrument;
import com.util.DBHelp;

public class InstrumentModel {
	public boolean addinstrument(Instrument instrument) {
		// 增加设备
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into instrument values(?,?,?,?,?);";
			pst = conn.prepareStatement(sql);
			pst.setString(1, instrument.getReplace());
			pst.setString(2, instrument.getName());
			pst.setFloat(3, instrument.getPrice());
			pst.setInt(4, instrument.getNum());
			pst.setString(5, instrument.getRemarks());

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

	// 根据代号查找出设备
	public Instrument queryOne(String replace) {
		Instrument one = new Instrument();
		String sql = "select replace,name,price,num,remarks from instrument where replace = ?";
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

	// 更新设备
	public boolean uptinstrument(Instrument instrument, String replace) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update instrument set replace=?,name=?,price=?,num=?,remarks=? where replace = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, instrument.getReplace());
			pst.setString(2, instrument.getName());
			pst.setFloat(3, instrument.getPrice());
			pst.setInt(4, instrument.getNum());
			pst.setString(5, instrument.getRemarks());
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


	//查找所有的代号
	public String[] replace() {
		String[] str = new String[30];
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		

		try {
			conn = DBHelp.getConnection();
			String sql = "select replace,name,price,num,remarks from instrument";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			
			int i = 0;
			while (rs.next()) {
				str[i] = rs.getString(1);
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
	// 删除设备信息
	public boolean DelStudent(String replace) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM instrument WHERE replace = ?;";
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
