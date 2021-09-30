
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CLIENTES PRUEBA</title>
</head>
<body>


	<h1>Modulo clientes</h1>
	<form action="clientes" method="post">
		<div>
			<label>Cedula Cliente: </label><input type="number"
				name="cedula_cliente">
		</div>
		<div>
			<label>Direccion Cliente: </label><input type="text"
				name="direccion_cliente">
		</div>
		<div>
			<label>Email Cliente: </label><input type="text" name="email_cliente">
		</div>
		<div>
			<label>Nombre Cliente: </label><input type="text"
				name="nombre_cliente">
		</div>
		<div>
			<label>Telefono Cliente: </label><input type="text"
				name="telefono_cliente">
		</div>
		<div>
			<input type="submit" name="insertar" value="Registrar"> <input
				type="submit" name="consultar" value="Consultar"> <input
				type="submit" name="actualizar" value="Actualizar"> <input
				type="submit" name="eliminar" value="Eliminar">

		</div>


	</form>
<%
if(request.getParameter("men")!=null){
	String mensaje = request.getParameter("men");
	out.print("<script>alert('"+mensaje+"'); </script>");
}
%>	

</body>
</html>