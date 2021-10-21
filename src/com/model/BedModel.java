package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dto.Bed;
import com.util.DBHelp;

public class BedModel {
	// 更新病床信息
	public boolean uptBed(Bed bed) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBHelp.getConnection();
			String sql = "update bed set patientid =? where room=? and bed =? ";
			pst = conn.prepareStatement(sql);
			if (bed.getPatientid() == 0) {
				pst.setString(1,null);
			}
			else{
				pst.setInt(1,bed.getPatientid());
			}
			pst.setString(2, bed.getRoom());
			pst.setInt(3, bed.getId());

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
