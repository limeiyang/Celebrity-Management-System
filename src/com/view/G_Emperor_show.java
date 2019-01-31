package com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import com.model.Emperor;
import com.mysql.jdbc.Connection;
import com.util.DbUtil;
import com.util.StringUtil;
import com.dao.EmperorDao;
import javax.swing.JTextArea;

public class G_Emperor_show extends JFrame {

	private static final String window = null;
	private JPanel contentPane;
	private JTextField textField_xingming;
	private JTextField textField_zaiweishijian;
	private JTextField textField_miaohao;
	private JTextField textField_nianhao;
	private JTextField textField_minzu;
	private JTextField textField_chushengdi;
	private JTextField textField_shihao;
	private JTextField textField_jianjie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					G_Emperor_show frame = new G_Emperor_show();
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
	public G_Emperor_show() {
		Emperor emperor1 = new Emperor();
		
		setTitle("\u7687\u5E1D\u8BE6\u60C5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 523);
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
		setSize(450, 533);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(29, 19, 72, 18);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u5728\u4F4D\u65F6\u95F4");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(207, 19, 83, 18);
		contentPane.add(lblNewLabel);
			
		
		JLabel label_1 = new JLabel("\u5E99\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(29, 75, 40, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(244, 75, 37, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6C11\u65CF");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(29, 122, 40, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u751F\u5730");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(219, 122, 54, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u8C25\u53F7");
		label_5.setFont(new Font("宋体", Font.PLAIN, 18));
		label_5.setBounds(29, 169, 46, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u7B80\u4ECB");
		label_6.setFont(new Font("宋体", Font.PLAIN, 18));
		label_6.setBounds(29, 210, 40, 18);
		contentPane.add(label_6);
		
		
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteButAction();//删除
			}
		});
		button_1.setBounds(149, 437, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new G_Emperor_search().setVisible(true);
			}
		});
		button_2.setBounds(288, 437, 113, 27);
		contentPane.add(button_2);
		
		textField_xingming = new JTextField();
		textField_xingming.setBounds(78, 18, 96, 24);
		contentPane.add(textField_xingming);
		textField_xingming.setColumns(10);
		textField_xingming.setText(emperor1.getExingming()); //姓名
		
		textField_zaiweishijian = new JTextField();
		textField_zaiweishijian.setBounds(295, 18, 96, 24);
		contentPane.add(textField_zaiweishijian);
		textField_zaiweishijian.setColumns(10);
		textField_zaiweishijian.setText(emperor1.getEzaiweishijian()); //姓名
		
		textField_miaohao = new JTextField();
		textField_miaohao.setBounds(78, 74, 96, 24);
		contentPane.add(textField_miaohao);
		textField_miaohao.setColumns(10);
		textField_miaohao.setText(emperor1.getEmiaohao());
		
		textField_nianhao = new JTextField();
		textField_nianhao.setBounds(295, 74, 96, 24);
		contentPane.add(textField_nianhao);
		textField_nianhao.setColumns(10);
		textField_nianhao.setText(emperor1.getEnianhao());
		
		textField_minzu = new JTextField();
		textField_minzu.setBounds(78, 121, 96, 24);
		contentPane.add(textField_minzu);
		textField_minzu.setColumns(10);
		textField_minzu.setText(emperor1.getEminzu());
		
		textField_chushengdi = new JTextField();
		textField_chushengdi.setBounds(295, 121, 96, 24);
		contentPane.add(textField_chushengdi);
		textField_chushengdi.setColumns(10);
		textField_chushengdi.setText(emperor1.getEchushengdi());
		
		textField_shihao = new JTextField();
		textField_shihao.setBounds(78, 168, 313, 24);
		contentPane.add(textField_shihao);
		textField_shihao.setColumns(10);
		textField_shihao.setText(emperor1.getEshihao());
		
		JTextArea textArea_jianjie = new JTextArea();
		textArea_jianjie.setLineWrap(true);
		textArea_jianjie.setBounds(39, 253, 362, 153);
		contentPane.add(textArea_jianjie);
		textArea_jianjie.setText(emperor1.getEjianjie());
//		textField_jianjie = new JTextField();
//		textField_jianjie.setBounds(67, 244, 313, 169);
//		contentPane.add(textField_jianjie);
//		textField_jianjie.setColumns(10);
//		textField_jianjie.setText(emperor1.getEjianjie());		
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Butchange(textArea_jianjie);//修改
			}
		});
		button.setBounds(22, 437, 113, 27);
		contentPane.add(button);
	}

    /*
         * 添加背景
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\emperorShow.jpg"); //添加图片
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}


	/*
	 * 修改
	 */
	protected void Butchange(JTextArea textArea_jianjie) {
		String id = Emperor.getEid(); //获得id
		String xingming = this.textField_xingming.getText();
		String zaiweishijian = this.textField_zaiweishijian.getText();
		String miaohao = this.textField_miaohao.getText();
		String nianhao = this.textField_nianhao.getText();
		String minzu = this.textField_minzu.getText();
		String chushengdi = this.textField_chushengdi.getText();
		String shihao = this.textField_shihao.getText();
		String jianjie = textArea_jianjie.getText();
		
		if(StringUtil.isEmpty(xingming)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		else if(StringUtil.isEmpty(nianhao)) {
			JOptionPane.showMessageDialog(null, "年号不能为空");
			return;
		}
		Emperor emperor = new Emperor(xingming,zaiweishijian,miaohao,nianhao,minzu,chushengdi,shihao,jianjie);
		emperor.setEid(id);
		
		Connection con = null;
		try {
			con = DbUtil.getCon();
			int ChangeResult = EmperorDao.ChangeEmperor(con, emperor);
			if(ChangeResult == 1) {
				JOptionPane.showMessageDialog(null,"修改成功");
			}else {
				JOptionPane.showMessageDialog(null,"修改失败，请稍后再试");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 删除
	 */
    protected void DeleteButAction(){
		String id =Emperor.getEid();
		//System.err.println(id);
		Connection con = null;
		try {
			con = DbUtil.getCon();
			int DeleteResult = EmperorDao.DeleteEmperor(con, id);
			if(DeleteResult == 1) {
				JOptionPane.showMessageDialog(null,"删除成功");
				dispose();
				new Home().setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null,"删除失败，请稍后再试");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
