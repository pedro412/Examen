package com.gestor.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import java.sql.Connection;
import java.sql.Statement;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/examen")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//borrar
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from infosyst";
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()){
				String name = myRs.getString("edad");
				out.println(name);
				
			}
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}

}
