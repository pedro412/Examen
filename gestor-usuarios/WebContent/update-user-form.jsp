<!DOCTYPE html>
<html>
<head>

	<title>Actualizar Usuario</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Gestor de Usuarios</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar Usuarios</h3>
		
		<form action="UsersControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE"/>
			<input type="hidden" name="userId" value="${THE_USER.id}" />
						
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="nombre"
								   value="${THE_USER.nombre}"/></td>
					</tr>
					
						<tr>
						<td><label>Apellido Paterno:</label></td>
						<td><input type="text" name="paternoApellido"
						            value="${THE_USER.paternoApellido}"/></td>
					</tr>
					
								<tr>
						<td><label>Apellido materno:</label></td>
						<td><input type="text" name="maternoApellido"
						           value="${THE_USER.maternoApellido}"/></td>
					</tr>
					
								<tr>
						<td><label>Edad:</label></td>
						<td><input type="text" name="edad"
						           value="${THE_USER.edad}"/></td>
					</tr>
					
								<tr>
						<td><label>Ingreso mensual:</label></td>
						<td><input type="text" name="ingresoMensual"
						           value="${THE_USER.ingresoMensual}"/></td>
					</tr>
					
						<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"
						           value="${THE_USER.email}"/></td>
					</tr>
						
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
						
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		<p>
			<a href="UsersControllerServlet">Regresar</a>
		
	</div>



</body>
</html>