package com.dgit.project.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.project.model.ProjectDao;

public class DeleteProjectHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String no= req.getParameter("no");
		Connection connection= ConnectionProvider.getConnection();
		ProjectDao.getInstence().delete(connection, Integer.parseInt(no));
		return "projectlist.do";
	}

}
