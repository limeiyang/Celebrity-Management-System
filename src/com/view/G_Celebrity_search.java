package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.CelebrityDao;
import com.model.Celebrity;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class G_Celebrity_search extends JFrame {

	private JPanel contentPane;
	private JTextField textField_searchText;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_Celebrity_search frame = new G_Celebrity_search();
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
	public G_Celebrity_search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_searchText = new JTextField();
		textField_searchText.setBounds(27, 25, 127, 24);
		contentPane.add(textField_searchText);
		textField_searchText.setColumns(10);
		
		JButton button_search = new JButton("\u641C\u7D22");
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchButAction();
			}
		});
		button_search.setBounds(183, 24, 113, 27);
		contentPane.add(button_search);
		
		button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home().setVisible(true);
			}
		});
		button.setBounds(310, 24, 87, 27);
		contentPane.add(button);
	}
	protected void SearchButAction() {
		String searchText = textField_searchText.getText();
		
		Connection con = null;
		try {
			con = DbUtil.getCon();
			Celebrity celebrity1 = CelebrityDao.FindEByAll(con, searchText);
			if(celebrity1 != null) {
				dispose();
				new G_Celebrity_show().setVisible(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
