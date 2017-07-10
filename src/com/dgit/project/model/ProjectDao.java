package com.dgit.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dgit.jdbc.JdbcUtil;

public class ProjectDao {
	public static final ProjectDao instence= new ProjectDao();

	private ProjectDao() {
	}

	public static ProjectDao getInstence() {
		return instence;
	}
	
	public List<Project> selectList(Connection connection){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String qurey="SELECT * FROM project";
		
		try {
			pstmt= connection.prepareStatement(qurey);
			rs=pstmt.executeQuery();
			List<Project> list = new ArrayList<>();
			while(rs.next()){
				Project prj= new Project();
				prj.setpNo(rs.getInt("pjt_no"));
				prj.setpName(rs.getString("pjt_name"));
				prj.setpContent(rs.getString("pjt_content"));
				prj.setStartDay(rs.getTimestamp("start_day"));
				prj.setEndDay(rs.getTimestamp("end_day"));
				prj.setProgress(rs.getString("pjt_Progress"));
				list.add(prj);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
	
	public int insert(Connection connection,Project project){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Statement stmt= null;
		
		String query="INSERT INTO project ( pjt_name, pjt_content, start_day, end_day, pjt_Progress) VALUES( ?, ? ,? , ?, ?)";
	
		try {
			pstmt= connection.prepareStatement(query);
			pstmt.setString(1, project.getpName());
			pstmt.setString(2, project.getpContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStartDay().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEndDay().getTime()));
			pstmt.setString(5, project.getProgress());
			int insertedCount=pstmt.executeUpdate();
			
			if(insertedCount >0){
				//select last_insert_id() 제일마지막에 추가된 오토인크리먼트의 컬럼값을 반환한다
				String query2= "select last_insert_id() from project";

				stmt= connection.createStatement();
				rs= stmt.executeQuery(query2);
				if(rs.next()){
					int newNo=rs.getInt(1);
					return newNo;
				}
			}
			
			return insertedCount;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
		return -1;
		
	}
	
	public Project selectByNo(Connection connection,int no){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String qurey="SELECT * FROM project where pjt_no=?";
		
		try {
			pstmt= connection.prepareStatement(qurey);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			Project prj = new Project();
			if(rs.next()){
				prj.setpNo(rs.getInt("pjt_no"));
				prj.setpName(rs.getString("pjt_name"));
				prj.setpContent(rs.getString("pjt_content"));
				prj.setStartDay(rs.getTimestamp("start_day"));
				prj.setEndDay(rs.getTimestamp("end_day"));
				prj.setProgress(rs.getString("pjt_Progress"));
			}
			return prj;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
	
	public int update(Connection conn, Project project) throws SQLException{
		PreparedStatement pstmt = null;

		String query ="UPDATE project SET pjt_name=?, pjt_content=?, start_day=?, end_day=?, pjt_Progress=? WHERE pjt_no=?";

		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, project.getpName());
			pstmt.setString(2,project.getpContent());
			pstmt.setTimestamp(3,new Timestamp(project.getStartDay().getTime()));
			pstmt.setTimestamp(4,new Timestamp(project.getEndDay().getTime()));
			pstmt.setString(5, project.getProgress());
			pstmt.setInt(6, project.getpNo());
			return pstmt.executeUpdate();
		}catch (SQLException e) {
				e.printStackTrace();}
		finally{
			JdbcUtil.close(pstmt);
		}
		return -1;
	}
	
	public int delete(Connection connection,int no)  throws SQLException{
		PreparedStatement pstmt = null;
		
		String query ="DELETE FROM  jsp_project.project WHERE pjt_no=?";
		try {
			pstmt=connection.prepareStatement(query);
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
		}
		return -1;
	}
}
