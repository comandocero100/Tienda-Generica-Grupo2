<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLIENTES</title>
<link rel="stylesheet" href="css/estiloOpciones.css">
</head>
<body>
	<%!String cedula = "", nombre = "", direccion = "", telefono = "", email = "", estado = "";%>

	<%
	if (request.getParameter("cedula_cliente") != null) {
		cedula = request.getParameter("cedula_cliente");
		direccion = request.getParameter("direccion_cliente");
		email = request.getParameter("email_cliente");
		nombre = request.getParameter("nombre_cliente");
		telefono = request.getParameter("telefono__cliente");
		estado = "disabled";
		if (cedula == "") {
			estado = "enabled";
		} else {
			estado = "disabled";
		}
	}
	%>

	<div class="titulo">
		<h1>Tienda Genérica</h1>
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
				<li><a href="index.jsp">Cerrar sesión</a></li>
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
					<label for="">Cédula</label> <label for="">Nombre Completo</label>
					<label for="">Dirección</label>
				</div>
				<div>
					<input type="text" name="cedula" value="<%=cedula%>" <%=estado%>
						placeholder="ingrese documento"> <input type="hidden"
						name="ced" value="<%=cedula%>" placeholder="ingrese documento">
					<input type="text" name="nombre" value="<%=nombre%>"
						placeholder="ingrese nombre"> <input type="text"
						name="direccion" value="<%=direccion%>"
						placeholder="ingrese direccion">
				</div>
				<div>
					<label for="">Teléfono</label> <label for="">Correo
						Electrónico</label>
				</div>
				<div>
					<input type="text" name="tel" value="<%=telefono%>"
						placeholder="ingrese telefono"> <input type="email"
						name="email" value="<%=email%>" placeholder="ingrese email">
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