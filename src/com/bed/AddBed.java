package com.bed;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.model.ComboModel;
import com.util.DBHelp;

public class AddBed extends JInternalFrame{
	private JDesktopPane desktop;
	private JPanel infoBox;
	private ComboModel com;
	private JLabel titleLabel;
	private JLabel roomLabel;
	private JLabel bedLabel;
	private JTextField room;
	private JTextField bed;
	private JButton addButton;
	private JButton cleanButton;

	public AddBed(JDesktopPane desktop) {
		super("Add Bed",true,true,true,true);
		this.desktop = desktop;
		initComponents();
	}

	private void initComponents() {
		com = new ComboModel();
		
		titleLabel = new JLabel("Add Bed");
		titleLabel.setFont(new Font( "Myriad", 0, 18));
		roomLabel = new JLabel("Room");
		bedLabel = new JLabel("Bed");
		infoBox = new JPanel();
		room = new JTextField();
		bed = new JTextField();
		addButton = new JButton("Add");
		cleanButton = new JButton("Clean");
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onAdd();
			}
		});
		cleanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				room.setText("");
				bed.setText("");
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
		GridBagConstraints cbutton = new GridBagConstraints();
		cbutton.weighty = 2.0;
		cbutton.gridwidth = 2;
		cbutton.anchor = GridBagConstraints.CENTER;
		cbutton.ipadx = 5;
		cbutton.ipady = 5;
		
		infoBox.add(titleLabel, ctitle);
		infoBox.add(roomLabel, clabel);
		infoBox.add(room, cinput);
		infoBox.add(bedLabel, clabel);
		infoBox.add(bed, cinput);
		infoBox.add(addButton, cbutton);
		infoBox.add(cleanButton, cbutton);
		infoBox.setSize(500, 300);
		
		setContentPane(infoBox);
		pack();
		setBounds(0, 0, 500, 300);
	}

	protected void onAdd() {
		if (!checkbed()) {
			JOptionPane.showMessageDialog(this, "Add Failed: the content of room should be an int!");
			return;
		}
		Connection conn = DBHelp.getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("insert into bed(room,patientid,bed) values (?,null,?)");
			pst.setString(1, room.getText());
			pst.setInt(2, Integer.parseInt(bed.getText()));
			int num = pst.executeUpdate();
			if (num > 0) {
				JOptionPane.showMessageDialog(this, "Add Succeed!");
			}else {
				JOptionPane.showMessageDialog(this, "Add Failed!");
			}
		} catch (SQLServerException e) {
			JOptionPane.showMessageDialog(this, "Add Failed: please check whether the bed has already existed!");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelp.closeConn(pst);
			DBHelp.closeConn(conn);
		}
	}

	protected boolean checkbed() {
		boolean isInt = true;
		try {
			Integer.parseInt(bed.getText());
		} catch (NumberFormatException e) {
			isInt = false;
		}
		return isInt;
		
		
	}

}
