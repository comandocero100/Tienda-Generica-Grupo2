<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link rel="stylesheet" href="css/estiloOpciones.css">
</head>
<body>
	<%!String codigo = "", cedula = "", nombre = "", iva = "", total_venta = "", valor_venta = "", estado = "";%>

	<%
	if (request.getParameter("cedula_usuario") != null) {
		codigo = request.getParameter("codigo_venta");
		cedula = request.getParameter("cedula_usuario");
		nombre = request.getParameter("nombre_cliente");
		iva = request.getParameter("iva_venta");
		total_venta = request.getParameter("total_venta");
		valor_venta = request.getParameter("valor_venta");

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
				<h3>Ventas</h3>
			</div>

		</form>
	</div>

	<div class="contenedorIN2">
		<form action="">
			<div>
				<label for="">Cedula</label> <input type="text" name="cedula"
					value="<%=cedula%>" placeholder="ingrese cedula usuario">
				<div>
					<input type="submit" name="consultar" value="Consultar" onclick="funcionconsul()">
				</div>
				<div>
					<label for="">Cliente</label> <input type="text"
						name="nombre_cliente" >
				</div>
				<div>
					<label for="">Consec.</label> <input type="text" name="consecutivo"
						value="<%=codigo%>" placeholder="ingrese consecutivo">
				</div>
			</div>
		</form>
	</div>
	<div class="contendor-fluid-2">
		<div class="contenedorIN3">
			<form>
				<label for="">Cod. Producto</label> <input type="text"
					name="producto" value="<%=codigo%>" placeholder="ingrese codigo">
				<div class="boton-producto">
					<input type="submit" name="consultar" value="Consultar" onclick="funcioncod()">
				</div>
				<label for="">Nombre Producto</label> <input type="text"
					name="nombreProducto"> <label for="">Cantidad</label> <input
					type="number" name="cantidadProducto"> <label for="">Valor
					Total</label> <input type="number" name="valor total">
			</form>
		</div>
	</div>
	<div class="contenedorIN4">
		<label for="">Total venta</label> <input type="number"
			name="valor total"> <label for="">Total iva</label> <input
			type="number" name="valor total"> <label for="">Total
			con iva</label> <input type="number" name="valor total">
	</div>
	<div class="contenedorBotones">
		<input type="submit" name="confirmar" value="confirmar"
			onclick="funcion()">
	</div>

	<%
	if (request.getParameter("men") != null) {
		String mensaje = request.getParameter("men");
		out.print("<script>alert('" + mensaje + "');</script>");
	}
	%>
	<script>
		function funcion() {
			alert("transaccion realizada con exito");
		}
	</script>
	<script>
		function funcionconsul() {
			alert("cliente obtenido");
		}
	</script>
	<script>
		function funcioncod() {
			alert("codigo del producto exitoso");
		}
	</script>
</body>
</html>