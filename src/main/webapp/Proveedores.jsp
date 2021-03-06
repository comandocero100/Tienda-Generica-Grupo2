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
if (request.getParameter("nit_proveedor") != null) {
	nit = request.getParameter("nit_proveedor");
	ciudad = request.getParameter("ciudad_proveedor");
	direccion = request.getParameter("direccion_proveedor");		
	nombre = request.getParameter("nombre_proveedor");		
	telefono = request.getParameter("telefono_proveedor");		
	if(nit == "") {
		estado = "enabled";
	}
	else{
		estado = "disabled";
	}
}
%>

<div class="titulo">
	<h1>Tienda Gen?rica</h1>
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
			<li><a href="index.jsp">Cerrar sesi?n</a></li>
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
            <label for="">Direcci?n</label>
            </div>
            <div>
            	<input type="text" name="nit" value="<%=nit%>" <%=estado%> placeholder="ingrese nit proveedor">
                <input type="hidden" name="ni" value="<%=nit%>" placeholder="ingrese nit">
                <input type="text" name="nombre" value="<%=nombre%>" placeholder="ingrese nombre proveedor">
                <input type="text" name="direccion" value="<%=direccion%>" placeholder="ingrese direccion proveedor">
            </div>
            <div>
                <label for="">Tel?fono</label>
                <label for="">Ciudad</label>
            </div>
            <div>
                <input type="text" name="tel" value="<%=telefono%>" placeholder="ingrese telefono proveedor">
                <input type="text" name="ciudad" value="<%=ciudad%>" placeholder="ingrese ciudad">
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