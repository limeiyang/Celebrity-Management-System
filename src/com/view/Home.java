package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("\u4E3B\u9875\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 547);
		

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnNewMenu_emperor = new JMenu("\u7687\u5E1D");
		menuBar.add(mnNewMenu_emperor);
		mnNewMenu_emperor.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		//�ʵ۲�ѯ
		JMenuItem mntmNewMenuItem_chaxun = new JMenuItem("\u67E5\u8BE2");
		mnNewMenu_emperor.add(mntmNewMenuItem_chaxun);
		mntmNewMenuItem_chaxun.setIcon(new ImageIcon("src\\pic\\chaxun.png"));
		mntmNewMenuItem_chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
			    new G_Emperor_search().setVisible(true); 
			}
		});
		
		//�ʵ����
		JMenuItem mntmNewMenuItem_tianjia = new JMenuItem("\u6DFB\u52A0");
		mnNewMenu_emperor.add(mntmNewMenuItem_tianjia);
		mntmNewMenuItem_tianjia.setIcon(new ImageIcon("src\\pic\\tianjia.png"));
		mntmNewMenuItem_tianjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
			    new Add_Emperor().setVisible(true);
			}
		});
		
		JMenu mnNewMenu_celebrity = new JMenu("\u540D\u4EBA");
		mnNewMenu_celebrity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_celebrity);
		
		//���˲�ѯ
		JMenuItem mntmNewMenuItem_chaxunm = new JMenuItem("\u67E5\u8BE2");
		mnNewMenu_celebrity.add(mntmNewMenuItem_chaxunm);
		mntmNewMenuItem_chaxunm.setIcon(new ImageIcon("src\\pic\\chaxun.png"));
		mntmNewMenuItem_chaxunm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
			    new G_Celebrity_search().setVisible(true); 
			}
		});
		
		//�������
		JMenuItem mntmNewMenuItem_tianjiam = new JMenuItem("\u6DFB\u52A0");
		mnNewMenu_celebrity.add(mntmNewMenuItem_tianjiam);
		mntmNewMenuItem_tianjiam.setIcon(new ImageIcon("src\\pic\\tianjia.png"));
		mntmNewMenuItem_tianjiam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
			    new Add_Celebrity().setVisible(true); 
			}
		});
		
		JMenu menu = new JMenu("\u5173\u4E8E");
		menuBar.add(menu);

		
		//����
		JMenuItem menuItem_we = new JMenuItem("\u6211\u4EEC");
		menu.add(menuItem_we);
		menuItem_we.setIcon(new ImageIcon("src\\pic\\we.png"));
		menuItem_we.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
				JOptionPane.showMessageDialog(null,"�人���̴�ѧ�������ѧ�빤��ѧԺ��������");
			 
			}
		});
		
		//����
		JMenuItem menuItem_fankui = new JMenuItem("\u53CD\u9988");
		menu.add(menuItem_fankui);
		menuItem_fankui.setIcon(new ImageIcon("src\\pic\\fankui.png"));
		menuItem_fankui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//�ر����ҳ��
				JOptionPane.showMessageDialog(null,"1730422101@qq.com");
			 
			}
		});
		
//		contentPane = new JPanel();
//		contentPane.setToolTipText("\u4E3B\u9875\u9762");
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		setBak(); //���ñ�������
		Container c = getContentPane(); //��ȡJFrame���
	    JPanel contentPane = new JPanel(); //������JPanel
		contentPane.setOpaque(false); //��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		c.add(contentPane);
		contentPane.setLayout(null);
		setSize(708, 502);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    /*
         * ��ӱ���
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\home.jpg"); //���ͼƬ
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}

}
