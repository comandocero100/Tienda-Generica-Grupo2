
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLIENTES PRUEBA</title>
<link rel="stylesheet" href="css/estiloOpciones.css">
</head>
<body>
<%!String cedula = "", nombre = "", direccion = "", telefono = "", email = "", estado = "";%>

<%
if (request.getParameter("cedula") != null) {
	cedula = request.getParameter("cedula");
	direccion = request.getParameter("direccion");
	email = request.getParameter("email");
	nombre = request.getParameter("nombre");		
	telefono = request.getParameter("tel");		
	estado = "disabled";
}
%>	
	
<div class="titulo">
	<h1>Tienda Gen�rica</h1>
</div>
<header class="contenedor-menu">
	<nav>
		<ul>
			<li><a href="Usuarios.jsp">Usuarios</a></li>
			<li><a href="clientes.jsp">Clientes</a></li>
			<li><a href="Proveedores.jsp">Proveedores</a></li>
			<li><a href="Productos.jsp">Productos</a></li>
			<li><a href="Ventas.jsp">Ventas</a></li>
			<li><a href="Reportes.jsp">Reportes</a></li>
			<li><a href="index.jsp">Cerrar sesi�n</a></li>
		</ul>
	</nav>
</header>	
	
<div class="contendor-fluid">
	<form action="Clientes" method="post">
    	<div class="titulo">
			<h3>Clientes</h3>
		</div>
        <div class="contenedorIN">
        	<div>
            	<label for="">C�dula</label>
                <label for="">Nombre Completo</label>
                <label for="">Direcci�n</label>
            </div>
            <div>
                <input type="text" name="cedula" value="<%=cedula%>" <%=estado%>>
                <input type="hidden" name="ced" value="<%=cedula%>">
                <input type="text" name="nombre" value="<%=nombre%>">
            	<input type="text" name="direccion" value="<%=direccion%>">
            </div>
			<div>
			    <label for="">Tel�fono</label>
                <label for="">Correo Electr�nico</label>
            </div>
            <div>
            	<input type="text" name="tel" value="<%=telefono%>">                    
                <input type="email" name="email" value="<%=email%>">
			</div>
		</div>
        <div class="contenedorBotones">
        	<input type="submit" name="consultar" value="Consultar">
            <input type="submit" name="insertar" value="Crear">
            <input type="submit" name="actualizar" value="Actualizar">
            <input type="submit" name="eliminar" value="Borrar">
            <input type="submit" name="limpiar" value="Limpiar">
     	</div>
	</form>
</div>	

<%
if (request.getParameter("men") != null) {
	String mensaje = request.getParameter("men");
	out.print("<script>alert('" + mensaje + "');</script>");
}
%>
</body>
</html>