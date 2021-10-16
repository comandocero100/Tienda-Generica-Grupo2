<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="css/estiloOpciones.css">

</head>
<body>

<%!String cedula = "", email = "", nombre = "", clave = "", usuario = "",  estado = "";%>

<%
if (request.getParameter("cedula_usuario") != null) {
	cedula = request.getParameter("cedula_usuario");
	email = request.getParameter("email_usuario");
	nombre = request.getParameter("nombre_usuario");		
	clave = request.getParameter("password_usuario");
	usuario = request.getParameter("usuario");
	if(cedula == "") {
	estado = "enabled";
	}
	else{
	estado = "disabled";
	}
}
%>

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
			<li><a href="index.jsp">Cerrar sesión</a></li>
		</ul>
	</nav>
</header>

<div class="contendor-fluid">

	<form action="Usuarios" method="post">
		<div class="titulo-usuario">
			<h3>Usuario: </h3>
		</div>
		<div class="contenedorIN">
			<div>
				<label for="">Cédula</label> 
				<label for="">Nombre Completo</label>
				<label for="">Correo Electrónico</label>
			</div>
			<div>
				<input type="text" name="cedula" value="<%=cedula%>" <%=estado%> required placeholder="ingrese documento">
				<input type="hidden" name="ced" value="<%=cedula%>" placeholder="ingrese documento"> 
				<input type="text" name="nombre" value="<%=nombre%>" placeholder="ingrese nombre completo"> 
				<input type="email" name="email" value="<%=email%>" placeholder="ingrese email">
			</div>
			<div>
				<label for="">Usuario</label> 
				<label for="">Contraseña</label>
			</div>
			<div>
				<input type="text" name="usuario" value="<%=usuario%>" placeholder="ingrese un nombre usuario"> 
				<input type="password" name="clave" value="<%=clave%>" placeholder="ingrese contraseña usuario">
			</div>
		</div>
		<div class="contenedorBotones">
			<input type="submit" name="consultar" value="Consultar">
			<input type="submit" name="insertar" value="Insertar"> 
			<input type="submit" name="actualizar" value="Actualizar"> 
			<input	type="submit" name="eliminar" value="Borrar">
			<input type="submit" name="limpiar" value="Limpiar">			
		</div>
	</form>
</div>
<footer >

</footer>


<%
if (request.getParameter("men") != null) {
	String mensaje = request.getParameter("men");
	out.print("<script>alert('" + mensaje + "');</script>");
}
%>

    

</body>
</html>