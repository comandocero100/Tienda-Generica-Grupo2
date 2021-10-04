<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
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
        <div class="contenedorIN">
        	<div><label>Nombre del Archivo </label><input type="file" value="Examinar" name="archivo"></div>                               
        </div>
        <div class="contenedorBotones">              	
        	<div><input type="submit" value="Cargar" name="cargar"></div>           	
        </div>
	</form>
</div>	

<%
if(request.getParameter("men")!=null){
String mensaje=request.getParameter("men");
out.print("<script>alert('"+ mensaje + "');</script>");
}
%>

</body>
</html>