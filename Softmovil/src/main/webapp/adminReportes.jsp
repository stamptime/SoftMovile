<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="img/adminUsuarioAssets/logo.png" type="image/png" />
<link rel="stylesheet" href="css/adminReportesStyles/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reportes</title>
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
					<form method="get" action="Controlador">
						<div class="div-form">
							<input type="hidden" name=menu value="adminReportes">
							<button class="btn open" type="submit" name="accion" value="table-usuarios" id="usuarios">Usuarios</button>
							<button class="btn" type="submit" name="accion" value="table-clientes" id="actualizar">Clientes</button>
							<button class="btn" type="submit" name="accion" value="table-detalle-ventas" id="detalle-ventas" >Detalle ventas</button>
							<button class="btn" type="submit" name="accion" value="table-ventas" id="ventas">Ventas</button>
							<button class="btn" type="submit" name="accion" value="table-productos" id="productos" >Productos</button>
							<button class="btn" type="submit" name="accion" value="rable-proveedores" id="proveedores">Proveedores</button>
						</div>
					</form>
				</div>
			</section>

			<!-- Seccion de la tabla - Muestro datos de los usuarios -->

			<section class="table-usuarios table hidden" id="usuarios">
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
							<c:forEach var="lista" items="${listausuarios}">
								<tr>
									<td>${lista.getCedula_usuario()}</td>
									<td>${lista.getNombre_usuario()}</td>
									<td>${lista.getEmail_usuario()}</td>
									<td>${lista.getPassword()}</td>
									<td>${lista.getUsuario()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>

			<section class="table-clientes table hidden" id="actualizar">
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
							<c:forEach var="listacl" items="${listaclientes}">
								<tr>
									<td>${listacl.getCedula_cliente()}</td>
									<td>${listacl.getDireccion()}</td>
									<td>${listacl.getCorreo_cliente()}</td>
									<td>${listacl.getNombre_cliente()}</td>
									<td>${listacl.getTelefono_cliente()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>

			<section class="table-detalle-ventas table hidden" id="detalle-ventas">
				<div class="table-container">
					<table>
						<thead>
							<tr>
								<th>#</th>
								<th>Codigo</th>
								<th>Cantidad producto</th>
								<th>Codigo producto</th>
								<th>Descripcion producto</th>
								<th>Codigo venta</th>
								<th>Valor iva</th>
								<th>Valor total</th>
								<th>valor venta</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listade" items="${listadetalles}">
								<tr>
									<td>${listade.getCodigo_detalle_venta()}</td>
									<td>${listade.getCantidad_producto()}</td>
									<td>${listade.getCodigo_producto()}</td>
									<td>${listade.getDescripcion_producto()}</td>
									<td>${listade.getCodigo_venta()}</td>
									<td>${listade.getValor_total()}</td>
									<td>${listade.getValor_venta()}</td>
									<td>${listade.getValor_iva()}</td>
									<td>${listade.getPrecio_producto()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>

			<section class="table-ventas table hidden" id="ventas">
				<div class="table-container">
					<table>
						<thead>
							<tr>
								<th>Id Venta</th>
								<th>Cedula cliente</th>
								<th>Cedula usuario</th>
								<th>Codigo venta</th>
								<th>Iva</th>
								<th>Valor venta</th>
								<th>Total venta</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listave" items="${listaventas}">
								<tr>
									<td>${listave.getId_venta()}</td>
									<td>${listave.getCodigo_venta()}</td>
									<td>${listave.getCedula_cliente()}</td>
									<td>${listave.getCedula_usuario()}</td>
									<td>${listave.getIva_venta()}</td>
									<td>${listave.getValor_venta()}</td>
									<td>${listave.getTotal_venta()}</td>
									
								</tr>
							</c:forEach>
							<tr class="total">
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td id = 'total-cell'><span class="total-text">Total:</span><span class="total-numero">${totaltotal}</span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>

			<section class="table-productos table hidden" id="productos">
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
							<c:forEach var="listapro" items="${listaproductos}">
								<tr>
									<td>${listapro.getCodigo_producto()}</td>
									<td>${listapro.getIva_compra()}</td>
									<td>${listapro.getNit_proveedor()}</td>
									<td>${listapro.getNombre_producto()}</td>
									<td>${listapro.getPrecio_compra()}</td>
									<td>${listapro.getPrecio_venta()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>

			<section class="table-proveedores table hidden" id="proveedores">
				<div class="table-container">
					<table>
						<thead>
							<tr>
								<th>Nit</th>
								<th>Ciudad</th>
								<th>Direccion</th>
								<th>Nombre</th>
								<th>Telefono</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listaprov" items="${listaproveedores}">
								<tr>
									<td>${listaprov.getNit()}</td>
									<td>${listaprov.getCiudad_proveedor()}</td>
									<td>${listaprov.getDireccion_proveedor()}</td>
									<td>${listaprov.getNombre_proveedor()}</td>
									<td>${listaprov.getTelefono_proveedor()} </td>
								</tr>
							</c:forEach>
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
			
			<button id="btn-clientes">
				<span>Clientes</span>
				<a href="Controlador?menu=adminClientes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Contacts.svg" alt=""></a>
			</button>

			<button id="btn-proveedores">
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
			
			<button id="btn-reportes" class="btn-clicked">
				<span>Reportes</span> 
				<a href="Controlador?menu=adminReportes&accion=Listar&UsuarioActivo=${usuarioActivo}"><img src="img/adminUsuarioAssets/Bookmark.svg" alt=""></a>
			</button>
			
			<a href="SoftmovielServerlet?username=&password=&accion=Ingresar"><button id="btn-reportes">
					<span></span>
			</button></a>	
		</div> 
		
	</main>
	<footer> </footer>
	<script src="js/adminReportes/index.js"></script>
</body>
</html>