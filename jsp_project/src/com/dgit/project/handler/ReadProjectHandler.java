package com.dgit.project.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class ReadProjectHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection connection=ConnectionProvider.getConnection();
		String no= req.getParameter("no");
		
		Project project=ProjectDao.getInstence().selectByNo(connection, Integer.parseInt(no));
		
		req.setAttribute("project", project);
		return "/WEB-INF/view/projectread.jsp";
	}

}
