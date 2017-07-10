package com.dgit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class ControllerUsingURI extends HttpServlet {
	
	private HashMap<String, CommandHandler> commandHandlerMap= new HashMap<String,CommandHandler>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	public void init() throws ServletException {
		String confgFile= getInitParameter("configFile");
		Properties prop= new Properties();
		String configFilePath= getServletContext().getRealPath(confgFile);
		try(FileReader fis= new FileReader(configFilePath)){
			prop.load(fis);
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
		Iterator<Object> keyIter= prop.keySet().iterator(); 
		while(keyIter.hasNext()){
			String command = (String) keyIter.next();
			String handlerClassName= prop.getProperty(command);
			
			try {
				Class<?> handlerClass= Class.forName(handlerClassName);
				CommandHandler handlerInstance= (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath())==0){
			command= command.substring(req.getContextPath().length());
		}
		CommandHandler halder= commandHandlerMap.get(command);
		if(halder==null){
			halder= new NullHandler();
		}
		String viewPage= null;
		
		try {
			viewPage= halder.process(req, resp);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		if(viewPage!=null){
			RequestDispatcher dispatcher= req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}
	}
	
	
	

}
