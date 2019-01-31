package com.util;


import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * ���ݿ⹤����
 * @author H_Pioneer
 *
 */

public class DbUtil {
	
//private String dbUrl = "jdbc:mysql:///db_book";
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_mr?characterEncoding=UTF-8";
	private static String dbUserName = "root";
	private static String dbPassword = "123456";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon()throws Exception{
		//System.out.println("���ݿ�����getComִ��");
	    Class.forName(jdbcName);
		Connection con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�
		//System.out.println("���ݿ�����getComִ��------");
		return con;
		
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon (java.sql.Connection con)throws Exception {
		if(con!=null){
			con.close();
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			com.util.DbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    //�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
			System.out.println("���ݿ�����");
		}
				
	}

	
}
