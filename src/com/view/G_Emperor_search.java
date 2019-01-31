package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Emperor;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;
import com.dao.EmperorDao;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class G_Emperor_search extends JFrame {

	private JPanel contentPane;
	private JTextField textField_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_Emperor_search frame = new G_Emperor_search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public G_Emperor_search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_search = new JTextField();
		textField_search.setBounds(14, 13, 168, 24);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		JButton button_search = new JButton("\u641C\u7D22");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ButESearchAction();//ËÑË÷ÊÂ¼þ
			}
		});
		button_search.setBounds(214, 12, 77, 27);
		contentPane.add(button_search);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Butfanhui();
			}
		});
		btnNewButton.setBounds(326, 12, 77, 27);
		contentPane.add(btnNewButton);
	}
	protected void ButESearchAction(){
		String searchtxt = this.textField_search.getText();
		
		Connection con = null;
		try {
			con = DbUtil.getCon();
			Emperor emperor1 = EmperorDao.FindEByAll(con,searchtxt);
			if(emperor1 != null) {
				dispose();
				new G_Emperor_show().setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void Butfanhui() {
		dispose();
		new Home().setVisible(true);
	}
}
