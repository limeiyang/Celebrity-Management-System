package com.util;


import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

/**
 * 数据库工具类
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
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon()throws Exception{
		//System.out.println("数据库连接getCom执行");
	    Class.forName(jdbcName);
		Connection con = (Connection) DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//链接数据库
		//System.out.println("数据库连接getCom执行------");
		return con;
		
	}
	
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    //在命令行打印异常信息在程序中出错的位置及原因。
			System.out.println("数据库连接");
		}
				
	}

	
}
