package com.bed;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.model.ComboModel;
import com.sun.org.apache.xpath.internal.operations.And;
import com.util.DBHelp;

public class ManageBed extends JInternalFrame{
	private JDesktopPane desktop;
	private JPanel infoBox;
	private ComboModel com;
	private JLabel titleLabel;
	private JLabel roomLabel;
	private JLabel bedLabel;
	private JLabel patientLabel;
	private JLabel newRoomLabel;
	private JLabel newBedLabel;
	private JComboBox room;
	private JComboBox bed;
	private JTextField patientId;
	private JTextField newRoom;
	private JTextField newBed;
	private JButton deleteButton;
	private JButton updateButton;
	

	public ManageBed(JDesktopPane desktop) {
		super("Manage Bed",true,true,true,true);
		this.desktop = desktop;
		initComponents();
	}


	private void initComponents() {
		com = new ComboModel();
		
		titleLabel = new JLabel("Manage Bed");
		titleLabel.setFont(new Font( "Myriad", 0, 18));
		roomLabel = new JLabel("Room");
		bedLabel = new JLabel("Bed");
		patientLabel = new JLabel("patient case");
		room = new JComboBox();
		bed = new JComboBox();
		infoBox = new JPanel();
		patientId = new JTextField();
		patientId.setEditable(false);
		newRoom = new JTextField();
		newBed = new JTextField();
		newBedLabel = new JLabel("new value:");
		newRoomLabel = new JLabel("new value:");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		String[] allRoom = com.combo("select distinct room from bed");
		room.setModel(new DefaultComboBoxModel<String>(allRoom));
		bed.setModel(new DefaultComboBoxModel<String>());
		this.getBedsByRoom();
		this.getPatientByRoomBed();
		room.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBedsByRoom();
				getPatientByRoomBed();
			}
		});
		bed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				getPatientByRoomBed();
			}
		});
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onUpdate(e);
				getBedsByRoom();
				getPatientByRoomBed();
				newBed.setText("");
				newRoom.setText("");
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onDelete();
				getBedsByRoom();
				getPatientByRoomBed();
			}
		});
		 
		
		GridBagLayout gridBag = new GridBagLayout();
		infoBox.setLayout(gridBag);
		GridBagConstraints ctitle = new GridBagConstraints();
		ctitle.anchor = ctitle.CENTER;
		ctitle.gridwidth = ctitle.REMAINDER;
		ctitle.fill = GridBagConstraints.BOTH;
		ctitle.weightx = 3.0;
//		ctitle.weighty = 2.0;
		ctitle.insets = new Insets(10, 350, 15, 0);
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
		cinput.gridwidth = 1;
		cinput.ipadx = 5;
		cinput.ipady = 5;
		cinput.weightx = 2.0;
		cinput.weighty = 1.0;
		cinput.insets = new Insets(0, 0, 10, 30);
		GridBagConstraints cinput2 = new GridBagConstraints();
		cinput2.anchor = GridBagConstraints.WEST;
		cinput2.fill = GridBagConstraints.BOTH;
		cinput2.gridwidth = GridBagConstraints.REMAINDER;
		cinput2.ipadx = 5;
		cinput2.ipady = 5;
		cinput2.weightx = 2.0;
		cinput2.weighty = 1.0;
		cinput2.insets = new Insets(0, 0, 10, 30);
		GridBagConstraints cbutton = new GridBagConstraints();
		cbutton.weighty = 2.0;
		cbutton.gridwidth = 2;
		cbutton.anchor = GridBagConstraints.CENTER;
		cbutton.ipadx = 5;
		cbutton.ipady = 5;
		
		infoBox.add(titleLabel, ctitle);
		infoBox.add(roomLabel, clabel);
		infoBox.add(room, cinput);
		infoBox.add(newRoomLabel,clabel);
		infoBox.add(newRoom,cinput2);
		infoBox.add(bedLabel, clabel);
		infoBox.add(bed, cinput);
		infoBox.add(newBedLabel,clabel);
		infoBox.add(newBed,cinput2);
		infoBox.add(patientLabel,clabel);
		infoBox.add(patientId,cinput2);
		infoBox.add(updateButton, cbutton);
		infoBox.add(deleteButton, cbutton);
		infoBox.setSize(800, 300);

		setContentPane(infoBox);
		pack();
		setBounds(0, 0, 800, 300);
		
//		Ñ¡Ôñ¿ò³õÊ¼»¯
		
		
	}


	protected void onDelete() {
		if (!(patientId.getText().equals("null")||patientId.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Delete Failed: you cannot delete the bed with patient in it!");
			return;
		}
		Connection conn = DBHelp.getConnection();
		Statement statement = null;
		try {
			statement = conn.createStatement();
			int flag = statement.executeUpdate("DELETE FROM bed WHERE room = '" + room.getSelectedItem().toString() +"' and bed = '"+bed.getSelectedItem().toString()+"' ");
			if (flag>0) {
				JOptionPane.showMessageDialog(this, "Delete Succeed!");
			}else {
				JOptionPane.showMessageDialog(this, "Delete Failed!");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			DBHelp.closeConn(statement);
			DBHelp.closeConn(conn);
		}
	}


	protected void onUpdate(ActionEvent e) {
		Connection conn = DBHelp.getConnection();
		Statement statement = null;
		String newRoom = this.newRoom.getText().equals("") ? room.getSelectedItem().toString() : this.newRoom.getText();
		String newBed = this.newBed.getText().equals("") ? bed.getSelectedItem().toString() : this.newBed.getText();
		try {
			statement = conn.createStatement();
			int num2 = 1;
			int num = statement.executeUpdate("update bed set room = "+newRoom+" ,bed = '"+newBed+"' where room = '"+room.getSelectedItem().toString()+"' and bed = '"+bed.getSelectedItem().toString()+"' ");
			if (num>0) {
				if (!(patientId.getText().equals("null")||patientId.getText().equals(""))) {
					num2 = statement.executeUpdate("update patient set room = '"+newRoom+"' ,bed = '"+newBed+"' where id = "+Integer.parseInt(patientId.getText()));
				}
				if (num2>0) {
					JOptionPane.showMessageDialog(this, "Update Succeed!");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Update Failed!");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			DBHelp.closeConn(statement);
			DBHelp.closeConn(conn);
		}
	}


	private void getPatientByRoomBed() {
		// TODO Auto-generated method stub
		String rstr = room.getSelectedItem().toString();
		String bstr = bed.getSelectedItem().toString();
		String[] s = com.combo("select patientid from bed where room = '"+rstr+"' and bed = '"+bstr+"' ");
		if (s.length == 0) {
			patientId.setText("");
		}else {
			patientId.setText(s[0]);
		}
	}


	private void getBedsByRoom() {
		// TODO Auto-generated method stub
		String rstr = room.getSelectedItem().toString();
		String[] s = com.combo("select bed from bed where room = '"+rstr+"' ");
		bed.setModel(new DefaultComboBoxModel<String>(s));
		
	}

}
