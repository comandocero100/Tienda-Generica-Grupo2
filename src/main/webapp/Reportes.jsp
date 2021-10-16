<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/Reportes.js"></script>

<title>Reportes</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="css/estiloReportes.css">
<link rel="stylesheet" href="css/estiloOpciones.css">

</head>
<body>

<div class="titulo">
	<h1>Gestion de Reportes</h1>
</div>
<header>
	<nav>
		<ul>
			<li><a href="Usuarios.jsp">Usuarios</a></li>
			<li><a href="Clientes.jsp">Clientes</a></li>
			<li><a href="Proveedores.jsp">Proveedores</a></li>
			<li><a href="Productos.jsp">Productos</a></li>
			<li><a href="Ventas.jsp">Ventas</a></li>
			<li><a href="Reportes.jsp">Reportes</a></li>
			<li><a href="index.jsp">Cerrar sesión</a></li>
		</ul>
	</nav>
</header>
	
<div class="contendor-fluid">
	<div class="titulo">
		<h3>Reportes</h3>
	</div>
	<div class="Botones">
		<button id="listarUsuarios">Listado Usuarios</button>
		<button id="listarClientes">Listado Clientes</button>
		<button id="listarVentas">Ventas por Cliente</button>
	</div>
</div>

<table id="tabla" class="table table-striped table-bordered"  style="width:100%">


</table>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
<script>
$(document).ready(function() {
    $('#tabla').DataTable();
} );
</script>
</body>
</html>