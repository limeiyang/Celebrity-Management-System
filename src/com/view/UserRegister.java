package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.UserDao;
import com.model.User;
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
import java.awt.Font;

public class UserRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField_zhanghao;
	private JTextField textField_mima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
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
	public UserRegister() {
		setTitle("\u65B0\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 275);
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
		setSize(450, 300);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(70, 75, 100, 18);
		contentPane.add(label);
		
		textField_zhanghao = new JTextField();
		textField_zhanghao.setBounds(174, 74, 187, 24);
		contentPane.add(textField_zhanghao);
		textField_zhanghao.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		label_1.setBounds(70, 123, 100, 18);
		contentPane.add(label_1);
		
		textField_mima = new JTextField();
		textField_mima.setBounds(174, 122, 187, 24);
		contentPane.add(textField_mima);
		textField_mima.setColumns(10);
		
		JButton btnNewButton_zhuce = new JButton("\u6CE8\u518C");
		btnNewButton_zhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Butzhuce();
			}
		});
		btnNewButton_zhuce.setBounds(74, 174, 287, 27);
		contentPane.add(btnNewButton_zhuce);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Butfanhui();
			}
		});
		btnNewButton.setBounds(305, 13, 113, 27);
		contentPane.add(btnNewButton);
	}
	

    /*
         * 添加背景
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\zhuce.jpg"); //添加图片
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}
	
	/*
	 * 确认注册事件
	 */
	protected void Butzhuce() {
		String userName = this.textField_zhanghao.getText(); //获取输入的账号
		String password = new String(this.textField_mima.getText());//获取输入的密码
		
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "账号不能为空");
			return;
		}else if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		
		User user = new User(userName,password);
		Connection con = null;
		//System.out.println(userName);
		try{
			con = DbUtil.getCon();
			int currentUser = 0;
			currentUser=UserDao.register(con, user);
			if(currentUser == 1) {
				dispose();//关闭这个页面
			    new Login().setVisible(true); //打开login
			}else {
				JOptionPane.showMessageDialog(null,"注册失败，请稍后再试");
			}
			//System.out.println("注册返回值"+currentUser);
//			if(currentUser!=null){
//				//JOptionPane.showMessageDialog(null,"登录成功");	
//				frame.dispose();//关闭这个页面
//			    new Home().setVisible(true); //打开Main
//			}else{
//				JOptionPane.showMessageDialog(null,"用户名密码错误");
//			}
			
		}catch(Exception e1){
			e1.printStackTrace();
			
		} 
	}
	protected void Butfanhui(){
		dispose();
		new Login().setVisible(true);
	}
}
