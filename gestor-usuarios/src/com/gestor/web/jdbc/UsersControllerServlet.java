package com.gestor.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UsersControllerServlet
 */
@WebServlet("/UsersControllerServlet")
public class UsersControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDbUtil userDbUtil;
	
	@Resource(name="jdbc/examen")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create out student db util ... and pass it to the conn pool / dataSource
		try {
			userDbUtil = new UserDbUtil(dataSource);
			
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			//leer command paramter
			String theCommand = request.getParameter("command");
			
			// mandarlo a un metodo
			
			if (theCommand == null){
				theCommand = "LIST";
			}
			
			switch (theCommand){
			case "LIST":
				listUsers(request, response);
				
				case "LOAD":
				loadUser(request, response);
				break;
				
			case "UPDATE":
				updateUser(request, response);
				break;
				
			case "DELETE":
				deleteUser(request, response);
				
			default:
				listUsers(request, response);
			}
			
			
			
		//list the students in mvc fashion
			listUsers(request, response);
		}
		catch (Exception exc){
			throw new ServletException(exc);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
					
			// route to the appropriate method
			switch (theCommand) {
							
			case "ADD":
				addUser(request, response);
				break;
								
			default:
				listUsers(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student id from data
		String theUserId = request.getParameter("userId");
		
		// delete student from database
		userDbUtil.deleteUser(theUserId);
		
		// send them back to "list students" page
		listUsers(request, response);
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// leer la info de estudiante del form
		int id = Integer.parseInt(request.getParameter("userId"));
		String nombre = request.getParameter("nombre");
		String paternoApellido = request.getParameter("paternoApellido");
		String maternoApellido = request.getParameter("maternoApellido");
		String edad = request.getParameter("edad");
		String ingresoMensual = request.getParameter("ingresoMensual");
		String email = request.getParameter("email");
		
		// crear un nuevo objeto estudiante 
		User theUser = new User(id, nombre, paternoApellido, maternoApellido, edad, ingresoMensual, email);
		
		// hacer la actualizacion de base de datos
		userDbUtil.updateUser(theUser);
		
		// enviarlos a la lista estudiantes 
		listUsers(request, response);
		
	}


	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// leer el id de estudiantes form
		String theUserId = request.getParameter("userId");
		
		
		User theUser = userDbUtil.getUser(theUserId);
		
	
		request.setAttribute("THE_USER", theUser);
		
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-user-form.jsp");
		dispatcher.forward(request, response);
				
	}


	private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//read student info from form
		String nombre = request.getParameter("nombre");
		String paternoApellido = request.getParameter("paternoApellido");
		String maternoApellido = request.getParameter("maternoApellido");
		String edad = request.getParameter("edad");
		String ingresoMensual = request.getParameter("ingresoMensual");
		String email = request.getParameter("email");
		
		//create a new student object
		User theUser = new User(nombre, paternoApellido, maternoApellido, edad, ingresoMensual, email);
		
		//add the student to the database 
		userDbUtil.addUser(theUser);
		
	    //send back to main page
		 response.sendRedirect(request.getContextPath() + "/UsersControllerServlet?command=LIST");
	}


	private void listUsers(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		
		//get students from db util
		List<User> usuarios = userDbUtil.getUsers();
		//add students to the resquest
		request.setAttribute("USER_LIST", usuarios);
		//send to jsp page(view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-users.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
