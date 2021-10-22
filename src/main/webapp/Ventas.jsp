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

<%!String nombre_cliente="";
String cedula = "";
%>         

<% if(request.getParameter("cedula")!=null){
cedula=request.getParameter("cedula");
nombre_cliente= request.getParameter("nombre");
}
%>  

<%!String nombre_producto="", nombre_producto1="",nombre_producto2="", estado="";
long codigo_producto, codigo_producto1 ,codigo_producto2, codigoVenta;
int cantidad, cantidad1, cantidad2;
double totalventaconiva, totalventaconiva1,totalventaconiva2,
	   iva_compra , iva_compra1 , iva_compra2,
	   precio_venta,precio_venta1,precio_venta2,
       totalventa,totalventa1,totalventa2,
       valorTotal, totalIva ,totalConIva ;
%>

<%
if(request.getParameter("limpiarVenta")!=null){		
	cedula="";
	nombre_cliente= "";
	nombre_producto="";
	nombre_producto1="";
	nombre_producto2="";
	codigo_producto=0;
	codigo_producto1=0;
	codigo_producto2=0;
	codigoVenta=0;
	cantidad=0;
	cantidad1=0;
	cantidad2=0;
	totalventaconiva=0;
	totalventaconiva1=0;
	totalventaconiva2=0;
	iva_compra=0;
	iva_compra1=0;
	iva_compra2=0;
	precio_venta=0;
	precio_venta1=0;
	precio_venta2=0;
	totalventa=0;
	totalventa1=0;
	totalventa2=0;
	valorTotal=0;
	totalIva=0;
	totalConIva=0;
}
%>

<%
if(request.getParameter("codigo_producto")!=null){
codigo_producto=Long.parseLong(request.getParameter("codigo_producto"));
nombre_producto= request.getParameter("nombre_producto");
precio_venta= Double.parseDouble(request.getParameter("precio_venta"));
iva_compra = Double.parseDouble(request.getParameter("iva_compra"));
}
%>

<% 
if(request.getParameter("codigo_producto1")!=null){
codigo_producto1=Long.parseLong(request.getParameter("codigo_producto1"));
nombre_producto1= request.getParameter("nombre_producto1");
precio_venta1= Double.parseDouble(request.getParameter("precio_venta1"));
iva_compra1 = Double.parseDouble(request.getParameter("iva_compra1"));
}
%>

<% 
if(request.getParameter("codigo_producto2")!=null){
codigo_producto2=Long.parseLong(request.getParameter("codigo_producto2"));
nombre_producto2= request.getParameter("nombre_producto2");
precio_venta2= Double.parseDouble(request.getParameter("precio_venta2"));
iva_compra2 = Double.parseDouble(request.getParameter("iva_compra2"));
}
%>  
 
<%
if(request.getParameter("valorTotal")!=null){
	cantidad = Integer.parseInt(request.getParameter("cantidad"));
	cantidad1 = Integer.parseInt(request.getParameter("cantidad1"));
	cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));
	totalventaconiva = Double.parseDouble(request.getParameter("totalventaconiva"));
	totalventaconiva1 = Double.parseDouble(request.getParameter("totalventaconiva1"));
	totalventaconiva2 = Double.parseDouble(request.getParameter("totalventaconiva2"));
	valorTotal = Double.parseDouble(request.getParameter("valorTotal"));
	totalIva = Double.parseDouble(request.getParameter("totalIva"));
	totalConIva = Double.parseDouble(request.getParameter("totalConIva"));
	totalventa = Double.parseDouble(request.getParameter("totalventa"));
	totalventa1 = Double.parseDouble(request.getParameter("totalventa1"));
	totalventa2 = Double.parseDouble(request.getParameter("totalventa2"));		
}
%>   

