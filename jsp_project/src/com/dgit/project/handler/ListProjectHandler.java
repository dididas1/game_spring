package com.dgit.project.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgit.controller.CommandHandler;
import com.dgit.jdbc.ConnectionProvider;
import com.dgit.project.model.Project;
import com.dgit.project.model.ProjectDao;

public class ListProjectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection connection=ConnectionProvider.getConnection();
		List<Project> list= ProjectDao.getInstence().selectList(connection);
		req.setAttribute("list", list);
		return "/WEB-INF/view/projectlist.jsp";
	}

}
