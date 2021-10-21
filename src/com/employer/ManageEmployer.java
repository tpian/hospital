/*
 * addEmployer.java
 *
 * Created on __DATE__, __TIME__
 */

package com.employer;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import com.dto.Employer;
import com.model.ComboModel;
import com.model.EmployerModel;
import com.util.StringHelp;

/**
 * 
 * @author __USER__
 */
public class ManageEmployer extends javax.swing.JInternalFrame {

	/** Creates new form addEmployer */
	public ManageEmployer(JDesktopPane desktop) {
		this.desktop = desktop;
		initComponents();
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		id = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		dept = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		idcard = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		birthday = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		origo = new javax.swing.JComboBox();
		jLabel8 = new javax.swing.JLabel();
		nationality = new javax.swing.JComboBox();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		nation = new javax.swing.JComboBox();
		address = new javax.swing.JTextField();
		tel = new javax.swing.JTextField();
		marriage = new javax.swing.JComboBox();
		health = new javax.swing.JComboBox();
		jLabel11 = new javax.swing.JLabel();
		worktime = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		addbutton = new javax.swing.JButton();
		cancelbutton = new javax.swing.JButton();
		uptbutton = new javax.swing.JButton();
		deletebutton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		searchbutton = new javax.swing.JButton();
		sex = new javax.swing.JComboBox();
		jLabel16 = new javax.swing.JLabel();
		search = new javax.swing.JComboBox();

		jLabel1.setText("\u5458\u5de5\u53f7");

		jLabel2.setText("\u5458\u5de5\u59d3\u540d");

		jLabel5.setText("\u6240\u5728\u90e8\u95e8");

		ComboModel cm = new ComboModel();
		String[] str = cm.combo("select name from dept");

		dept.setModel(new javax.swing.DefaultComboBoxModel(str));

		jLabel4.setText("\u8eab\u4efd\u8bc1\u53f7\u7801");

		jLabel6.setText("\u751f\u65e5");

		jLabel7.setText("\u7c4d\u8d2f");

		origo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"江苏", "上海", "浙江" }));

		jLabel8.setText("\u56fd\u7c4d");

		nationality.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "中国" }));

		jLabel9.setText("\u6c11\u65cf");

		jLabel10.setText("\u5a5a\u59fb\u72b6\u51b5");

		jLabel12.setText("\u5065\u5eb7\u72b6\u51b5");

		jLabel13.setText("\u8054\u7cfb\u7535\u8bdd");

		jLabel14.setText("\u5bb6\u5ead\u4f4f\u5740");

		nation.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"汉族", "苗族", "满族" }));

		marriage.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"已婚", "未婚" }));

		health.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"很好", "一般", "较差" }));

		jLabel11.setText("\u53c2\u52a0\u5de5\u4f5c\u65f6\u95f4");

		jLabel15.setText("\u6027\u522b");

		addbutton.setText("\u6dfb\u52a0");
		addbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addbuttonActionPerformed(evt);
			}
		});

		cancelbutton.setText("\u53d6\u6d88");
		cancelbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelbuttonActionPerformed(evt);
			}
		});

		uptbutton.setText("\u4fee\u6539");
		uptbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				uptbuttonActionPerformed(evt);
			}
		});

		deletebutton.setText("\u5220\u9664");
		deletebutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deletebuttonActionPerformed(evt);
			}
		});

		jLabel3.setText("\u6839\u636e\u5458\u5de5\u53f7\u67e5\u8be2");

		searchbutton.setText("\u641c\u7d22");
		searchbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchbuttonActionPerformed(evt);
			}
		});

		sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "男",
				"女" }));
		sex.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sexActionPerformed(evt);
			}
		});

		jLabel16.setFont(new java.awt.Font("幼圆", 0, 18));
		jLabel16.setText("\u5458\u5de5\u4fe1\u606f\u7ba1\u7406\u754c\u9762");
		search.setEditable(true);
		// 设置员工工号
		String[] str2 = cm.combo("select id from employer");
		search.setModel(new javax.swing.DefaultComboBoxModel(str2));
		search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addComponent(
																jLabel11,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addComponent(
																jLabel14,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE)
														.addComponent(
																jLabel13,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																92,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																tel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(
																idcard,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(
																birthday,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(
																worktime,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(
																address,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(addbutton)
														.addComponent(uptbutton)
														.addComponent(
																id,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE)
														.addComponent(
																name,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																142,
																Short.MAX_VALUE))
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jLabel12))
																		.addGap(
																				15,
																				15,
																				15)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								sex,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								origo,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								dept,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								health,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								marriage,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								nation,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								113,
																								Short.MAX_VALUE)
																						.addComponent(
																								nationality,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								0,
																								113,
																								Short.MAX_VALUE))
																		.addContainerGap())
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				14,
																				14,
																				14)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								cancelbutton)
																						.addComponent(
																								deletebutton))
																		.addGap(
																				103,
																				103,
																				103))))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(50, 50, 50)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(search, 0, 113,
												Short.MAX_VALUE).addGap(10, 10,
												10).addComponent(searchbutton)
										.addContainerGap(120, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(127, 127,
										127).addComponent(jLabel16)
										.addContainerGap(167, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel16)
										.addGap(3, 3, 3)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																searchbutton)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																15,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																search,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				2,
																				2,
																				2)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								sex,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								15,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								dept,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								name,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								idcard,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								15,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								origo,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				15,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				id,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																birthday,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																15,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8)
														.addComponent(
																nationality,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																worktime,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel11)
														.addComponent(
																nation,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(6, 6, 6)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jLabel10,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				14,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				marriage,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				address,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel14,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				15,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																health,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				tel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel13,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				15,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel12)))
										.addGap(41, 41, 41)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(addbutton)
														.addComponent(
																deletebutton))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(uptbutton)
														.addComponent(
																cancelbutton))
										.addGap(19, 19, 19)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void searchActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void sexActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	// 搜索员工信息
	private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		String eid = search.getSelectedItem().toString();
		EmployerModel emodel = new EmployerModel();
		Employer emp = emodel.queryOne(eid);
		if(emp.getName()==null){
			JOptionPane.showMessageDialog(this, "查无此员工信息");
			return;
		}
		id.setText(emp.getId());
		name.setText(emp.getName());
		idcard.setText(emp.getIdcard());
		worktime.setText(emp.getWorktime().toString());
		birthday.setText(emp.getBirthday().toString());
		tel.setText(emp.getTel());
		address.setText(emp.getAddress());
		sex.setSelectedItem(emp.getSex());
		dept.setSelectedItem(emp.getDept());
		origo.setSelectedItem(emp.getOrigo());
		nation.setSelectedItem(emp.getNation());
		nationality.setSelectedItem(emp.getNationality());
		marriage.setSelectedItem(emp.getMarriage());
		health.setSelectedItem(emp.getHealth());
	}

	// 删除员工信息
	private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {
		String r = search.getSelectedItem().toString();
		int yes = JOptionPane.showConfirmDialog(null, "确定删除'" + r + "'号员工？");
		if (yes == 0) {
			EmployerModel em = new EmployerModel();
			boolean flag = em.DelEmployer(r);
			if (flag) {
				JOptionPane.showMessageDialog(this, "删除成功");
				desktop.removeAll();
				EmployerTableFrame tableframe = new EmployerTableFrame();
				desktop.add(tableframe);
				tableframe.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "删除失败");
			}
		}
	}

	// 修改员工信息
	private void uptbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		if (id.getText().equals("") || name.getText().equals("")
				|| idcard.getText().equals("") || birthday.getText().equals("")
				|| worktime.getText().equals("")
				|| address.getText().equals("") || tel.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "请将信息填写完整");
			return;
		}
		EmployerModel em = new EmployerModel();
		if (em.queryOne(id.getText()).getAddress() == null
				|| search.getSelectedItem().toString().equals(id.getText())) {
			Employer e = new Employer();
			e.setId(id.getText());
			e.setName(name.getText());
			e.setBirthday(StringHelp.convertFormStr(birthday.getText()));
			e.setWorktime(StringHelp.convertFormStr(worktime.getText()));
			e.setAddress(address.getText());
			e.setIdcard(idcard.getText());
			e.setTel(tel.getText());
			e.setSex(sex.getSelectedItem().toString());
			e.setDept(dept.getSelectedItem().toString());
			e.setOrigo(origo.getSelectedItem().toString());
			e.setNation(nation.getSelectedItem().toString());
			e.setNationality(nationality.getSelectedItem().toString());
			e.setMarriage(marriage.getSelectedItem().toString());
			e.setHealth(health.getSelectedItem().toString());
			boolean flag = em.uptemployer(e, id.getText());
			if (flag) {
				this.dispose();
				JOptionPane.showMessageDialog(this, "修改成功");
				desktop.removeAll();
				EmployerTableFrame tableframe = new EmployerTableFrame();
				desktop.add(tableframe);
				tableframe.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "修改失败");
			}
		} else {
			JOptionPane.showMessageDialog(this, "该员工已存在");
			return;
		}
	}

	// 添加员工信息
	private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		if (id.getText().equals("") || name.getText().equals("")
				|| idcard.getText().equals("") || birthday.getText().equals("")
				|| worktime.getText().equals("")
				|| address.getText().equals("") || tel.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "请将信息填写完整");
			return;
		}
		EmployerModel em = new EmployerModel();
		if (em.queryOne(id.getText()).getAddress() != null) {
			JOptionPane.showMessageDialog(this, "该员工已存在");
			return;
		}
		Employer e = new Employer();
		e.setId(id.getText());
		e.setName(name.getText());
		e.setBirthday(StringHelp.convertFormStr(birthday.getText()));
		e.setWorktime(StringHelp.convertFormStr(worktime.getText()));
		e.setAddress(address.getText());
		e.setIdcard(idcard.getText());
		e.setTel(tel.getText());
		e.setSex(sex.getSelectedItem().toString());
		e.setDept(dept.getSelectedItem().toString());
		e.setOrigo(origo.getSelectedItem().toString());
		e.setNation(nation.getSelectedItem().toString());
		e.setNationality(nationality.getSelectedItem().toString());
		e.setMarriage(marriage.getSelectedItem().toString());
		e.setHealth(health.getSelectedItem().toString());
		boolean flag = em.addEmployer(e);
		if (flag) {
			this.dispose();
			desktop.removeAll();
			EmployerTableFrame tableframe = new EmployerTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
			JOptionPane.showMessageDialog(this, "添加成功");
		} else {
			JOptionPane.showMessageDialog(this, "添加失败");
		}
	}

	private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton addbutton;
	private javax.swing.JTextField address;
	private javax.swing.JTextField birthday;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton cancelbutton;
	private javax.swing.JButton deletebutton;
	private javax.swing.JComboBox dept;
	private javax.swing.JComboBox health;
	private javax.swing.JTextField id;
	private javax.swing.JTextField idcard;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JComboBox marriage;
	private javax.swing.JTextField name;
	private javax.swing.JComboBox nation;
	private javax.swing.JComboBox nationality;
	private javax.swing.JComboBox origo;
	private javax.swing.JComboBox search;
	private javax.swing.JButton searchbutton;
	private javax.swing.JComboBox sex;
	private javax.swing.JTextField tel;
	private javax.swing.JButton uptbutton;
	private javax.swing.JTextField worktime;
	private JDesktopPane desktop;
	// End of variables declaration//GEN-END:variables

}