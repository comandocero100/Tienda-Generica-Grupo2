<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.0/css/mdb.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/estiloOpciones.css">


</head>
<body>

	<div class="titulo">
		<h1>Tienda Genérica</h1>
	</div>
	<header>
		<nav>
			<ul>
				<li><a href="Usuarios.jsp">Usuarios</a></li>
				<li><a href="clientes.jsp">Clientes</a></li>
				<li><a href="Proveedores.jsp">Proveedores</a></li>
				<li><a href="Productos.jsp">Productos</a></li>
				<li><a href="Ventas.jsp">Ventas</a></li>
				<li><a href="Reportes.jsp">Reportes</a></li>
				<li><a href="index.jsp">Cerrar sesion</a></li>
			</ul>
		</nav>
	</header>

	<div class="contendor-fluid">
		<form action="Productos" method="post" enctype="multipart/form-data">
			<div class="titulo">
				<h3>Productos</h3>
			</div>
		</form>
	</div>
	<div class="row justify-content-center mt-5">
		<input id='file-input' type="file" class="btn btn-primary" value="x">
		<label for='file-input' class='btn btn-primary'>Selecciona un
			archivo</label>
		<!-- Agregamos el label con su estilo -->
	</div>

	<div class="contenedorBotones">
		<div>
			<input type="submit" value="Cargar" name="cargar">
		</div>
	</div>
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.0/js/mdb.min.js"></script>
      <script src="src/scripts/main.js"></script>
    <%
	if (request.getParameter("men") != null) {
		String mensaje = request.getParameter("men");
		out.print("<script>alert('" + mensaje + "');</script>");
	}
	%>
</body>
</html>