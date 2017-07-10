package com.dgit.project.handler;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class UpdateProjectHandler implements CommandHandler{
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection connection= ConnectionProvider.getConnection();
		if(req.getMethod().equalsIgnoreCase("get")){
			String no = req.getParameter("no");
			Project project=ProjectDao.getInstence().selectByNo(connection, Integer.parseInt(no));
			
			req.setAttribute("project", project);
			return "/WEB-INF/view/projectUpdateForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String no=req.getParameter("no");
			String name=req.getParameter("name");
			String content=req.getParameter("content");
			String sdate= req.getParameter("startday");
			String edate= req.getParameter("endday");
			String select= req.getParameter("select");
			
			Project project= new Project(Integer.parseInt(no), name, content, sdf.parse(sdate), sdf.parse(edate), select);
			ProjectDao.getInstence().update(connection, project);
			
			return "/read.do?no="+no;
		}
		
		return null;
	}

}
