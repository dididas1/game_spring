package com.dgit.project.handler;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.jdbc.JdbcUtil;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class InsertProjectHandler implements CommandHandler{
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/projectinput.jsp";
		}if(req.getMethod().equalsIgnoreCase("post")){
			Connection connection =ConnectionProvider.getConnection();
			connection.setAutoCommit(false);
			String name=req.getParameter("name");
			String content=req.getParameter("content");
			String sdate= req.getParameter("startday");
			String edate= req.getParameter("endday");
			String select= req.getParameter("select");
			
			try{
				ProjectDao.getInstence().insert(connection, new Project(name, content, sdf.parse(sdate), sdf.parse(edate), select));
				connection.commit();
				return "projectlist.do";
			}finally{
				JdbcUtil.close(connection);
			}
			
		
			
			
		}
		return null;
	}
}
