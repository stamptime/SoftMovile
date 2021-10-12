<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.unibosque.softmovil.Productos"%>
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
					<h1>Productos</h1>
					<p>En este panel podras gestionar los datos de los productos
						en el sistema</p>
					<form action="#" method="get" action="Controlador">
						<input type="hidden" name=menu value="adminProductos">
						
						<label for="codigo">Codigo Producto: </label><br>
						<input type="text" name="txtcodigo" id="codigo" value="${productoSeleccionado.getCodigo_producto()}"><br>
						
						<label for="iva">IVA: </label><br>
						<input type="text" name="txtiva" id="iva" value="${productoSeleccionado.getIva_compra()}"><br>
						
						<label for="nit">Nit Proveedor: </label><br>
						<input type="text" name="txtnit" id="nit" value="${productoSeleccionado.getNit_proveedor()}"><br>
						
						<label for="nombre_producto">Nombre Producto: </label><br>
						<input type="text" name="txtnombre_producto" id="nombre_producto" value="${productoSeleccionado.getNombre_producto()}"><br>
						
						<label for="precio_compra">Precio Compra: </label><br> 
						<input type="text" name="txtprecio_compra" id="precio_compra" value="${productoSeleccionado.getPrecio_compra()}">
						
						<label for="precio_venta">Precio Venta: </label><br> 
						<input type="text" name="txtprecio_venta" id="precio_venta" value="${productoSeleccionado.getPrecio_venta()}">

						<div>
							<button type="submit" name="accion" value="Agregar" id="btn-agregar" name="agregar">Agregar</button>
							<button type="submit" name="accion" value="Actualizar" id="btn-actualizar" name="actualizar">Actualizar</button>
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
								<th>Codigo Producto</th>
								<th>IVA</th>
								<th>Nit Proveedor</th>
								<th>Nombre Producto</th>
								<th>Precio Compra</th>
								<th>Precio Venta</th>
								
							</tr>
						</thead>
						<tbody>
							<%
							ArrayList<Productos> lista = (ArrayList<Productos>) request.getAttribute("lista");
							for (Productos productos : lista) {
							%>
							<tr>
								<td><%=productos.getCodigo_producto()%></td>
								<td><%=productos.getIva_compra()%></td>
								<td><%=productos.getNit_proveedor()%></td>
								<td><%=productos.getNombre_producto()%></td>
								<td><%=productos.getPrecio_compra()%></td>
								<td><%=productos.getPrecio_venta()%></td>
								<td><a class="btn btn-warning"
									href="Controlador?menu=adminProductos&accion=Cargar&id=<%=productos.getCodigo_producto()%>">Editar</a>
									<a class="btn btn-danger"
									href="Controlador?menu=adminProductos&accion=Eliminar&id=<%=productos.getCodigo_producto()%>">Eliminar</a>
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