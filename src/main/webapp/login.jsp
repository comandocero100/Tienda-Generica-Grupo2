<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Genérica</title>
<link rel="stylesheet" href="css/estiloLogin.css">
</head>
<body>

	<form action="Login" method="post">
		<div class="contenedorGeneral">
			<h1>Bienvenidos a la Tienda Genérica</h1>


			<div class="contenedorDatos">
				<div>
					<label>Usuario&nbsp; &nbsp; &nbsp; &nbsp;</label><input type="text"
						name="usuario">
				</div>
				<div>
					<label>Contraseña</label><input type="password" name="clave">
				</div>
			</div>
			<div class="contenedorBotones">
				<input type="submit" name="enviar" value="Ingresar"> <a
					href="index.jsp"><input type="button" value="Cancelar"></a>
			</div>
			<div>
			
			</div>
		</div>
	</form>
	<form class="show-img" style="float: right;">
		<h2>PRODUCTOS NOVEDOSOS</h2>
		<p>AL ALCANCE DE TU MANO</p>

		<a href="#" class="btn-img">MAS PRODUCTOS<i
			class="fas fa-angle-double-right"></i></a>
	</form>

</body>
</html>