/**
 * 
 */
$(document).ready(function(){
	
	function listarUsuarios(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Usuarios"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Correo</th>
				<th>Nombre</th>
				<th>Password</th>
				<th>Usuario</th>
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedulaUsuario}</td>
					<td>${fila.emailUsuario}</td>
					<td>${fila.nombreUsuario}</td>
					<td>${fila.clave}</td>
					<td>${fila.usuario}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarClientes(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Clientes"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Direccion</th>				
				<th>Correo</th>				
				<th>Nombre</th>
				<th>Telefono</th>
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedulaCliente}</td>
					<td>${fila.direccionCliente}</td>
					<td>${fila.emailCliente}</td>
					<td>${fila.nombreCliente}</td>					
					<td>${fila.telefonoCliente}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarVentas(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Ventas"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>Cod.Venta</th>
				<th>Ced.Cliente</th>
				<th>Ced.Usuario</th>
				<th>IvaVenta</th>
				<th>Tot.Venta</th>
				<th>ValorVenta</th>				
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>
					<td>${fila.codigoVenta}</td>
					<td>${fila.cedulaCliente}</td>
					<td>${fila.cedulaUsuario}</td>
					<td>${fila.ivaVenta}</td>
					<td>${fila.totalVenta}</td>
					<td>${fila.valorVenta}</td>				
					</tr>`
				}
			}
		})
	}
	
	$('#listarUsuarios').on('click',function(){
			listarUsuarios();
		})
	
	$('#listarClientes').on('click',function(){
			listarClientes();
		})
	
	$('#listarVentas').on('click',function(){
			listarVentas();
		})	
})