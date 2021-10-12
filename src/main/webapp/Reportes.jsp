<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reportes</title>
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
			<li><a href="index.jsp">Cerrar sesión</a></li>
		</ul>
	</nav>
</header>	

<div class="contendor-fluid">
	<form action="Ventas" method="post">
    	<div class="titulo">
			<h3>Reportes</h3>
		</div>        
	</form>
</div>	

<div class="contenedor-report">
	<ul>
			<li><a href="listas/listaUsuarios.jsp">LISTADO USUARIOS</a></li>
			<li><a href="#">LISTADO CLIENTES</a></li>
			<li><a href="#">VENTA POR CLIENTE</a></li>
	</ul>
</div>

<%
if (request.getParameter("men") != null) {
	String mensaje = request.getParameter("men");
	out.print("<script>alert('" + mensaje + "');</script>");
}
%>

</body>
</html>