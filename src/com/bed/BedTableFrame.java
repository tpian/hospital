
package com.bed;

import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dto.Title;
import com.model.DrugModel;
import com.model.TableModel;



public class BedTableFrame extends JInternalFrame {
	private DefaultTableModel table;
	private JTable jtable;
	public BedTableFrame(){
		this.setSize(880,550);
		String sql="select bed.room,bed.bed,patientid,name," +
				"section,doctor,cation,entertime from bed left" +
				" join patient on id = patientid order by patientid desc";
		TableModel model = new TableModel();
		
		Vector list = model.query(sql, 8);
		table = new DefaultTableModel(list,Title.bedtitle());
		jtable = new JTable(table);
		
		// 将表格添加到JScollPane中
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setViewportView(jtable);
		this.setClosable(true);
		this.getContentPane().add(scrollPane);
		this.setVisible(true);
	}
}