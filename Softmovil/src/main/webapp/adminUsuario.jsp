<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="co.edu.unibosque.softmovil.Usuarios"%>
<%@page import="java.util.ArrayList"%>
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

			<!-- Seccion del formulario - ingreso de datos de usuarios -->
			<section class="form">
				<div class="form-container">
					<h1>Usuario</h1>
					<p>En este panel podras gestionar los datos de los usuarios en
						el sistema</p>
					<form action="#" method="get" action="./Controlador">
						<input type="hidden" name=menu value="adminUsuario"><label
							for="cedula">Cedula: </label><br> <input type="text"
							name="txtcedula" id="cedula"
							value="${usuarioSeleccionado.getCedula_usuario()}"><br>
						<label for="nombre">Nombre: </label><br> <input type="text"
							name="txtnombre" id="nombre"
							value="${usuarioSeleccionado.getNombre_usuario()}"><br>
						<label for="email">Email: </label><br> <input type="email"
							name="txtemail" id="email"
							value="${usuarioSeleccionado.getEmail_usuario()}"><br>
						<label for="usuario">Usuario: </label><br> <input
							type="usuario" name="txtusuario" id="usuario"
							value="${usuarioSeleccionado.getUsuario()}"><br> <label
							for="password">Password: </label><br> <input type="password"
							name="txtpassword" id="password"
							value="${usuarioSeleccionado.getPassword()}">

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
								<th>Nombre</th>
								<th>Email</th>
								<th>Usuario</th>
								<th>Contraseña</th>
							</tr>
						</thead>
						<tbody>
							<%
							ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
							for (Usuarios usuario : lista) {
							%>
							<tr>
								<td><%=usuario.getCedula_usuario()%></td>
								<td><%=usuario.getNombre_usuario()%></td>
								<td><%=usuario.getEmail_usuario()%></td>
								<td><%=usuario.getUsuario()%></td>
								<td><%=usuario.getPassword()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=adminUsuario&accion=Cargar&id=<%=usuario.getCedula_usuario()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=adminUsuario&accion=Eliminar&id=<%=usuario.getCedula_usuario()%>">Eliminar</a>
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
			<button id="btn-usuarios" class="btn-clicked">
				<span>Usuarios</span> <img src="img/adminUsuarioAssets/Key.svg"
					alt="">
			</button>
			<button id="btn-clientes">
				<span>Clientes</span> <img src="img/adminUsuarioAssets/Contacts.svg"
					alt="">
			</button>
			<button id="btn-proveedores">
				<span>Proveedores</span> <img
					src="img/adminUsuarioAssets/Settings.svg" alt="">
			</button>
			<button id="btn-ventas">
				<span>Ventas</span> <img src="img/adminUsuarioAssets/Cash App.svg"
					alt="">
			</button>
			<button id="btn-productos">
				<span>Productos</span> <img
					src="img/adminUsuarioAssets/Briefcase.svg" alt="">
			</button>
			<button id="btn-reportes">
				<span>Reportes</span> <img src="img/adminUsuarioAssets/Bookmark.svg"
					alt="">
			</button>
		</div>

	</main>
	<footer> </footer>
	<script src="js/adminUsuariosInteraction/index.js"></script>
</body>
</html>