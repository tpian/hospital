package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dto.Employer;
import com.dto.Patient;
import com.util.DBHelp;
import com.util.StringHelp;

public class PatientModel {
	//增加病人信息
	public boolean addPatient(Patient p) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "insert into patient(room,name,sex,entertime,doctor,section,cation,bed,urgency) values (?,?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, p.getRoom());
			pst.setString(2, p.getName());
			pst.setString(3, p.getSex());
			pst.setTimestamp(4, new Timestamp(p.getEnetertime().getTime()));
			pst.setString(5, p.getDoctor());
			pst.setString(6, p.getSection());
			pst.setString(7, p.getCation());
			pst.setInt(8, p.getBed());
			pst.setInt(9, p.getUrgency());


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
	
//	查找最紧急，入院最久病人的id
	public int queryMostUrgentPatientId() {
		String sql = "select id from patient order by urgency desc,entertime asc;";
		Connection conn = DBHelp.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int i = 0;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);	
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return i;
	}
	
	//根据id查找病人
	public Patient queryOne(int id) {
		Patient p = new Patient();
		String sql = "select id,name,sex,doctor,section,entertime,room,bed,cation,urgency from patient where id="+id;
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setSex(rs.getString(3));
				p.setDoctor(rs.getString(4));
				p.setSection(rs.getString(5));
				p.setEnetertime(rs.getDate(6));
				p.setRoom(rs.getString(7));
				p.setBed(rs.getShort(8));
				p.setCation(rs.getString(9));
				p.setUrgency(rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return p;
	}
	
	//删除病人信息
	public boolean DelPatient(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = DBHelp.getConnection();
			String sql = "DELETE FROM patient WHERE id = "+id;
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
	//更新病人信息
	public boolean uptPatient(Patient p, int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update patient set name=?,sex=?,doctor=?,section=?,room=?,bed=?,cation=? where id="+id;
			pst = conn.prepareStatement(sql);
			pst.setString(1, p.getName());
			pst.setString(2, p.getSex());
			pst.setString(3, p.getDoctor());
			pst.setString(4, p.getSection());
			pst.setString(5, p.getRoom());
			pst.setInt(6, p.getBed());
			pst.setString(7, p.getCation());

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
//取出最大号的病例号码
	public int queryId() {
		int i = 0;
		String sql = "select MAX(id) from patient";
		PreparedStatement pst = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DBHelp.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				i=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(rs);
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}

		return i;
	}
	

}
