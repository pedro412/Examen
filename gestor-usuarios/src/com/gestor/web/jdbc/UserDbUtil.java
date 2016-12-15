package com.gestor.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDbUtil {
	
	private DataSource dataSource;
	
	public UserDbUtil(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public List<User> getUsers() throws Exception {
		
		List<User> usuarios = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try{
		//getConnection
		myConn = dataSource.getConnection();
		
		//createsqlStmt
		String sql = "select * from infosyst order by apellido_paterno";
		myStmt = myConn.createStatement();
		
		//executequery
		myRs = myStmt.executeQuery(sql);
		
		//procces result set
		
		while (myRs.next()){
			//retrieve data from a result set row
			int id = myRs.getInt("id");
			String nombre = myRs.getString("name");
			String paternoApellido = myRs.getString("apellido_paterno");
			String maternoApellido = myRs.getString("apellido_materno");
			String edad = myRs.getString("edad");
			String ingresoMensual = myRs.getString("ingreso_mensual");
			String email = myRs.getString("email");
			
			//create a new student obj
			User tempUser = new User(id, nombre, paternoApellido, maternoApellido, edad, ingresoMensual, email);
			
			
			//add list to the list of students
			usuarios.add(tempUser);
		}
		
		return usuarios;
		
		}
		finally {
			//close jdbc objs
			close(myConn, myStmt, myRs);
		}
		

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
	
		try{
		   if (myRs != null){
			   myRs.close();
		   }	
		   if (myStmt != null){
			   myStmt.close();
		   }	
		   if (myConn != null){
			   myConn.close();
		   }	
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

	public void addUser(User theUser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try{
			//get db connection
			myConn = dataSource.getConnection();
			
		//crear sql para insertar
			String sql = "insert into infosyst "
					+"(name, apellido_paterno, apellido_materno, edad, ingreso_mensual, email)"
					+"values(?, ?, ?, ?, ?, ?)";
		
			myStmt = myConn.prepareStatement(sql);
			
		// los parametros para el sql
			myStmt.setString(1, theUser.getNombre());
			myStmt.setString(2, theUser.getPaternoApellido());
			myStmt.setString(3, theUser.getMaternoApellido());
			myStmt.setString(4, theUser.getEdad());
			myStmt.setString(5, theUser.getIngresoMensual());
			myStmt.setString(6, theUser.getEmail());
			
		// ejecutar los sqls
			myStmt.execute();
			
		}
		finally{
		//limpias los jdbc objects
			close(myConn, myStmt, null);
		}
	}

	public User getUser(String theUserId) throws Exception {
	
		User theUser = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int userId;
		
		try {
			// convertir id estudiante a int
			userId = Integer.parseInt(theUserId);
			
			// obtener la conexion a la base de datos 
			myConn = dataSource.getConnection();
			
			// crear el sql para obtener el estudiante seleccionado
			String sql = "select * from infosyst where id=?";
			
			// crear el PreparedStatement
			myStmt = myConn.prepareStatement(sql);
			
			// establecer los parametros
			myStmt.setInt(1, userId);
			
			// ejecutar los statements
			myRs = myStmt.executeQuery();
			
			// recuperar los datos del resul set row
			if (myRs.next()) {
				String nombre = myRs.getString("name");
				String paternoApellido = myRs.getString("apellido_paterno");
				String maternoApellido = myRs.getString("apellido_materno");
				String edad = myRs.getString("edad");
				String ingresoMensual = myRs.getString("apellido_paterno");
				String email = myRs.getString("email");
				
				theUser = new User(userId, nombre, paternoApellido, maternoApellido, edad, ingresoMensual, email);
			}
			else {
				throw new Exception("Could not find Usuario id: "+userId);
			}
			
				
		return theUser;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		
	}

	public void updateUser(User theUser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		// get db connection
			myConn = dataSource.getConnection();
		
		// create sql update statement 
			String sql = "update infosyst "
				+ "set name=?, apellido_paterno=?, apellido_materno=?, edad=?, ingreso_mensual=?, email=? "
				+ "where id=?";
				
		// prepare statement
			myStmt = myConn.prepareStatement(sql);
		
		// set params
			myStmt.setString(1, theUser.getNombre());
			myStmt.setString(2, theUser.getPaternoApellido());
			myStmt.setString(3, theUser.getMaternoApellido());
			myStmt.setString(4, theUser.getEdad());
			myStmt.setString(5, theUser.getIngresoMensual());
			myStmt.setString(6, theUser.getEmail());
			myStmt.setInt(7, theUser.getId());
		
		// execute query
			myStmt.execute();
	}
		finally {
		//clean up jdbc objs
		close(myConn, myStmt, null);
	}
		
	}

	public void deleteUser(String theUserId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert to student id to int 
			int userId = Integer.parseInt(theUserId);
			
			// get connection to database 
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from infosyst where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params	
			myStmt.setInt(1, userId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			//clean up jdbc code
			close(myConn, myStmt, null);
		}
	}

}
