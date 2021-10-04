<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="css/estiloOpciones.css">
</head>
<body>
<%!String nit = "", ciudad = "", direccion = "", nombre = "",  telefono = "",  estado = "";%>

<%
if (request.getParameter("nit") != null) {
	nit = request.getParameter("nit");
	ciudad = request.getParameter("ciudad");
	direccion = request.getParameter("direccion");		
	nombre = request.getParameter("nombre");		
	telefono = request.getParameter("tel");		
	estado = "disabled";
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
	<form action="Proveedores" method="post">
		<div class="titulo">
			<h3>Proveedores</h3>
		</div>
        <div class="contenedorIN">
			<div>
            <label for="">NIT</label>
            <label for="">Nombre Proveedor</label>
            <label for="">Dirección</label>
            </div>
            <div>
            	<input type="text" name="nit" value="<%=nit%>" <%=estado%>>
                <input type="hidden" name="ni" value="<%=nit%>">
                <input type="text" name="nombre" value="<%=nombre%>">
                <input type="text" name="direccion" value="<%=direccion%>">
            </div>
            <div>
                <label for="">Teléfono</label>
                <label for="">Ciudad</label>
            </div>
            <div>
                <input type="text" name="tel" value="<%=telefono%>">
                <input type="text" name="ciudad" value="<%=ciudad%>">
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