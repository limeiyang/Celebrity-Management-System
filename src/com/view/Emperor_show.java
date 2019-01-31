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
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

import com.model.Emperor;
import com.dao.EmperorDao;

public class Emperor_show extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emperor_show frame = new Emperor_show();
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
	public Emperor_show() {
		Emperor emperor1 = new Emperor();
		
		setTitle("\u7687\u5E1D\u8BE6\u60C5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 495);
		
		setBak(); //���ñ�������
		Container c = getContentPane(); //��ȡJFrame���
	    JPanel contentPane = new JPanel(); //������JPanel
		contentPane.setOpaque(false); //��JPanel����Ϊ͸�� �����Ͳ�����ס����ı��� �����������JPanel����������
		c.add(contentPane);
		contentPane.setLayout(null);
		setSize(450, 532);
		setTitle("\u6E05\u671D\u540D\u4EBA\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		
		
		JTextPane textPane_xingming = new JTextPane();
		textPane_xingming.setBounds(78, 19, 96, 24);
		contentPane.add(textPane_xingming);
		textPane_xingming.setText(emperor1.getExingming());//����
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("����", Font.PLAIN, 18));
		label.setBounds(29, 19, 72, 18);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u5728\u4F4D\u65F6\u95F4");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(207, 19, 83, 18);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane_zaiweishijian = new JTextPane();
		textPane_zaiweishijian.setBounds(295, 19, 96, 24);
		contentPane.add(textPane_zaiweishijian);
		textPane_zaiweishijian.setText(emperor1.getEzaiweishijian());//��λʱ��
		
		JLabel label_1 = new JLabel("\u5E99\u53F7");
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		label_1.setBounds(29, 75, 40, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u53F7");
		label_2.setFont(new Font("����", Font.PLAIN, 18));
		label_2.setBounds(244, 75, 37, 18);
		contentPane.add(label_2);
		
		JTextPane textPane_miaohao = new JTextPane();
		textPane_miaohao.setBounds(78, 69, 96, 24);
		contentPane.add(textPane_miaohao);
		textPane_miaohao.setText(emperor1.getEmiaohao());//���
		
		JTextPane textPane_nianhao = new JTextPane();
		textPane_nianhao.setBounds(295, 69, 96, 24);
		contentPane.add(textPane_nianhao);
		textPane_nianhao.setText(emperor1.getEnianhao());//���
		
		JLabel label_3 = new JLabel("\u6C11\u65CF");
		label_3.setFont(new Font("����", Font.PLAIN, 18));
		label_3.setBounds(29, 122, 40, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u51FA\u751F\u5730");
		label_4.setFont(new Font("����", Font.PLAIN, 18));
		label_4.setBounds(219, 122, 54, 18);
		contentPane.add(label_4);
		
		JTextPane textPane_minzu = new JTextPane();
		textPane_minzu.setBounds(78, 122, 96, 24);
		contentPane.add(textPane_minzu);
		textPane_minzu.setText(emperor1.getEminzu());//����
		
		
		JTextPane textPane_chushengdi = new JTextPane();
		textPane_chushengdi.setBounds(295, 122, 96, 24);
		contentPane.add(textPane_chushengdi);
		textPane_chushengdi.setText(emperor1.getEchushengdi());//�����
		
		JLabel label_5 = new JLabel("\u8C25\u53F7");
		label_5.setFont(new Font("����", Font.PLAIN, 18));
		label_5.setBounds(29, 169, 46, 18);
		contentPane.add(label_5);
		
		JTextPane textPane_shihao = new JTextPane();
		textPane_shihao.setBounds(78, 163, 313, 42);
		contentPane.add(textPane_shihao);
		textPane_shihao.setText(emperor1.getEshihao());//�ֺ�
		
		JLabel label_6 = new JLabel("\u7B80\u4ECB");
		label_6.setFont(new Font("����", Font.PLAIN, 18));
		label_6.setBounds(29, 210, 40, 18);
		contentPane.add(label_6);
		
		JTextPane txtpn_jianjie = new JTextPane();
		txtpn_jianjie.setBounds(29, 234, 362, 202);
		contentPane.add(txtpn_jianjie);
		txtpn_jianjie.setText(emperor1.getEjianjie());//�ֺ�
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
			}
		});
		button.setBounds(336, 449, 72, 27);
		contentPane.add(button);
	}

    /*
         * ��ӱ���
     */
	public void setBak(){
	    ((JPanel)this.getContentPane()).setOpaque(false);
	    ImageIcon img = new ImageIcon("src\\pic\\bg\\emperorShow.jpg"); //���ͼƬ
	    JLabel background = new JLabel(img);
	    this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	    background.setBounds(0,0, img.getIconWidth(), img.getIconHeight()); 
	}
}
