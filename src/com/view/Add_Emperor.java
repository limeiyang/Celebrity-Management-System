package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.CelebrityDao;
import com.dao.EmperorDao;
import com.model.Celebrity;
import com.model.Emperor;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Emperor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_xingming;
	private JTextField textField_minzu;
	private JTextField textField_chushengdi;
	private JTextField textField_nianhao;
	private JTextField textField_zaiweishijian;
	private JTextField textField_miaohao;
	private JTextField textField_shihao;
	private JTextField textField_jianjie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Emperor frame = new Add_Emperor();
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
	public Add_Emperor() {
		setTitle("\u6DFB\u52A0\u7687\u5E1D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 401);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		setBak(); //调用背景方法
		Container c = getContentPane(); //获取JFrame面板
	    JPanel contentPane = new JPanel(); //创建个JPanel
		contentPane.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		c.add(contentPane);
		contentPane.setLayout(null);
		setSize(450, 411);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(48, 22, 41, 18);
		contentPane.add(label);
		
		textField_xingming = new JTextField();
		textField_xingming.setBounds(99, 22, 66, 21);
		contentPane.add(textField_xingming);
		textField_xingming.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6C11\u65CF");
		label_1.setBounds(236, 22, 54, 18);
		contentPane.add(label_1);
		
		textField_minzu = new JTextField();
		textField_minzu.setBounds(288, 20, 66, 21);
		contentPane.add(textField_minzu);
		textField_minzu.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u751F\u5730");
		label_2.setBounds(23, 53, 66, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u53F7");
		label_3.setBounds(236, 53, 31, 25);
		contentPane.add(label_3);
		
		JLabel lblj = new JLabel("\u6210\u5C31/\u7B80\u4ECB");
		lblj.setBounds(23, 168, 97, 15);
		contentPane.add(lblj);
		
		JLabel label_7 = new JLabel("\u5728\u4F4D\u65F6\u95F4");
		label_7.setBounds(23, 91, 74, 27);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u5E99\u53F7");
		label_8.setBounds(236, 91, 54, 25);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u8C25\u53F7");
		label_9.setBounds(48, 131, 54, 24);
		contentPane.add(label_9);
		
		textField_chushengdi = new JTextField();
		textField_chushengdi.setBounds(99, 60, 66, 21);
		contentPane.add(textField_chushengdi);
		textField_chushengdi.setColumns(10);
		
		textField_nianhao = new JTextField();
		textField_nianhao.setBounds(288, 53, 66, 21);
		contentPane.add(textField_nianhao);
		textField_nianhao.setColumns(10);
		
		textField_zaiweishijian = new JTextField();
		textField_zaiweishijian.setBounds(99, 93, 66, 21);
		contentPane.add(textField_zaiweishijian);
		textField_zaiweishijian.setColumns(10);
		
		textField_miaohao = new JTextField();
		textField_miaohao.setBounds(288, 93, 66, 21);
		contentPane.add(textField_miaohao);
		textField_miaohao.setColumns(10);
		
		textField_shihao = new JTextField();
		textField_shihao.setBounds(99, 132, 66, 21);
		contentPane.add(textField_shihao);
		textField_shihao.setColumns(10);
		
		textField_jianjie = new JTextField();
		textField_jianjie.setBounds(48, 196, 307, 100);
		contentPane.add(textField_jianjie);
		textField_jianjie.setColumns(10);
		
		JButton btnNewButton_emperor = new JButton("\u6DFB\u52A0\u7687\u5E1D");
		btnNewButton_emperor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButAddEmperor();
			}
		});
		btnNewButton_emperor.setBounds(232, 319, 152, 27);
		contentPane.add(btnNewButton_emperor);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home().setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 319, 152, 27);
		contentPane.add(btnNewButton);
	}

    /*
         * 添加背景
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\login2.jpg"); //添加图片
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}

	/*
	 * 添加事件
	 */
	protected void ButAddEmperor() {
		String xingming = this.textField_xingming.getText();
		String zaiweishijian = this.textField_zaiweishijian.getText();
		String miaohao = this.textField_miaohao.getText();
		String nianhao = this.textField_nianhao.getText();
		String shihao = this.textField_shihao.getText();
		String minzu = this.textField_minzu.getText();
		String chushengdi = this.textField_chushengdi.getText();
		String jianjie = this.textField_jianjie.getText();
		
		if (StringUtil.isEmpty(xingming)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}else if(StringUtil.isEmpty(nianhao)) {
			JOptionPane.showMessageDialog(null, "年号不能为空");
			return;
		}
		Emperor emperor = new Emperor(xingming,zaiweishijian,miaohao,nianhao,minzu,chushengdi,shihao,jianjie);
		Connection con = null;
		try {
			//System.err.println("name"+emperor.getEnianhao());
			con = DbUtil.getCon();
			int currentUser = 0;
			currentUser=EmperorDao.AddEmperor(con, emperor);
			if(currentUser == 1) {
				dispose();//关闭这个页面
			    new Home().setVisible(true); //打开login
			}else {
				JOptionPane.showMessageDialog(null,"添加失败，请稍后再试");
			}
		}catch(Exception e1){
			e1.printStackTrace();
			
		} 
	}
	
}
