package com.employer;

import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dto.Title;
import com.model.TableModel;

public class EmployerTableFrame extends JInternalFrame{
	private DefaultTableModel table;
	private JTable jtable;
	public EmployerTableFrame(){
		this.setSize(880,520);
		String sql="select id,dept,name,sex,idcard,birthday,origo," +
				"nationlity,nation,marriage,health,worktime,address,tel from employer";
		TableModel model = new TableModel();
		
		Vector list = model.query(sql,14);
		table = new DefaultTableModel(list,Title.employertitle());
		jtable = new JTable(table);
		
		// 将表格添加到JScollPane中
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setViewportView(jtable);
		this.setClosable(true);
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}
}
