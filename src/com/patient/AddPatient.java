package com.patient;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dto.Bed;
import com.dto.Patient;
import com.model.BedModel;
import com.model.ComboModel;
import com.model.PatientModel;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

public class AddPatient extends JInternalFrame {

	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JLabel sexLabel;
	private javax.swing.JLabel uegencyLabel;
	private javax.swing.JLabel dapartLabel;
	private javax.swing.JLabel docLabel;
	private javax.swing.JLabel enterTimeLabel;
	private javax.swing.JLabel roomLabel;
	private javax.swing.JLabel bedLabel;
	private javax.swing.JLabel situationLabel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField name;
	private javax.swing.JComboBox section;
	private javax.swing.JComboBox sex;
	private javax.swing.JComboBox uegency;
	private javax.swing.JComboBox doctor;
	private javax.swing.JComboBox room;
	private javax.swing.JComboBox bed;
	private javax.swing.JTextArea cation;
	private javax.swing.JTextField entertime;
	private javax.swing.JButton addbutton;
	private javax.swing.JButton cancelbutton;
	private JDesktopPane desktop;
	private JPanel infoBox;
	private ComboModel com;


	public AddPatient(JDesktopPane desktop) {
		super("Add Patient",true,true,true,true);
		this.desktop = desktop;
		initComponents();
	}

