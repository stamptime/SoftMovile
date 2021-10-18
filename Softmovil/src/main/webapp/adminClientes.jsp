<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.unibosque.softmovil.Clientes"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="img/adminUsuarioAssets/logo.png" type="image/png" />
<link rel="stylesheet" href="css/adminUsuarioStyles/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Panel Administrador</title>
</head>
<body>
	<header>
		<nav>
			<img class="logo" src="img/adminUsuarioAssets/Group 4.png"
				alt="Logo Pagina wed"> <img class="sandwich"
				src="img/adminUsuarioAssets/Vector.png" alt="Icono menu">
		</nav>
	</header>
	<main>

		<div class="container">

			<!-- Seccion del formulario - ingreso de datos de proveedores -->
			<section class="form">
				<div class="form-container">
					<h1>Clientes</h1>
					<p>En este panel podras gestionar los datos de los clientes
						en el sistema</p>
					<form action="#" method="get" action="Controlador">
						<input type="hidden" name=menu value="adminClientes"><label
							for="cedula_cliente">Cedula: </label><br> <input type="text" name="txtCedulaCliente"
							id="txtCedulaCliente" value="${clienteSeleccionado.getCedula_cliente()}"><br>
						<label for="direccion">Direccion: </label><br> <input type="text"
							name="txtDireccion" id="direccion"
							value="${clienteSeleccionado.getDireccion()}"><br>
						<label for="txtCorreoCliente"> Correo: </label><br> <input
							type="text" name="txtCorreoCliente" id="txtCorreoCliente"
							value="${clienteSeleccionado.getCorreo_cliente()}"><br>
						<label for="txtNombreCliente">Nombre: </label><br> <input
							type="text" name="txtNombreCliente" id="txtNombreCliente"
							value="${clienteSeleccionado.getNombre_cliente()}"><br>
						<label for="telefono">Telefono: </label><br> <input
							type="telefono" name="txTelefonoCliente" id="txTelefonoCliente"
							value="${clienteSeleccionado.getTelefono_cliente()}">

						<div>
							<button type="submit" name="accion" value="Agregar"
								id="btn-agregar" name="agregar">Agregar</button>
							<button type="submit" name="accion" value="Actualizar"
								id="btn-actualizar" name="actualizar">Actualizar</button>
						</div>
					</form>
				</div>
			</section>

			<!-- Seccion de la tabla - Muestro datos de los usuarios -->

			<section class="table">
				<div class="table-container">
					<table>
						<thead>
							<tr>
								<th>Cedula</th>
								<th>Direccion</th>
								<th>Correo</th>
								<th>Nombre</th>
								<th>Teléfono</th>
							</tr>
						</thead>
						<tbody>
							<%
							ArrayList<Clientes> lista = (ArrayList<Clientes>) request.getAttribute("lista");
							for (Clientes cliente : lista) {
							%>
							<tr>
								<td><%=cliente.getCedula_cliente()%></td>
								<td><%=cliente.getDireccion()%></td>
								<td><%=cliente.getCorreo_cliente()%></td>
								<td><%=cliente.getNombre_cliente()%></td>
								<td><%=cliente.getTelefono_cliente()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=adminClientes&accion=Cargar&id=<%=cliente.getCedula_cliente()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=adminClientes&accion=Eliminar&id=<%=cliente.getCedula_cliente()%>">Eliminar</a>
								</td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</section>

		</div>

		<div class="menu-options">
			<button id="btn-usuarios">
				<span>Usuarios</span> 
				<a href="Controlador?menu=adminUsuario&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Key.svg" alt=""></a>
			</button>
			
			<button id="btn-clientes" class="btn-clicked">
				<span>Clientes</span>
				<a href="Controlador?menu=adminClientes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Contacts.svg" alt=""></a>
			</button>

			<button id="btn-proveedores" >
				<span>Proveedores</span>
				<a href="Controlador?menu=adminProveedores&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Settings.svg" alt=""></a>
			</button>
			
			<button id="btn-ventas">
				<span>Ventas</span> 
				<a href="Controlador?menu=adminVentas&accion=default&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Cash App.svg" alt=""></a>
			</button>
			
			<button id="btn-productos">
				<span>Productos</span> 
				<a href="Controlador?menu=adminProductos&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Briefcase.svg" alt=""></a>
			</button>
			
			<button id="btn-reportes" >
				<span>Reportes</span> 
				<a href="Controlador?menu=adminReportes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Bookmark.svg" alt=""></a>
			</button>
			
			<a href="SoftmovielServerlet?username=&password=&accion=Ingresar"><button id="btn-reportes">
					<span></span>
			</button></a>
		</div> 

	</main>
	<footer> </footer>
	<script src="js/adminUsuariosInteraction/index.js"></script>
</body>
</html>