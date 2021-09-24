<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TIENDA GENERICA</title>
<!--font awesome-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
<!--font oswald-->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;300;400&display=swap"
	rel="stylesheet">
<!--custom css-->
<link rel="stylesheet" href="css/estiloMenuPrincipal.css">
</head>
<body>
	<div class="entrada-general">

		<h1>¡Bienvenido a su tienda!</h1>
	</div>


	<div class="menu-btn">
		<i class="fas fa-bars"></i>
	</div>


	<div class="container">
		<nav class="nav-main">
			<img src="img/shop.png" alt="LOGO" class="nav-brand">
			<ul class="nav-menu show">
				<li><a href="login.jsp">Ingresar</a></li>
				<li><a href="#">Productos</a></li>
				<li><a href="#">Servicios</a></li>
				<li><a href="#">Novedades</a></li>
				<li><a href="#">Mas</a></li>
			</ul>
			<ul class="nav-menu-right">
				<li><a href="#"> <i class="fas fa-search"></i>
				</a></li>
			</ul>
		</nav>
	</div>
	<hr>

	<!--SHOWCASE-->
	<header class="showcase">
		<h2>PRODUCTOS NOVEDOSOS</h2>
		<p>AL ALCANCE DE TU MANO</p>

		<a href="#" class="btn">MAS PRODUCTOS<i
			class="fas fa-angle-double-right"></i></a>
	</header>
	
	<footer class="footer">
        <div>
            <h2>copyright Grupo 2, Ciclo 3, Desarrollo de Software 2021.</h2>
        </div>
    </footer>
</body>
</html>