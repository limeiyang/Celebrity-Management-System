package com.dao;

import com.model.User;


import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {
	//�û���¼��֤
	public static User login(Connection con, User user) throws Exception{
		System.out.println("��¼loginִ��");
		User returnUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			returnUser = new User(rs.getInt("id"),rs.getString("username"),
					rs.getString("password"));
		}
		return returnUser;
	}
	

	//����û�
	public static int register(Connection con, User user) throws Exception{
		
		String sql = "insert into t_user(userName,password) values (?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
	
		return pstmt.executeUpdate();
	}
}