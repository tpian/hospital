package com.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.*;

import com.adminframe.AddAdmin;
import com.adminframe.AdminFrame;
import com.adminframe.ManageAdmin;
import com.bed.AddBed;
import com.bed.BedTableFrame;
import com.bed.ManageBed;
import com.dto.Admin;
import com.employer.EmployerTableFrame;
import com.employer.ManageEmployer;
import com.employer.SearchEmployer;
import com.patient.AddPatient;
import com.patient.ManagePatient;
import com.patient.PatientTableFrame;

public class MyJFrame extends JFrame implements ActionListener {
	private JMenuBar menubar;
	private JMenu[] menu;
	private JDesktopPane desktop;
	private Admin admin;

	MyJFrame(Admin admin) {
		super("Hospital Manage System");
		this.setBounds(180, 80, 1000, 650);
		this.admin = admin;
		desktop = new JDesktopPane();
		menubar = new JMenuBar();
		this.getContentPane().add(desktop);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		String[] menustr = { "Employer Manage ", "Patient Manage ",  "Bed Manage ", "User Permission Manage" };
		menu = new JMenu[menustr.length];
		for (int i = 0; i < menustr.length; i++) {
			menu[i] = new JMenu(menustr[i]);
			menubar.add(menu[i]);
		}

		String[] itemstr = { "All Employers", "All Patients", "All Beds", "Update User" };
		JMenuItem[] menuitems = new JMenuItem[itemstr.length];
		for (int i = 0; i < itemstr.length; i++) {
			menuitems[i] = new JMenuItem(itemstr[i]);
			menuitems[i].addActionListener(this);
			menu[i].add(menuitems[i]);
		}

		JMenuItem menuitemPatient = new JMenuItem("Add Patient");
		menu[1].add(menuitemPatient);
		menuitemPatient.addActionListener(this);
		
		JMenuItem menuitem = new JMenuItem("Add User");
		menu[3].add(menuitem).setEnabled(false);
		menuitem.addActionListener(this);
		
		JMenuItem menuitemBed = new JMenuItem("Add Bed");
		menu[2].add(menuitemBed);
		menuitemBed.addActionListener(this);
		
		JMenuItem menuitem2 = new JMenuItem("Query Employer");
		menu[0].add(menuitem2);
		menuitem2.addActionListener(this);
		
		String[] itemstr2 = { "Manage Employer", "Manage Patient","Manage Bed", "Manage Permission" };
		JMenuItem[] menuitems2 = new JMenuItem[itemstr2.length];
		for (int i = 0; i < itemstr2.length; i++) {
			menuitems2[i] = new JMenuItem(itemstr2[i]);
			menuitems2[i].addActionListener(this);
			menu[i].add(menuitems2[i]);
			if (!admin.getPower().equals("¹ÜÀíÔ±")) {
				menuitems2[i].setEnabled(false);
			} else {
				menuitems2[i].setEnabled(true);
				menuitem.setEnabled(true);
			}

		}

		this.setJMenuBar(menubar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		// this.pack();
	}

	// public static void main(String[] args) {
	// new MyJFrame(null);
	// }

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "All Employers") {
			desktop.removeAll();
			EmployerTableFrame tableframe = new EmployerTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "All Patients") {
			desktop.removeAll();
			PatientTableFrame tableframe = new PatientTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "All Beds") {
			desktop.removeAll();
			BedTableFrame tableframe = new BedTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "Manage Employer") {
			ManageEmployer addpatient = new ManageEmployer(desktop);
			desktop.add(addpatient).setVisible(true);
			try {
				addpatient.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Manage Patient") {
			ManagePatient addpatient = new ManagePatient(desktop);
			desktop.add(addpatient).setVisible(true);
			try {
				addpatient.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Manage Bed") {
			ManageBed manageBed = new ManageBed(desktop);
			desktop.add(manageBed).setVisible(true);
			try {
				manageBed.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Add Bed") {
			AddBed addBed = new AddBed(desktop);
			desktop.add(addBed).setVisible(true);
			try {
				addBed.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Add User") {
			AddAdmin addadmin = new AddAdmin(desktop);
			desktop.add(addadmin).setVisible(true);
			try {
				addadmin.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Update User") {
			AdminFrame adminframe = new AdminFrame(admin);
			desktop.add(adminframe).setVisible(true);
			try {
				adminframe.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Manage Permission") {
			ManageAdmin manage = new ManageAdmin();
			desktop.add(manage).setVisible(true);
			try {
				manage.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}		
		if (e.getActionCommand() == "Query Employer") {
			SearchEmployer search = new SearchEmployer();
			desktop.add(search).setVisible(true);
			try {
				search.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "Add Patient") {
			AddPatient addpatient = new AddPatient(desktop);
			desktop.add(addpatient).setVisible(true);
		}
	}
}
