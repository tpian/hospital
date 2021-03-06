/*
 * ManagePatient.java
 *
 * Created on __DATE__, __TIME__
 */

package com.patient;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.dto.Bed;
import com.dto.Patient;
import com.employer.EmployerTableFrame;
import com.model.BedModel;
import com.model.ComboModel;
import com.model.EmployerModel;
import com.model.PatientModel;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *
 * @author  __USER__
 */
public class ManagePatient extends javax.swing.JInternalFrame {

	/** Creates new form ManagePatient */
	public ManagePatient(JDesktopPane desktop) {
		super("Manage Patient",true,true,true,true);
		this.desktop = desktop;
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
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		sex = new javax.swing.JComboBox();
		doctor = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		cation = new javax.swing.JTextArea();
		entertime = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		searchbutton = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		urgencyLabel = new JLabel("Urgency Rate");
		urgency = new JComboBox();
		room = new javax.swing.JComboBox();
		bed = new javax.swing.JComboBox();
		cancelbutton = new javax.swing.JButton();
		uptbutton = new javax.swing.JButton();
		deletebutton = new javax.swing.JButton();
//		addbutton = new javax.swing.JButton();
		search = new javax.swing.JComboBox();
		section = new javax.swing.JComboBox();

		jLabel1.setText("Patient Infomation Manage");//????
		jLabel1.setFont(new Font( "Myriad", 0, 18));

		jLabel2.setText("Name");

		jLabel3.setText("Doctor");

		jLabel4.setText("Sex");

		jLabel6.setText("Situation");

		jLabel7.setText("Department");

		jLabel8.setText("Admission time");
		
		//????????????????
		ComboModel com = new ComboModel();
		
		String[] str1 = com.combo("select id from patient");
		search.setModel(new javax.swing.DefaultComboBoxModel(str1));
		search.setEditable(true);
		//????
		String[] str2 = com.combo("select name from dept where kind='????'");
	
		section.setModel(new javax.swing.DefaultComboBoxModel(str2));
		section.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sectionActionPerformed(evt);
			}
		});
		
		urgency.setModel(new DefaultComboBoxModel<String>(new String[] {"1","2","3","4"}));
		
		sex.setEditable(true);
		sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "??",
				"??" }));
		//????
		String sdept = section.getSelectedItem().toString();
		String[] str3 =com.combo("select name from employer where dept='"+sdept+"'");
		doctor = new JComboBox(str3);
		
		
		doctor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doctorActionPerformed(evt);
			}
		});
		
		cation.setColumns(20);
		cation.setRows(5);
		jScrollPane1.setViewportView(cation);

		entertime.setEditable(false);

		jLabel5.setText("Search by patient case number");

		searchbutton.setText("Search");
		searchbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchbuttonActionPerformed(evt);
			}
		});

		jLabel9.setText("Room");

		jLabel10.setText("Bed");
		//????
		String[] str4 = com.combo("select distinct room from bed where patientid is null ");
		room.setModel(new javax.swing.DefaultComboBoxModel(str4));
		room.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				roomActionPerformed(evt);
			}
		});
		//????
		String rstr = room.getSelectedItem().toString();
		String[] str5 = com.combo("select bed from bed where room = '"+rstr+"'");
		bed = new JComboBox(str5);

		cancelbutton.setText("Cancel");
		cancelbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelbuttonActionPerformed(evt);
			}
		});

		uptbutton.setText("Update Infomation");
		uptbutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				uptbuttonActionPerformed(evt);
			}
		});

		deletebutton.setText("Check out");
		deletebutton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deletebuttonActionPerformed(evt);
			}
		});
		
//		??????????????????????????????
		getInitPatient();

