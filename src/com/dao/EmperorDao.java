package com.dao;

import java.sql.ResultSet;

import com.model.Celebrity;
import com.model.Emperor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmperorDao {
	
	/*
	 * 查询皇帝
	 */
	public static Emperor FindEByAll(Connection con, String p)throws Exception{
		Emperor emperor1 = new Emperor();//新建emperor对象
		
		String sql = "select * from t_emperor where id = ? or name = ? or yearname = ? or miaohao = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		 pstmt.setString(1,p);
		 pstmt.setString(2,p);
		 pstmt.setString(3,p);
		 pstmt.setString(4,p);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			  {  
				  emperor1=new Emperor();
				  emperor1.setEid(rs.getString("id"));
				  emperor1.setEjianjie(rs.getString("message"));
				  emperor1.setExingming(rs.getString("name"));
				  emperor1.setEminzu(rs.getString("National"));
				  emperor1.setEzaiweishijian(rs.getString("overtime"));
				  emperor1.setEchushengdi(rs.getString("place"));
				  emperor1.setEmiaohao(rs.getString("miaohao"));
				  emperor1.setEnianhao(rs.getString("yearname"));
				  emperor1.setEshihao(rs.getString("shihao"));
			  }
			return emperor1;
	}
	/*
	 * 添加皇帝
	 */
	public static int AddEmperor(Connection con, Emperor emperor2) throws Exception{

		String sql = "insert into t_emperor(name,national,yearname,place,miaohao,overtime,message,shihao) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, emperor2.getExingming());
		pstmt.setString(2, emperor2.getEminzu());
		pstmt.setString(3, emperor2.getEnianhao());
		pstmt.setString(4, emperor2.getEchushengdi());
		pstmt.setString(5, emperor2.getEmiaohao());
		pstmt.setString(6, emperor2.getEzaiweishijian());
		pstmt.setString(7, emperor2.getEjianjie());
		pstmt.setString(8, emperor2.getEshihao());
	
		return pstmt.executeUpdate();
	}
	
	/*
	 * 修改
	 */
	public static int ChangeEmperor(Connection con, Emperor emperor) throws Exception{
		String sql = "update t_emperor set name = ? ,national = ?,yearname = ?,place = ?,miaohao = ?,overtime = ?,message = ?,shihao = ? where id = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, emperor.getExingming());
		pstmt.setString(2, emperor.getEminzu());
		pstmt.setString(3, emperor.getEnianhao());
		pstmt.setString(4, emperor.getEchushengdi());
		pstmt.setString(5, emperor.getEmiaohao());
		pstmt.setString(6, emperor.getEzaiweishijian());
		pstmt.setString(7, emperor.getEjianjie());
		pstmt.setString(8, emperor.getEshihao());
		pstmt.setString(9,emperor.getEid());
		
		return pstmt.executeUpdate();
	}
	
	/*
	 * 删除
	 */
	public static int DeleteEmperor(Connection con,String id) throws Exception{
		String sql = "delete from t_emperor where id = ?";
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}

}
