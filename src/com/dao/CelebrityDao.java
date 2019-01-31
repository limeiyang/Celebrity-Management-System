package com.dao;

import java.sql.ResultSet;

import com.model.Celebrity;
import com.model.Emperor;
import com.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/*
 * 查询名人
 */
public class CelebrityDao {
	public static Celebrity FindEByAll(Connection con, String p)throws Exception{
		Celebrity celebrity1 = new Celebrity();//新建emperor对象
		
		String sql = "select * from t_people where id = ? or name = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		 pstmt.setString(1,p);
		 pstmt.setString(2,p);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			  {  
				celebrity1=new Celebrity();
				celebrity1.setCid(rs.getString("id"));
				celebrity1.setCxingming(rs.getString("name"));
				celebrity1.setCnianhao(rs.getString("time"));
				celebrity1.setCminzu(rs.getString("national"));
				celebrity1.setCguanzhi(rs.getString("work"));
				celebrity1.setCchushengdi(rs.getString("place"));
				celebrity1.setCchengjiu(rs.getString("message"));
			  }
			return celebrity1;
	}
	
	/*
	 * 添加名人
	 */
	public static int AddCelcbrity(Connection con, Celebrity celebrity2) throws Exception{

		String sql = "insert into t_people(name,national,place,time,work,message) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, celebrity2.getCxingming());
		pstmt.setString(2, celebrity2.getCminzu());
		pstmt.setString(3, celebrity2.getCchushengdi());
		pstmt.setString(4, celebrity2.getCnianhao());
		pstmt.setString(5, celebrity2.getCguanzhi());
		pstmt.setString(6, celebrity2.getCchengjiu());
	
		return pstmt.executeUpdate();
	}
	/*
	 * 修改
	 */
	public static int ChangeCelebrity(Connection con, Celebrity celebrity) throws Exception{
		
		String sql = "update t_people set name = ?,national = ?,place = ?,time = ?,work = ?,message = ? where id = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, celebrity.getCxingming());
		pstmt.setString(2, celebrity.getCminzu());
		pstmt.setString(3, celebrity.getCchushengdi());
		pstmt.setString(4, celebrity.getCnianhao());
		pstmt.setString(5, celebrity.getCguanzhi());
		pstmt.setString(6, celebrity.getCchengjiu());
		pstmt.setString(7, celebrity.getCid());
		
		return pstmt.executeUpdate();
	}
	/*
	 * 删除
	 */
	public static int DeleteCelebrity(Connection con, String id) throws Exception{
		String sql = "delete from t_people where id = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	

}
