package com.salary;

import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dto.Title;
import com.model.DrugModel;
import com.model.TableModel;

public class SalaryTableFrame extends JInternalFrame {
	private DefaultTableModel table;
	private JTable jtable;

	public SalaryTableFrame() {
		this.setSize(800, 450);
		String sql = "select employid,employer.name,dept,level,money " +
				"from salary,employer where salary.employid = employer.id";
		TableModel model = new TableModel();

		Vector list = model.query(sql, 5);
		table = new DefaultTableModel(list, Title.salarytitle());
		jtable = new JTable(table);
		// 将表格添加到JScollPane中
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setViewportView(jtable);
		this.setClosable(true);
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}
}