	private void initComponents() {
		com = new ComboModel();
		
		titleLabel = new javax.swing.JLabel("Patient Infomation Add");
		nameLabel = new javax.swing.JLabel("Name");
		sexLabel = new javax.swing.JLabel("Sex");
		uegencyLabel = new JLabel("Urgency Rate");
		dapartLabel = new javax.swing.JLabel("Department");
		docLabel = new javax.swing.JLabel("Doctor");
		enterTimeLabel = new javax.swing.JLabel("Admission time");
		roomLabel = new javax.swing.JLabel("Room");
		bedLabel = new javax.swing.JLabel("Bed");
		situationLabel = new javax.swing.JLabel("Situation");
		name = new javax.swing.JTextField();
		sex = new javax.swing.JComboBox();
		uegency = new JComboBox();
		doctor = new javax.swing.JComboBox();
		cation = new javax.swing.JTextArea(200,50);
		entertime = new javax.swing.JTextField();
		room = new javax.swing.JComboBox();
		bed = new javax.swing.JComboBox();
		cancelbutton = new javax.swing.JButton();
		addbutton = new javax.swing.JButton();
		section = new javax.swing.JComboBox();
		infoBox = new JPanel();
		jScrollPane1 = new javax.swing.JScrollPane(cation);
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		GridBagLayout gridBag = new GridBagLayout();
		infoBox.setLayout(gridBag);
		GridBagConstraints ctitle = new GridBagConstraints();
		ctitle.anchor = ctitle.CENTER;
		ctitle.gridwidth = ctitle.REMAINDER;
		ctitle.fill = GridBagConstraints.BOTH;
		ctitle.weightx = 3.0;
//		ctitle.weighty = 2.0;
		ctitle.insets = new Insets(10, 200, 15, 0);
		GridBagConstraints clabel = new GridBagConstraints();
		clabel.anchor = GridBagConstraints.WEST;
		clabel.fill = GridBagConstraints.BOTH;
		clabel.ipadx = 5;
		clabel.ipady = 5;
		clabel.weightx = 1.0;
		clabel.weighty = 1.0;
		clabel.insets = new Insets(0, 30, 10, 30);
		GridBagConstraints cinput = new GridBagConstraints();
		cinput.anchor = GridBagConstraints.WEST;
		cinput.fill = GridBagConstraints.BOTH;
		cinput.gridwidth = GridBagConstraints.REMAINDER;
		cinput.ipadx = 5;
		cinput.ipady = 5;
		cinput.weightx = 2.0;
		cinput.weighty = 1.0;
		cinput.insets = new Insets(0, 0, 10, 30);
		GridBagConstraints cinputLarge = new GridBagConstraints();
		cinputLarge.anchor = GridBagConstraints.WEST;
		cinputLarge.fill = GridBagConstraints.BOTH;
		cinputLarge.gridwidth = GridBagConstraints.REMAINDER;
		cinputLarge.ipadx = 5;
		cinputLarge.ipady = 5;
		cinputLarge.weightx = 1.0;
		cinputLarge.weighty = 5.0;
		cinputLarge.insets = new Insets(0, 0, 10, 30);
		GridBagConstraints clabelLarge = new GridBagConstraints();
		clabelLarge.weighty = 5.0;
		clabelLarge.anchor = GridBagConstraints.WEST;
		clabelLarge.fill = GridBagConstraints.BOTH;
		clabelLarge.ipadx = 5;
		clabelLarge.ipady = 5;
		clabelLarge.weightx = 1.0;
		clabelLarge.insets = new Insets(0, 30, 10, 30);
		GridBagConstraints cbutton = new GridBagConstraints();
		cbutton.weighty = 2.0;
		cbutton.gridwidth = 2;
		cbutton.anchor = GridBagConstraints.CENTER;
		cbutton.ipadx = 5;
		cbutton.ipady = 5;
		
		//TODO 部分选择框、按键初始化
		sex.setModel(new DefaultComboBoxModel<String>(new String[] { "男","女" }));
		entertime.setEditable(true);
		uegency.setModel(new DefaultComboBoxModel<String>(new String[]{"1","2","3","4"}));
		room.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				roomActionPerformed(e);
				
			}
		});
		section.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sectionActionPerformed(e);
			}
		});
		
		addbutton.setText("Add");
		addbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addPatient();
			}
		});
		cancelbutton.setText("Clean");
		cancelbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cleanInfo();
			}
		});
		this.cleanInfo();
		
		infoBox.add(titleLabel, ctitle);
		infoBox.add(nameLabel, clabel);
		infoBox.add(name, cinput);
		infoBox.add(sexLabel, clabel);
		infoBox.add(sex, cinput);
		infoBox.add(uegencyLabel,clabel);
		infoBox.add(uegency,cinput);
		infoBox.add(dapartLabel, clabel);
		infoBox.add(section, cinput);
		infoBox.add(docLabel, clabel);
		infoBox.add(doctor, cinput);
		infoBox.add(enterTimeLabel, clabel);
		infoBox.add(entertime, cinput);
		infoBox.add(roomLabel, clabel);
		infoBox.add(room, cinput);
		infoBox.add(bedLabel, clabel);
		infoBox.add(bed, cinput);
		infoBox.add(situationLabel, clabelLarge);
		infoBox.add(jScrollPane1, cinputLarge);
		infoBox.add(addbutton, cbutton);
		infoBox.add(cancelbutton, cbutton);
		infoBox.setSize(600, 600);

		setContentPane(infoBox);
		pack();
		setBounds(0, 0, 600, 570);
	}
	

	
	private void cleanInfo() {
		name.setText("");
		
		sex.setSelectedIndex(0);
		
		uegency.setSelectedIndex(0);
		
		String[] allDepart = com.combo("select name from dept where kind='门诊'");
		section.setModel(new DefaultComboBoxModel<String>(allDepart));
		
		doctor.setModel(new DefaultComboBoxModel<String>());
		this.getDocsBySection();
		
		entertime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		String[] allRoom = com.combo("select distinct room from bed where patientid is null ");
		room.setModel(new DefaultComboBoxModel<String>(allRoom));
		
		bed.setModel(new DefaultComboBoxModel<String>());
		this.getBedsByRoom();
		
		cation.setText("");
	}
	
	//根据科室来取得科室中的医生信息
	private void sectionActionPerformed(ActionEvent evt) {
		this.getDocsBySection();
	}
	
	//根据病房获取病床信息
	private void roomActionPerformed(java.awt.event.ActionEvent evt) {
		this.getBedsByRoom();
	}
	
	private void getDocsBySection() {
		String deptname = section.getSelectedItem().toString();
		String[] s = com.combo("select name from employer where dept='"+deptname+"'");
		doctor.removeAllItems();
		for(int i = 0;i<s.length;i++){
			doctor.addItem(s[i]);
		}
		
	}
	
	private void getBedsByRoom() {
		String rstr = room.getSelectedItem().toString();
		String[] s = com.combo("select bed from bed where room = '"+rstr+"' and patientid is null");
		bed.removeAllItems();
		for(int i = 0;i<s.length;i++){
			bed.addItem(s[i]);
		}
	}
	
	private void addPatient() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(name.getText().equals("")||cation.getText().equals("")){
			JOptionPane.showMessageDialog(this, "please fill the \"Name\" completly!");
			return;
		}
		Patient p = new Patient();
		p.setName(name.getText());
		p.setBed(Integer.parseInt(bed.getSelectedItem().toString()));
		p.setUrgency(Integer.parseInt(uegency.getSelectedItem().toString()));
		p.setRoom(room.getSelectedItem().toString());
		p.setCation(cation.getText());
		p.setDoctor(doctor.getSelectedItem().toString());
		p.setSection(section.getSelectedItem().toString());
		p.setSex(sex.getSelectedItem().toString());
		try {
			p.setEnetertime(sdFormat.parse(entertime.getText().toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "please fill the \"Admission\" time in the given method!");
			return;
		}
		PatientModel patientmodel = new PatientModel();
		boolean flag = patientmodel.addPatient(p);
		if(flag){
			//管理病房
			BedModel bmodel = new BedModel();
			Bed b = new Bed();
			b.setId(p.getBed());
			b.setPatientid(patientmodel.queryId());
			b.setRoom(p.getRoom());
			bmodel.uptBed(b);
			
			JOptionPane.showMessageDialog(this, "增加病人住院信息成功");
			this.dispose();
			desktop.removeAll();
			PatientTableFrame tableframe = new PatientTableFrame();
			desktop.add(tableframe);
			tableframe.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(this, "增加病人住院信息失败");
		}
		
	}

}
