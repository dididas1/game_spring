package com.dgit.jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;



public class DBCPInit extends HttpServlet{
	 
	@Override
	public void init() throws ServletException {
		    loadJDBCDriver();
		    initConnectionPool();
	}

	public void loadJDBCDriver() {
		   String jdbcDriver=getInitParameter("jdbcdriver");
		      try {
		         Class.forName(jdbcDriver);
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      }
		   }
	
	 private void initConnectionPool() {
		 
		 try{
			/* String jdbcDriver = "jdbc:mysql://localhost:3306/guestbook?"
			            +"useUnicode=true&characterEncoding=utf8";*/
			 	
			      String jdbcUrl= getInitParameter("jdbcUrl");
			      String user =getInitParameter("dbUser");
			      String pass = getInitParameter("dbPassword");
			      ConnectionFactory conFactoy= new DriverManagerConnectionFactory(jdbcUrl ,user,pass);
			      
			      PoolableConnectionFactory poolableConnFactoy= new PoolableConnectionFactory(conFactoy, null);
			      poolableConnFactoy.setValidationQuery("select 1");
			      GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			      
			      poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			      
			      poolConfig.setTestWhileIdle(true);
			      poolConfig.setMinIdle(4);
			      poolConfig.setMaxTotal(50);
			      
			      GenericObjectPool<PoolableConnection> connectionPool= new GenericObjectPool<>(poolableConnFactoy,poolConfig);
			      poolableConnFactoy.setPool(connectionPool);
			      Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			      
			      PoolingDriver driver= (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			      //커넥션 풀의 이름:jdbc:apache:commons:dbcp:chap14
			      String poolName= getInitParameter("poolName");
			      driver.registerPool(poolName, connectionPool);
		 }catch (Exception e) {
			  e.printStackTrace();
		}
		 

	 }
}
