/*
 * AddAdmin.java
 *
 * Created on __DATE__, __TIME__
 */

package com.adminframe;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import com.dto.Admin;
import com.model.AdminModel;

/**
 * 
 * @author __USER__
 */
public class AddAdmin extends javax.swing.JInternalFrame {

	/** Creates new form AddAdmin */
	public AddAdmin(JDesktopPane desktop) {
		this.desktop = desktop;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		password1 = new javax.swing.JPasswordField();
		password2 = new javax.swing.JPasswordField();
		jLabel5 = new javax.swing.JLabel();
		power = new javax.swing.JComboBox();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		jLabel1.setText("\u589e\u52a0\u7528\u6237");

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6\u7801");

		jLabel4.setText("\u786e\u8ba4\u5bc6\u7801");

		jLabel5.setText("\u7528\u6237\u6743\u9650");

		power.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"管理员", "普通用户" }));

		jButton1.setText("\u6dfb\u52a0");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
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
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				56,
																				56,
																				56)
																		.addComponent(
																				jButton1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				73,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton2))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				45,
																				45,
																				45)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel2,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.Alignment.TRAILING))
																		.addGap(
																				4,
																				4,
																				4)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								power,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								name,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								114,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								password1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								146,
																								Short.MAX_VALUE)
																						.addComponent(
																								password2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								146,
																								Short.MAX_VALUE))))
										.addContainerGap(60, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup().addGap(127, 127,
										127).addComponent(jLabel1)
										.addContainerGap(128, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addComponent(jLabel1)
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
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3)
														.addComponent(
																password1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																password2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel5)
														.addComponent(
																power,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(38, 38, 38)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2))
										.addContainerGap(46, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	// 取消操作
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	// 增加用户
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (name.getText().equals("") || password1.getText().equals("")
				|| password2.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "请将信息填写完整");
			return;
		}
		if (!password1.getText().equals(password2.getText())) {
			JOptionPane.showMessageDialog(this, "密码不一致");
			return;
		}
		AdminModel am = new AdminModel();
		Admin admin = new Admin();
		admin.setName(name.getText());
		admin.setPassword(password1.getText());
		admin.setPower(power.getSelectedItem().toString());
		if (am.addAdmin(admin)) {
			JOptionPane.showMessageDialog(this, "添加用户成功");
			this.dispose();
			desktop.removeAll();
			ManageAdmin manageadmin = new ManageAdmin();
			desktop.add(manageadmin);
			manageadmin.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "添加用户失败");
		}
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField name;
	private javax.swing.JPasswordField password1;
	private javax.swing.JPasswordField password2;
	private javax.swing.JComboBox power;
	private JDesktopPane desktop;
	// End of variables declaration//GEN-END:variables

}