//		addbutton.setText("Check in");
//		addbutton.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				addbuttonActionPerformed(evt);
//			}
//		});


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap(13, Short.MAX_VALUE)
										.addComponent(jLabel5)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												search,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												145,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(searchbutton).addGap(29,
												29, 29))
						.addGroup(
								layout.createSequentialGroup().addGap(124, 124,
										124).addComponent(jLabel1)
										.addContainerGap(152, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(75, 75, 75)
//										.addComponent(addbutton)
//										.addPreferredGap(
//												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(deletebutton)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(uptbutton)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(cancelbutton).addGap(51,
												51, 51))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								74,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								74,
																								Short.MAX_VALUE)
																						.addComponent(
																								urgencyLabel,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								74,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel6))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addComponent(jLabel7)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				74,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																room,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																86,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bed,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																86,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																sex,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																61,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																urgency,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																61,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																233,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																entertime,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																133,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																		.addComponent(
																				section,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				0,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				name,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				129,
																				Short.MAX_VALUE)
																		.addComponent(
																				doctor,
																				javax.swing.GroupLayout.Alignment.LEADING,
																				0,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap(51, Short.MAX_VALUE)));
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
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																searchbutton)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				search,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jLabel5)))
										.addGap(19, 19, 19)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						name,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																				
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								sex,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								urgencyLabel)
																						.addComponent(
																								urgency,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
//														
//														.addGroup(
//																layout
//																		.createSequentialGroup()
//																		.addComponent(
//																				jLabel2)
//																		.addGap(
//																				33,
//																				33,
//																				33))
														)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel7))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				6,
																				6,
																				6)
																		.addComponent(
																				section,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																doctor,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(10, 10, 10)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																11,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																entertime,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																11,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																room,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel10,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																11,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bed,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				78,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				26,
																				26,
																				26)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
//																						.addComponent(
//																								addbutton)
																						.addComponent(
																								deletebutton)
																						.addComponent(
																								uptbutton)
																						.addComponent(
																								cancelbutton)))
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																11,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(14, 14, 14)));

		pack();
	}// </editor-fold>

	//GEN-END:initComponents

	private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}
	//????????????????
	private void uptbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		if(name.getText().equals("")||cation.getText().equals("")){
			JOptionPane.showMessageDialog(this, "????????????????");
			return;
		}
		int r = Integer.parseInt(search.getSelectedItem().toString());
		PatientModel em = new PatientModel();
		if(em.queryOne(r).getName()==null){
			JOptionPane.showMessageDialog(this, "??????????????????");
			return;
		}
		Patient p = new Patient();
		p.setName(name.getText());
		p.setBed(Integer.parseInt(bed.getSelectedItem().toString()));
		p.setRoom(room.getSelectedItem().toString());
		p.setCation(cation.getText());
		p.setDoctor(doctor.getSelectedItem().toString());
		p.setSection(section.getSelectedItem().toString());
		p.setSex(sex.getSelectedItem().toString());
		p.setUrgency(Integer.parseInt(urgency.getSelectedItem().toString()));
		//????????????????????????
		BedModel bmodel = new BedModel();
		Bed b = new Bed();
		b.setId(em.queryOne(r).getBed());
		b.setRoom(em.queryOne(r).getRoom());
		bmodel.uptBed(b);
		//????????????
		b.setPatientid(p.getId());
		bmodel.uptBed(b);
		
		boolean flag = em.uptPatient(p, r);
		if(flag){
			JOptionPane.showMessageDialog(this, "????????????????????");
			this.dispose();
			desktop.removeAll();
			PatientTableFrame tableframe = new PatientTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "????????????????????");
		}
	}
	
//????????????????
	private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {
		int r = Integer.parseInt(search.getSelectedItem().toString());
		PatientModel em = new PatientModel();
		if(em.queryOne(r).getName()==null){
			JOptionPane.showMessageDialog(this, "??????????????????");
			return;
		}
		int yes = JOptionPane.showConfirmDialog(null,  r + "'????????????????");
		if (yes == 0) {
			//??????????????????
			BedModel bmodel = new BedModel();
			Bed b = new Bed();
			b.setId(em.queryOne(r).getBed());
			b.setRoom(em.queryOne(r).getRoom());
			bmodel.uptBed(b);
	
			boolean flag = em.DelPatient(r);
			if (flag) {
				JOptionPane.showMessageDialog(this, "??????????????????");
				this.getInitPatient();
//				desktop.removeAll();
//				PatientTableFrame tableframe = new PatientTableFrame();
//				desktop.add(tableframe);
//				tableframe.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "????????????");
			}
		}
	}
