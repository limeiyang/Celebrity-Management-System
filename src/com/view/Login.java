package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import com.mysql.jdbc.Connection;

import com.dao.UserDao;
import com.model.User;
import com.util.DbUtil;
import com.view.Main;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class Login extends JFrame {

	private JPanel zhuyeimian;
	private JTextField zhanghao;
	private JPasswordField passwordField;
	private JPasswordField mima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setBak(); //调用背景方法
		Container c = getContentPane(); //获取JFrame面板
		
	    JPanel zhuyeimian = new JPanel(); //创建个JPanel
	    zhuyeimian.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
		c.add(zhuyeimian);
		zhuyeimian.setLayout(null);
		setSize(450, 300);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF---\u767B\u5F55");
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
//		zhuyeimian = new JPanel();
//		zhuyeimian.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(zhuyeimian);
//		zhuyeimian.setLayout(null);
		
		//--------------------------------------------------------------
		
		
//		setTitle("\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF---\u767B\u5F55");
//		setFont(new Font("微软雅黑", Font.PLAIN, 15));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		zhuyeimian = new JPanel();
//		zhuyeimian.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(zhuyeimian);
//		zhuyeimian.setLayout(null);
		
		zhanghao = new JTextField();
		zhanghao.setBounds(166, 66, 144, 24);
		zhuyeimian.add(zhanghao);
		zhanghao.setColumns(10);
		
		mima = new JPasswordField(); //密码输入框
		mima.setBounds(166, 103, 144, 24);
		zhuyeimian.add(mima);
		
		JLabel label = new JLabel("\u8D26\u53F7"); //【账号】字
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 20));
		label.setBounds(94, 63, 58, 27);
		zhuyeimian.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");//【密码】字
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(94, 103, 58, 24);
		zhuyeimian.add(label_1);
		
		JButton button_zhuce = new JButton("\u6CE8\u518C"); //注册按钮
		button_zhuce.setFont(new Font("宋体", Font.PLAIN, 20));
		button_zhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register();
				//注册函数
			}
		});
		button_zhuce.setBounds(94, 167, 86, 27);
		zhuyeimian.add(button_zhuce);
		
		
		
		
		
		JRadioButton radioButton_yonghu = new JRadioButton("\u7528\u6237",true);
		radioButton_yonghu.setFont(new Font("宋体", Font.BOLD, 15));
		radioButton_yonghu.setBounds(104, 136, 76, 27);
		zhuyeimian.add(radioButton_yonghu);
		radioButton_yonghu.setOpaque(false);
		
		JRadioButton radioButton_guanliyuan = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton_guanliyuan.setFont(new Font("宋体", Font.BOLD, 15));
		radioButton_guanliyuan.setBounds(210, 136, 100, 27);
		zhuyeimian.add(radioButton_guanliyuan);
		radioButton_guanliyuan.setOpaque(false);
		
		ButtonGroup group=new ButtonGroup();
		group.add(radioButton_yonghu);
		group.add(radioButton_guanliyuan);
		

		
		
        
        JButton button_denglu = new JButton("\u767B\u5F55"); //确认登录按钮
		button_denglu.setFont(new Font("宋体", Font.PLAIN, 20));
		button_denglu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginSuccess(radioButton_yonghu);//确认登录函数
			}
		});
		
		button_denglu.setBounds(224, 167, 86, 27);
		zhuyeimian.add(button_denglu);
		
		
	}
	
//	setBak(); //调用背景方法
//	Container c = getContentPane(); //获取JFrame面板
//    JPanel contentPane = new JPanel(); //创建个JPanel
//	contentPane.setOpaque(false); //把JPanel设置为透明 这样就不会遮住后面的背景 这样你就能在JPanel随意加组件了
//	c.add(contentPane);
//	contentPane.setLayout(null);
//	setSize(450, 300);
//	setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

     

	
	/**
	 * 登录
	 */
	public void loginSuccess(JRadioButton radioButton_yonghu) {
		
		if(radioButton_yonghu.isSelected()) {
        	System.err.println("yonghu");
        	String userName = this.zhanghao.getText(); //获取输入的账号
    		String password = new String(this.mima.getPassword());//获取输入的密码
    		
    		User user = new User(userName,password);
    		Connection con = null;
    		//System.out.println(userName);
    		try{
    			con = DbUtil.getCon();
    			User currentUser=UserDao.login(con, user);
    			if(currentUser!=null){
    				//JOptionPane.showMessageDialog(null,"登录成功");	
    				dispose();//关闭这个页面
    			    new Main().setVisible(true); //打开Main
    			}else{
    				JOptionPane.showMessageDialog(null,"用户名密码错误");
    			}
    			
    		}catch(Exception e1){
    			e1.printStackTrace();
    			
    		}
        }else {
        	System.err.println("guanliyuan");
        	String userName = this.zhanghao.getText(); //获取输入的账号
    		String password = new String(this.mima.getPassword());//获取输入的密码
    		String userNametrue = "root";
    		String passwordtrue = "123456";
    		if(userName.equals(userNametrue)) {
    			if(password.equals(passwordtrue)) {
    				dispose();
    				new Home().setVisible(true);
    			}else {
    				JOptionPane.showMessageDialog(null,"管理员用户名密码错误");
    			}
    		}else {
    			JOptionPane.showMessageDialog(null,"管理员用户名密码错误");
    		}
        	
        }
		
	}
	/*
	 * 注册
	 */
	protected void register() {
		
				dispose();//关闭这个页面
			    new UserRegister().setVisible(true); //打开Main
			
	}
}
