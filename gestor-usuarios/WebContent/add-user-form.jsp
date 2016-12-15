<!DOCTYPE html>
<html>
<head>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<title>Nuevo Usuario</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
	
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







	<div id="wrapper">
		<div id="header">
			<h2>Gestor de Usuarios</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Agregar Nuevo usuario</h3>
		
		<form action="UsersControllerServlet" method="POST">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre"/></td>
					</tr>
					
						<tr>
						<td><label>Apellido paterno:</label></td>
						<td><input type="text" name="paternoApellido"/></td>
					</tr>
					
					<tr>
						<td><label>Apellido materno:</label></td>
						<td><input type="text" name="maternoApellido"/></td>
					</tr>
					
					
					<tr>
						<td><label>Edad:</label></td>
						<td><input type="text" name="edad"/></td>
					</tr>
					
					<tr>
						<td><label>Ingreso Mensual:</label></td>
						<td><input type="text" name="ingresoMensual"/></td>
					</tr>
					
						<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"/></td>
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
			<a href="UsersControllerServlet">Ver Usuarios</a>
		
	</div>



</body>
</html>