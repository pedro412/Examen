<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


<title>Gestor de Usuarios</title>

<link type="text/css" rel="stylesheet" href="css/style.css">
</head>


<body>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.html" >
        <img alt="Brand" src="logo1.png" height="30" width="40">
      </a>
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.html">Home <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="add-user-form.jsp">Nuevo Usuario <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="UsersControllerServlet">Borrar Usuario <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="UsersControllerServlet">Ver Usuarios <span class="sr-only">(current)</span></a></li>
       
        
      </ul>
    </div>
  </div>
</nav>



	<div id ="warapper">
		<div id="header">
			<h2>Gestor de Usuarios</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<!-- input button -->
		<input type="button" value="Nuevo Usuario"
				onclick="window.location.href='add-user-form.jsp'; return false;"
				class="add-user-button"
			 />
		
		<table>
		
			<tr>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<th>Edad</th>
				<th>Ingreso Mensual</th>
				<th>Email</th>
				<th>Actualizar/Borrar</th>
			</tr>
			
			<c:forEach var="tempUser" items="${USER_LIST}">
			
			<!-- hacer un link para cada estudiante -->
			<c:url var="tempLink" value="UsersControllerServlet">
				<c:param name="command" value="LOAD" />
				<c:param name="userId" value="${tempUser.id}" />
				
			</c:url>
			
				<c:url var="deleteLink" value="UsersControllerServlet">
				<c:param name="command" value="DELETE" />
				<c:param name="userId" value="${tempUser.id}" />
				
			</c:url>
			
				<tr>
					<td> ${tempUser.nombre} </td>
					<td> ${tempUser.paternoApellido} </td>
					<td> ${tempUser.maternoApellido} </td>
					<td> ${tempUser.edad} </td>
					<td> ${tempUser.ingresoMensual} </td>
					<td> ${tempUser.email} </td>
					<td> 
							<a href="${tempLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Seguro que quiere eliminar este Usuario?'))) return false">
							Borrar</a>
					</td>
				
			
			</c:forEach>
			
		</table>
		
		</div>
	</div>

</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</html>