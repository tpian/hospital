/*
 * SearchEmployer.java
 *
 * Created on __DATE__, __TIME__
 */

package com.employer;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.dto.Title;
import com.model.TableModel;

/**
 *
 * @author  __USER__
 */
public class SearchEmployer extends javax.swing.JInternalFrame {

	/** Creates new form SearchEmployer */
	public SearchEmployer() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		searchbutton1 = new javax.swing.JButton();
		searchbutton3 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtable = new javax.swing.JTable();
		name = new javax.swing.JTextField();
		section = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		searchbutton4 = new javax.swing.JButton();
		section2 = new javax.swing.JTextField();
		origo = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();

		jLabel1.setFont(new Font( "Myriad", 0, 18));
		jLabel1.setText("Query Employer");

		searchbutton1.setText("Query Department");
		searchbutton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchbutton1ActionPerformed(evt);
			}
		});

		searchbutton3.setText("Query Name");
		searchbutton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchbutton3ActionPerformed(evt);
			}
		});
		
		jLabel2.setText("Name");

		String sql = "select * from employer";
		Vector vec= tm.query(sql, 14);
		table = new DefaultTableModel(vec,Title.employertitle());
		jtable.setModel(table);
		jScrollPane1.setViewportView(jtable);
		jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		jLabel3.setText("Department");

		searchbutton4.setText("Multiple Query");
		searchbutton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchbutton4ActionPerformed(evt);
			}
		});

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"OR", "AND" }));

		jLabel4.setText("Department");

		jLabel5.setText("Hometown");

		jButton1.setText("Refresh");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		this.setClosable(true);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 934,
								Short.MAX_VALUE)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(112, 112, 112)
										.addComponent(jButton1)
										.addGap(35, 35, 35)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				jLabel4)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				section2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jComboBox1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel5)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				origo,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				searchbutton4))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				section,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				searchbutton1)
																		.addGap(
																				36,
																				36,
																				36)
																		.addComponent(
																				jLabel2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				name,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				91,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				searchbutton3)))
										.addContainerGap(234, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.CENTER,
								layout.createSequentialGroup().addContainerGap(
										417, Short.MAX_VALUE).addComponent(
										jLabel1).addGap(409, 409, 409)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												342, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(
																name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchbutton3)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel3)
																		.addComponent(
																				jButton1))
														.addComponent(
																section,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchbutton1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				section2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jComboBox1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel5)
														.addComponent(
																origo,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchbutton4))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
	//????
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String sql = "select * from employer";
		table.setDataVector(tm.query(sql, 14), Title.employertitle());
	}

	//????????????
	private void searchbutton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String s1 = section2.getText()==null?null:section2.getText();
		String s2 = origo.getText()==null?null:origo.getText();
		String s3 = jComboBox1.getSelectedItem().toString();
		String sql= "select * from employer where dept='"+s1+"'"+s3+" origo = '"+s2+"'";
		table.setDataVector(tm.query(sql, 14), Title.employertitle());
	}

	//????????????????

	private void searchbutton3ActionPerformed(java.awt.event.ActionEvent evt) {
		String sql = "select * from employer where name like '%"+name.getText()+"%'";
		table.setDataVector(tm.query(sql, 14), Title.employertitle());
	}

	//????????????
	private void searchbutton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (section.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please input the name of the department!");
			return;
		}
		String sql = "select * from employer where dept = '"
				+ section.getText() + "'";
		table.setDataVector(tm.query(sql, 14), Title.employertitle());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jtable;
	private javax.swing.JTextField name;
	private javax.swing.JTextField origo;
	private javax.swing.JButton searchbutton1;
	private javax.swing.JButton searchbutton3;
	private javax.swing.JButton searchbutton4;
	private javax.swing.JTextField section;
	private javax.swing.JTextField section2;
	private DefaultTableModel table;
	private TableModel tm = new TableModel();
	// End of variables declaration//GEN-END:variables

}