//??????????
	private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {
		int id = Integer.parseInt(search.getSelectedItem().toString());
		getPatientById(id);
	}
	
	private void getPatientById(int id) {
		PatientModel pmodel = new PatientModel();
		Patient p = pmodel.queryOne(id);
		if(p.getName()==null){
			JOptionPane.showMessageDialog(this, "??????????????");
			return;
		}
		search.setSelectedItem(new String(""+p.getId()));
		name.setText(p.getName());
		sex.setSelectedItem(p.getSex());
		section.setSelectedItem(p.getSection());
		doctor.setSelectedItem(p.getDoctor());
		entertime.setText(p.getEnetertime().toString());
		room.setSelectedItem(p.getRoom());
		bed.setSelectedItem(p.getBed());
		cation.setText(p.getCation());
		urgency.setSelectedIndex(p.getUrgency()-1);
	}
	
//	??????????????????????????
	private void getInitPatient() {
		PatientModel pmodel = new PatientModel();
		int id = pmodel.queryMostUrgentPatientId();
		if (id == 0) {
			return;
		}else {
			getPatientById(id);
		}
	}

	//??????????????????????????
	private void roomActionPerformed(java.awt.event.ActionEvent evt) {
		String rstr = room.getSelectedItem().toString();
		ComboModel com = new ComboModel();
		String[] s = com.combo("select bed from bed where room = '"
				+rstr+"' and patientid is null or patientid="
				+search.getSelectedItem().toString());
		bed.removeAllItems();
		for(int i = 0;i<s.length;i++){
			bed.addItem(s[i]);
		}
	}

	//??????????????????????????????
	private void sectionActionPerformed(java.awt.event.ActionEvent evt) {
		String deptname = section.getSelectedItem().toString();
		ComboModel com = new ComboModel();
		String[] s = com.combo("select name from employer where dept='"+deptname+"'");
		doctor.removeAllItems();
		for(int i = 0;i<s.length;i++){
			doctor.addItem(s[i]);
		}
	}

	private void doctorActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

//	private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {
//		//????????????
//		if(name.getText().equals("")||cation.getText().equals("")){
//			JOptionPane.showMessageDialog(this, "????????????????");
//			return;
//		}
//		Patient p = new Patient();
//		p.setName(name.getText());
//		p.setBed(Integer.parseInt(bed.getSelectedItem().toString()));
//		p.setRoom(room.getSelectedItem().toString());
//		p.setCation(cation.getText());
//		p.setDoctor(doctor.getSelectedItem().toString());
//		p.setSection(section.getSelectedItem().toString());
//		p.setSex(sex.getSelectedItem().toString());
//		PatientModel patientmodel = new PatientModel();
//		boolean flag = patientmodel.addPatient(p);
//		if(flag){
//			//????????
//			BedModel bmodel = new BedModel();
//			Bed b = new Bed();
//			b.setId(p.getBed());
//			b.setPatientid(patientmodel.queryId());
//			b.setRoom(p.getRoom());
//			bmodel.uptBed(b);
//			
//			JOptionPane.showMessageDialog(this, "????????????????????");
//			this.dispose();
//			desktop.removeAll();
//			PatientTableFrame tableframe = new PatientTableFrame();
//			desktop.add(tableframe);
//			tableframe.setVisible(true);
//		}else{
//			JOptionPane.showMessageDialog(this, "????????????????????");
//		}
//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
//	private javax.swing.JButton addbutton;
	private javax.swing.JComboBox bed;
	private javax.swing.JButton cancelbutton;
	private javax.swing.JTextArea cation;
	private javax.swing.JButton deletebutton;
	private javax.swing.JComboBox doctor;
	private javax.swing.JTextField entertime;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField name;
	private javax.swing.JComboBox room;
	private javax.swing.JComboBox search;
	private javax.swing.JButton searchbutton;
	private javax.swing.JComboBox section;
	private javax.swing.JComboBox sex;
	private JLabel urgencyLabel;
	private JComboBox urgency;
	private javax.swing.JButton uptbutton;
	private JDesktopPane desktop;
	// End of variables declaration//GEN-END:variables

}