<%if(request.getParameter("codigoVenta")!=null){	
	codigoVenta = Long.parseLong(request.getParameter("codigoVenta"));
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
	    <div class="cliente">
	        
	            <label>Cedula:</label>
	            <input type="text" name="cedula" value="<%=cedula%>">
	        
	        
	        <div class="btn-cliente">
	            <input type="submit" name="consultar_cli" value="Consultar"  >
	        </div>
	
	        
	            <label>Cliente:</label>
	            <input type="text" name="nombre_cliente" value="<%=nombre_cliente%>">
	        
	
	        
	            <label>Consec:</label>  
	            <input type="text" name="codigoVenta" value="<%=codigoVenta%>">
	        
		</div>    
   		<hr>
		<div class="productos">
			<div class="productosGrande">      
		    	<div class="individuales-uno">
		       
		        	
		        		<label>Codigo Producto:</label> <input type="text" name="codigo_producto" value="<%=codigo_producto%>"required>
		        	
		           
		        	<div class="btn-productosGrande">
		        		<input type="submit" name="consultar" value="Consultar">
		        	</div>
		        
		        	
		        		<label>Nombre Producto</label> <input type="text" name="nombre_producto" value="<%=nombre_producto%>" readonly>
		        	
		
		         	<input type="hidden" name="precioV" value="<%=precio_venta%>">
		         	<input type="hidden" name="ivap" value="<%=iva_compra%>"> 
		         	<input type="hidden" name="totalventa" value="<%=totalventa%>">                              
		
		        	
		        		<label>Cantidad:</label><input type="text" name="cantidad" value="<%=cantidad%>">
		        	
		
		            
		        	
		        		<label>Valor Venta:</label><input type="text" name="valor_venta" value="<%=totalventaconiva%>">
		        	
				</div>		
				<hr>
		        <div class="individuales">
		        
		        	<div>
		        		<label>Codigo Producto:</label> <input type="text" name="codigo_producto1" value="<%=codigo_producto1%>"required>
		        	</div>
		           
		        	<div class="btn-productosGrande">
		        		<input type="submit" name="consultar1" value="Consultar">
		        	</div>
		        
		        	<div>
		        		<label>Nombre Producto</label> <input type="text" name="nombre_producto1" value="<%=nombre_producto1%>">
		        	</div>
		
		         	<input type="hidden" name="precioV1" value="<%=precio_venta1%>">
		         	<input type="hidden" name="ivap1" value="<%=iva_compra1%>">
		         	<input type="hidden" name="totalventa1" value="<%=totalventa1%>">                   
		
		        	<div>
		        		<label>Cantidad:</label><input type="text" name="cantidad1" value="<%=cantidad1%>">
		        	</div>
		            
			        <div>
			        	<label>Valor venta:</label><input type="text" name="valor_venta1" value="<%=totalventaconiva1%>">
			        </div>
				</div>		    
		    	<hr>
		 		<div class="individuales">     
		       
		        	<div>
		        		<label>Codigo Producto:</label> <input type="text" name="codigo_producto2" value="<%=codigo_producto2%>"required>
		        	</div>
		           
		        	<div class="btn-productosGrande">
		        		<input type="submit" name="consultar2" value="Consultar">
		        	</div>
		        	
		        	<div>
		        		<label>Nombre Producto</label> <input type="text" name="nombre_producto2" value="<%=nombre_producto2%>">
		        	</div>
		
					<input type="hidden" name="precioV2" value="<%=precio_venta2%>">
		        	<input type="hidden" name="ivap2" value="<%=iva_compra2%>">  
		        	<input type="hidden" name="totalventa2" value="<%=totalventa2%>">                 
		
		        	<div>
		        		<label>Cantidad:</label><input type="text" name="cantidad2" value="<%=cantidad2%>">
		        	</div>
		            
		        	<div>
		        		<label>Valor venta:</label><input type="text" name="valor_venta2" value="<%=totalventaconiva2%>">
		        	</div>
				</div>
			</div>
			<hr>			
			<div class="precios">
		        <div>
		            <label>Valor Total:</label>
		            <input type="text" name="valorTotal" value="<%=valorTotal%>">
		        </div>
		
		        <div>
		            <label>Total Iva:</label>
		            <input type="text" name="totalIva" value="<%=totalIva%>">
		        </div>
		
		        <div>
		            <label>Total con Iva:</label>
		            <input type="text" name="totalConIva" value="<%=totalConIva%>">
		        </div>        
		        
		        <div class="btn-precios">            
		            <input type="submit" name="calcular" value="calcular">
		            <input type="submit" name="confirmar" value="Confirmar">	        	
		        	<input type="submit" name="Limpiar" value="Limpiar">
		        </div>       
			</div>
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