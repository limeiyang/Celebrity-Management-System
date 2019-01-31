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
		
		//皇帝查询
		JMenuItem mntmNewMenuItem_chaxun = new JMenuItem("\u67E5\u8BE2");
		mnNewMenu_emperor.add(mntmNewMenuItem_chaxun);
		mntmNewMenuItem_chaxun.setIcon(new ImageIcon("src\\pic\\chaxun.png"));
		mntmNewMenuItem_chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
			    new G_Emperor_search().setVisible(true); 
			}
		});
		
		//皇帝添加
		JMenuItem mntmNewMenuItem_tianjia = new JMenuItem("\u6DFB\u52A0");
		mnNewMenu_emperor.add(mntmNewMenuItem_tianjia);
		mntmNewMenuItem_tianjia.setIcon(new ImageIcon("src\\pic\\tianjia.png"));
		mntmNewMenuItem_tianjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
			    new Add_Emperor().setVisible(true);
			}
		});
		
		JMenu mnNewMenu_celebrity = new JMenu("\u540D\u4EBA");
		mnNewMenu_celebrity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_celebrity);
		
		//名人查询
		JMenuItem mntmNewMenuItem_chaxunm = new JMenuItem("\u67E5\u8BE2");
		mnNewMenu_celebrity.add(mntmNewMenuItem_chaxunm);
		mntmNewMenuItem_chaxunm.setIcon(new ImageIcon("src\\pic\\chaxun.png"));
		mntmNewMenuItem_chaxunm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
			    new G_Celebrity_search().setVisible(true); 
			}
		});
		
		//名人添加
		JMenuItem mntmNewMenuItem_tianjiam = new JMenuItem("\u6DFB\u52A0");
		mnNewMenu_celebrity.add(mntmNewMenuItem_tianjiam);
		mntmNewMenuItem_tianjiam.setIcon(new ImageIcon("src\\pic\\tianjia.png"));
		mntmNewMenuItem_tianjiam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
			    new Add_Celebrity().setVisible(true); 
			}
		});
		
		JMenu menu = new JMenu("\u5173\u4E8E");
		menuBar.add(menu);

		
		//我们
		JMenuItem menuItem_we = new JMenuItem("\u6211\u4EEC");
		menu.add(menuItem_we);
		menuItem_we.setIcon(new ImageIcon("src\\pic\\we.png"));
		menuItem_we.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
				JOptionPane.showMessageDialog(null,"武汉工程大学计算机科学与工程学院—李美扬");
			 
			}
		});
		
		//反馈
		JMenuItem menuItem_fankui = new JMenuItem("\u53CD\u9988");
		menu.add(menuItem_fankui);
		menuItem_fankui.setIcon(new ImageIcon("src\\pic\\fankui.png"));
		menuItem_fankui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();//关闭这个页面
				JOptionPane.showMessageDialog(null,"1730422101@qq.com");
			 
			}
		});
		
//		contentPane = new JPanel();
//		contentPane.setToolTipText("\u4E3B\u9875\u9762");
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		setBak(); //调用背景方法
		Container c = getContentPane(); //获取JFrame面板
	    JPanel contentPane = new JPanel(); //创建个JPanel
		contentPane.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		c.add(contentPane);
		contentPane.setLayout(null);
		setSize(708, 502);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    /*
         * 添加背景
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\home.jpg"); //添加图片
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}

}
