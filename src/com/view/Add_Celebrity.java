package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.UserDao;
import com.dao.CelebrityDao;
import com.model.Celebrity;
import com.util.DbUtil;
import com.util.StringUtil;
import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Add_Celebrity extends JFrame {

	private JPanel contentPane;
	private JTextField textField_xingming;
	private JTextField textField_minzu;
	private JTextField textField_chushengdi;
	private JTextField textField_nianhao;
	private JTextField textField_guanzhi;
	private JTextField textField_jianjie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Celebrity frame = new Add_Celebrity();
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
	public Add_Celebrity() {
		setTitle("\u6DFB\u52A0\u4EBA\u7269");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 372);
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
		setSize(450, 376);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(58, 25, 31, 15);
		contentPane.add(label);
		
		textField_xingming = new JTextField();
		textField_xingming.setBounds(99, 22, 97, 21);
		contentPane.add(textField_xingming);
		textField_xingming.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6C11\u65CF");
		label_1.setBounds(276, 19, 54, 27);
		contentPane.add(label_1);
		
		textField_minzu = new JTextField();
		textField_minzu.setBounds(317, 22, 95, 21);
		contentPane.add(textField_minzu);
		textField_minzu.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u751F\u5730");
		label_2.setBounds(48, 63, 66, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u53F7");
		label_3.setBounds(276, 59, 31, 19);
		contentPane.add(label_3);
		
		JLabel lblj = new JLabel("\u7B80\u4ECB");
		lblj.setBounds(58, 136, 40, 33);
		contentPane.add(lblj);
		
		JLabel label_5 = new JLabel("\u5B98\u804C");
		label_5.setBounds(58, 108, 54, 15);
		contentPane.add(label_5);
		
		textField_chushengdi = new JTextField();
		textField_chushengdi.setBounds(99, 60, 97, 21);
		contentPane.add(textField_chushengdi);
		textField_chushengdi.setColumns(10);
		
		textField_nianhao = new JTextField();
		textField_nianhao.setBounds(317, 60, 95, 21);
		contentPane.add(textField_nianhao);
		textField_nianhao.setColumns(10);
		
		textField_guanzhi = new JTextField();
		textField_guanzhi.setBounds(99, 104, 97, 21);
		contentPane.add(textField_guanzhi);
		textField_guanzhi.setColumns(10);
		
		JButton btnNewButton_celebrity = new JButton("\u6DFB\u52A0\u540D\u4EBA");
		btnNewButton_celebrity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButAddCelebrity();
			}
		});
		btnNewButton_celebrity.setBounds(241, 285, 154, 27);
		contentPane.add(btnNewButton_celebrity);
		
		textField_jianjie = new JTextField();
		textField_jianjie.setBounds(58, 168, 354, 89);
		contentPane.add(textField_jianjie);
		textField_jianjie.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home().setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 285, 154, 27);
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
	protected void ButAddCelebrity() {
		String xingming = this.textField_xingming.getText();
		String minzu = this.textField_minzu.getText();
		String chushengdi = this.textField_chushengdi.getText();
		String nianhao = this.textField_nianhao.getText();
		String guanzhi = this.textField_guanzhi.getText();
		String jianjie = this.textField_jianjie.getText();
		
		if (StringUtil.isEmpty(xingming)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}else if(StringUtil.isEmpty(nianhao)) {
			JOptionPane.showMessageDialog(null, "年号不能为空");
			return;
		}
		Celebrity celebrity = new Celebrity(xingming,minzu,chushengdi,nianhao,guanzhi,jianjie);
		Connection con = null;
		try {
			con = DbUtil.getCon();
			int currentUser = 0;
			currentUser=CelebrityDao.AddCelcbrity(con, celebrity);
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
