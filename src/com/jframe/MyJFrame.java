package com.jframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.*;

import com.adminframe.AddAdmin;
import com.adminframe.AdminFrame;
import com.adminframe.ManageAdmin;
import com.bed.BedTableFrame;
import com.drugframe.DrugTableFrame;
import com.drugframe.ManageDrug;
import com.dto.Admin;
import com.employer.EmployerTableFrame;
import com.employer.ManageEmployer;
import com.employer.SearchEmployer;
import com.instrumentframe.InstrumentTableFrame;
import com.instrumentframe.ManageInstrument;
import com.patient.AddPatient;
import com.patient.ManagePatient;
import com.patient.PatientTableFrame;
import com.salary.ManageSalary;
import com.salary.SalaryTableFrame;

public class MyJFrame extends JFrame implements ActionListener {
	private JMenuBar menubar;
	private JMenu[] menu;
	private JDesktopPane desktop;
	private Admin admin;

	MyJFrame(Admin admin) {
		super("医院信息管理系统");
		this.setBounds(180, 80, 1000, 650);
		this.admin = admin;
		desktop = new JDesktopPane();
		menubar = new JMenuBar();
		this.getContentPane().add(desktop);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		String[] menustr = { "员工信息管理", "病人信息管理", "药剂资源管理", "仪器资源管理", "病床管理",
				"员工工资管理", "用户权限管理" };
		menu = new JMenu[menustr.length];
		for (int i = 0; i < menustr.length; i++) {
			menu[i] = new JMenu(menustr[i]);
			menubar.add(menu[i]);
		}

		String[] itemstr = { "查看员工信息", "查看病人信息", "查看药剂资源", "查看仪器资源", "查看病床",
				"查看工资", "修改信息", };
		JMenuItem[] menuitems = new JMenuItem[itemstr.length];
		for (int i = 0; i < itemstr.length; i++) {
			menuitems[i] = new JMenuItem(itemstr[i]);
			menuitems[i].addActionListener(this);
			menu[i].add(menuitems[i]);
		}
		String[] itemstr2 = { "管理员工信息", "管理病人信息", "管理药剂资源", "管理仪器资源", null,
				"管理工资信息", "权限管理", };

		JMenuItem menuitemPatient = new JMenuItem("Add Patient");
		menu[1].add(menuitemPatient);
		menuitemPatient.addActionListener(this);
		
		JMenuItem menuitem = new JMenuItem("添加用户");
		menu[6].add(menuitem).setEnabled(false);
		menuitem.addActionListener(this);
		
		JMenuItem menuitem2 = new JMenuItem("查询员工信息");
		menu[0].add(menuitem2);
		menuitem2.addActionListener(this);
		
		JMenuItem[] menuitems2 = new JMenuItem[itemstr2.length];
		for (int i = 0; i < itemstr2.length; i++) {
			menuitems2[i] = new JMenuItem(itemstr2[i]);
			menuitems2[i].addActionListener(this);
			menu[i].add(menuitems2[i]);
			if (!admin.getPower().equals("管理员")) {
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
		if (e.getActionCommand() == "查看员工信息") {
			desktop.removeAll();
			EmployerTableFrame tableframe = new EmployerTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "查看病人信息") {
			desktop.removeAll();
			PatientTableFrame tableframe = new PatientTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "查看药剂资源") {
			desktop.removeAll();
			DrugTableFrame tableframe = new DrugTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "查看仪器资源") {
			desktop.removeAll();
			InstrumentTableFrame tableframe = new InstrumentTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "查看病床") {
			desktop.removeAll();
			BedTableFrame tableframe = new BedTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}
		if (e.getActionCommand() == "查看工资") {
			desktop.removeAll();
			SalaryTableFrame tableframe = new SalaryTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}

		if (e.getActionCommand() == "管理员工信息") {
			ManageEmployer addpatient = new ManageEmployer(desktop);
			desktop.add(addpatient).setVisible(true);
			try {
				addpatient.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "管理病人信息") {
			ManagePatient addpatient = new ManagePatient(desktop);
			desktop.add(addpatient).setVisible(true);
			try {
				addpatient.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "管理药剂资源") {
			ManageDrug manage = new ManageDrug(desktop);
			desktop.add(manage).setVisible(true);
			try {
				manage.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "管理仪器资源") {
			ManageInstrument add = new ManageInstrument(desktop);
			desktop.add(add).setVisible(true);
			try {
				add.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}

		if (e.getActionCommand() == "管理工资信息") {
			ManageSalary msalary = new ManageSalary(desktop);
			desktop.add(msalary).setVisible(true);
			try {
				msalary.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "管理病床") {

		}
		if (e.getActionCommand() == "添加用户") {
			AddAdmin addadmin = new AddAdmin(desktop);
			desktop.add(addadmin).setVisible(true);
			try {
				addadmin.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "修改信息") {
			AdminFrame adminframe = new AdminFrame(admin);
			desktop.add(adminframe).setVisible(true);
			try {
				adminframe.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}
		if (e.getActionCommand() == "权限管理") {
			ManageAdmin manage = new ManageAdmin();
			desktop.add(manage).setVisible(true);
			try {
				manage.setSelected(true);
			} catch (PropertyVetoException pe) {
			}
		}		
		if (e.getActionCommand() == "查询员工信息") {
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
