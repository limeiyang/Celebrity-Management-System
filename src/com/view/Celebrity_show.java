package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import com.dao.CelebrityDao;
import com.model.Celebrity;
import com.model.Emperor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Celebrity_show extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Celebrity_show frame = new Celebrity_show();
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
	public Celebrity_show() {
		Celebrity celebrity1 = new Celebrity();
		
		setTitle("\u540D\u4EBA\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
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
		setSize(450, 385);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane textPane_xingming = new JTextPane();
		textPane_xingming.setBounds(95, 28, 93, 21);
		contentPane.add(textPane_xingming);
		textPane_xingming.setText(celebrity1.getCxingming());//姓名
		
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(40, 19, 41, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5E74\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(214, 19, 53, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6C11\u65CF");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(40, 56, 41, 26);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5B98\u804C");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(224, 56, 41, 26);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u8EAB\u5730");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 95, 68, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("\u6210\u5C31");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(40, 131, 41, 30);
		contentPane.add(label_4);
		
		JTextPane textPane_nianhao = new JTextPane();
		textPane_nianhao.setBounds(281, 28, 93, 21);
		contentPane.add(textPane_nianhao);
		textPane_nianhao.setText(celebrity1.getCnianhao());
		
		JTextPane textPane_minzu = new JTextPane();
		textPane_minzu.setBounds(95, 61, 93, 21);
		contentPane.add(textPane_minzu);
		textPane_minzu.setText(celebrity1.getCminzu());
		
		JTextPane textPane_guanzhi = new JTextPane();
		textPane_guanzhi.setBounds(279, 56, 93, 21);
		contentPane.add(textPane_guanzhi);
		textPane_guanzhi.setText(celebrity1.getCguanzhi());
		
		JTextPane textPane_chushengdi = new JTextPane();
		textPane_chushengdi.setBounds(115, 95, 259, 21);
		contentPane.add(textPane_chushengdi);
		textPane_chushengdi.setText(celebrity1.getCchushengdi());
		
		JTextPane textPane_chengjiu = new JTextPane();
		textPane_chengjiu.setBounds(40, 161, 313, 125);
		contentPane.add(textPane_chengjiu);
		textPane_chengjiu.setText(celebrity1.getCchengjiu());
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
			}
		});
		btnNewButton.setBounds(324, 298, 83, 27);
		contentPane.add(btnNewButton);
	}

    /*
         * 添加背景
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\celebriteShow.png"); //添加图片
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}
}
