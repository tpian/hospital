/*
 * AdminFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.adminframe;

import java.awt.Font;

import javax.swing.JOptionPane;

import com.dto.Admin;
import com.model.AdminModel;

/**
 *
 * @author  __USER__
 */
public class AdminFrame extends javax.swing.JInternalFrame {

	/** Creates new form AdminFrame */
	public AdminFrame(Admin admin) {
		this.admin = admin;
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		name = new javax.swing.JTextField(admin.getName());
		password1 = new javax.swing.JPasswordField();
		password2 = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		password = new javax.swing.JPasswordField();

		jLabel1.setFont(new Font( "Myriad", 0, 18));
		jLabel1.setText("Please update your information below");

		jLabel2.setText("Username");

		jLabel3.setText("New Password");

		jLabel4.setText("Confirm Password");

		jButton1.setText("Update");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancel");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel5.setText("Original Password");

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
										.addGap(103, 103, 103)
										.addComponent(jButton1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(38, 38, 38)
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
										.addGap(30, 30, 30)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																name,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																89,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(password,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																password1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																171,
																Short.MAX_VALUE)
														.addComponent(
																password2, 0,
																0,
																Short.MAX_VALUE))
										.addGap(40, 40, 40)).addGroup(
								layout.createSequentialGroup().addGap(93, 93,
										93).addComponent(jLabel1)
										.addContainerGap(102, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(31, 31, 31)
										.addComponent(jLabel1)
										.addGap(31, 31, 31)
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
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel5)
														.addComponent(
																password,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
										.addGap(43, 43, 43)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2))
										.addGap(39, 39, 39)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents��
	
//�޸�����
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if(password1.getText().equals("")||password.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Password cannot be blank!");
			return;
		}
		Admin a = new Admin();
		AdminModel adminmodel = new AdminModel();
		a.setName(admin.getName());
		a.setPassword(password.getText());
		a.setPower(admin.getPower());
		a= adminmodel.validate(a);
		
		if(a !=null){
			if(password1.getText().equals(password2.getText())){
				a.setPassword(password2.getText());
				boolean f = adminmodel.uptAdmin(a, a.getId());
				if(f){
					JOptionPane.showMessageDialog(this, "Password Update Succeed!");
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "Password Update Failed!");
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "Please check whether your password is the same!");
			}
		}else{
			JOptionPane.showMessageDialog(this, "Your password is not correct!");
			return;
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField name;
	private javax.swing.JPasswordField password;
	private javax.swing.JPasswordField password1;
	private javax.swing.JPasswordField password2;
	private Admin admin;
	// End of variables declaration//GEN-END:variables

}