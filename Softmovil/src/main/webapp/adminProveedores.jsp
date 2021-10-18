<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.unibosque.softmovil.Proveedores"%>
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
					<h1>Proveedores</h1>
					<p>En este panel podras gestionar los datos de los proveedores
						en el sistema</p>
					<form action="#" method="get" action="Controlador">
						<input type="hidden" name=menu value="adminProveedores"><label
							for="nit">NIT: </label><br> <input type="text" name="txtnit"
							id="nit" value="${proveedoresSeleccionado.getNit()}"><br>
						<label for="ciudad">Ciudad: </label><br> <input type="text"
							name="txtciudad" id="ciduad"
							value="${proveedoresSeleccionado.getCiudad_proveedor()}"><br>
						<label for="direccion"> Direccion: </label><br> <input
							type="text" name="txtdireccion" id="direccion"
							value="${proveedoresSeleccionado.getDireccion_proveedor()}"><br>
						<label for="nombre">Nombre Proveedor: </label><br> <input
							type="text" name="txtnombre" id="nombre_proveedores"
							value="${proveedoresSeleccionado.getNombre_proveedor()}"><br>
						<label for="telefono">Telefono: </label><br> <input
							type="telefono" name="txtelefono" id="telefono"
							value="${proveedoresSeleccionado.getTelefono_proveedor()}">

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
								<th>NIT</th>
								<th>Ciudad</th>
								<th>Dirección</th>
								<th>Nombre Proveedor</th>
								<th>Teléfono</th>
							</tr>
						</thead>
						<tbody>
							<%
							ArrayList<Proveedores> lista = (ArrayList<Proveedores>) request.getAttribute("lista");
							for (Proveedores proveedores : lista) {
							%>
							<tr>
								<td><%=proveedores.getNit()%></td>
								<td><%=proveedores.getCiudad_proveedor()%></td>
								<td><%=proveedores.getDireccion_proveedor()%></td>
								<td><%=proveedores.getNombre_proveedor()%></td>
								<td><%=proveedores.getTelefono_proveedor()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=adminProveedores&accion=Cargar&id=<%=proveedores.getNit()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=adminProveedores&accion=Eliminar&id=<%=proveedores.getNit()%>">Eliminar</a>
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
				<span>Usuarios</span> <a
					href="Controlador?menu=adminUsuario&accion=Listar&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Key.svg" alt=""></a>
			</button>

			<button id="btn-clientes">
				<span>Clientes</span> <a
					href="Controlador?menu=adminClientes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Contacts.svg" alt=""></a>
			</button>

			<button id="btn-proveedores" class="btn-clicked">
				<span>Proveedores</span> <a
					href="Controlador?menu=adminProveedores&accion=Listar&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Settings.svg" alt=""></a>
			</button>

			<button id="btn-ventas">
				<span>Ventas</span> <a
					href="Controlador?menu=adminVentas&accion=default&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Cash App.svg" alt=""></a>
			</button>

			<button id="btn-productos">
				<span>Productos</span> <a
					href="Controlador?menu=adminProductos&accion=Listar&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Briefcase.svg" alt=""></a>
			</button>

			<button id="btn-reportes">
				<span>Reportes</span> <a
					href="Controlador?menu=adminReportes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img
					src="img/adminUsuarioAssets/Bookmark.svg" alt=""></a>
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