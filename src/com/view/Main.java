package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.CelebrityDao;
import com.dao.EmperorDao;
import com.model.Celebrity;
import com.model.Emperor;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_emperortext;
	private JTextField textField_Celebrity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 231);
		setBak(); //���ñ�������
		Container c = getContentPane(); //��ȡJFrame���
	    JPanel contentPane = new JPanel(); //������JPanel
		contentPane.setOpaque(false); //��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		c.add(contentPane);
		contentPane.setLayout(null);
		setSize(396, 253);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		textField_emperortext = new JTextField();
		textField_emperortext.setBounds(63, 54, 138, 24);
		contentPane.add(textField_emperortext);
		textField_emperortext.setColumns(10);
		
		JButton btnNewButton_emperor = new JButton("\u7687\u5E1D\u641C\u7D22");
		btnNewButton_emperor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emperorSearch();
			}
		});
		btnNewButton_emperor.setBounds(221, 51, 113, 27);
		contentPane.add(btnNewButton_emperor);
		
		textField_Celebrity = new JTextField();
		textField_Celebrity.setBounds(63, 115, 138, 24);
		contentPane.add(textField_Celebrity);
		textField_Celebrity.setColumns(10);
		
		JButton btnNewButton_Celebrity = new JButton("\u540D\u4EBA\u641C\u7D22");
		btnNewButton_Celebrity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				celebritySearch();
			}
		});
		btnNewButton_Celebrity.setBounds(221, 114, 113, 27);
		contentPane.add(btnNewButton_Celebrity);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnNewButton.setBounds(301, 11, 63, 27);
		contentPane.add(btnNewButton);
	}
	

    /*
         * ��ӱ���
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\main.jpg"); //���ͼƬ
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}

	
	/*
	 * �ʵ�����
	 */
	protected void emperorSearch() {
        String searchword = this.textField_emperortext.getText();//��ȡ���������������
		
		Connection con = null;
		
		try {
			con = DbUtil.getCon();
			Emperor emperor1 = EmperorDao.FindEByAll(con, searchword);
			if(emperor1!=null) {
				dispose();
				
				new Emperor_show().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"�����ڸ����");
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	/*
	 * ��������
	 */
	protected void celebritySearch() {
        String searchword = this.textField_Celebrity.getText();//��ȡ���������������
		
		Connection con = null;
		
		try {
			con = DbUtil.getCon();
			Celebrity celebrity1 = CelebrityDao.FindEByAll(con, searchword);
			System.out.println("����ֵ"+celebrity1);
			if(celebrity1!=null) {
				dispose();
				
				new Celebrity_show().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"�����ڸ����");
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

}
