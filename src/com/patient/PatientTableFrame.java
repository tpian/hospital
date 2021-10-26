
package com.patient;

import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dto.Title;
import com.model.TableModel;



public class PatientTableFrame extends JInternalFrame {
	private DefaultTableModel table;
	private JTable jtable;
	public PatientTableFrame(){
		this.setSize(880,520);
		String sql="select id,name,sex,urgency,doctor,section,entertime,room,bed,cation from patient order by urgency desc,entertime asc;";
		TableModel model = new TableModel();
		
		Vector list = model.query(sql, 10);
		table = new DefaultTableModel(list,Title.patienttitle());
		jtable = new JTable(table);
		// 将表格添加到JScollPane中
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setViewportView(jtable);
		this.setClosable(true);
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}
}