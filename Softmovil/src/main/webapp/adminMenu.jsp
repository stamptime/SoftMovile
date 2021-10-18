<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/adminPanelStyles/main.css">

<title>Admin Panel</title>
</head>
<body>
	<header>
		<nav>
			<section>
				<img src="img/adminPanelAssets/logo.png"
					alt="Logo de la empresa internacional">
				<h1>
					<span>Soft</span>Movile
				</h1>
			</section>
			<section>
				<ul>
					<li>Incio</li>
					<li>Productos</li>
					<li>Abmin Panel</li>
					<li>Contacto</li>
				</ul>
			</section>
		</nav>
	</header>
	<main>
		<div class="container">
			<div class="circulo"></div>
			<section class="separador">
				<h1>
					Modificacion de<br>usuarios
				</h1>
			</section>
			<section class="section-buttons">
				
					<button>
					    <a href="Controlador?menu=adminUsuario&accion=Listar&UsuarioActivo=${usuario.getCedula_usuario()}">Usuarios</a>
						<img src="img/adminPanelAssets/Key.svg" alt="">
					</button>
					<button>
						 <a href="Controlador?menu=adminClientes&accion=Listar&UsuarioActivo=${usuario.getCedula_usuario()}">Clientes</a> 
						<img src="img/adminPanelAssets/Contacts.svg" alt="">
					</button>
					<button>
						<a href="Controlador?menu=adminProveedores&accion=Listar&UsuarioActivo=${usuario.getCedula_usuario()}">Proveedores</a>
						<img src="img/adminPanelAssets/Settings.svg" alt="">
					</button>
					<button>
						<a href="Controlador?menu=adminProductos&accion=Listar&UsuarioActivo=${usuario.getCedula_usuario()}">Productos </a>
						<img src="img/adminPanelAssets/Briefcase.svg" alt="">
					</button>
					<button>
						<a href="Controlador?menu=adminVentas&accion=default&UsuarioActivo=${usuario.getCedula_usuario()}">Ventas</a> 
						<img src="img/adminPanelAssets/Cash App.svg" alt="">
					</button>
					<button>
						<a href="Controlador?menu=adminReportes&accion=Listar&UsuarioActivo=${usuario.getCedula_usuario()}">Reportes</a>
						<img src="img/adminPanelAssets/Briefcase.svg" alt="">
					</button>
			<!---->
			</section>
		</div>
	</main>
	<footer> </footer>
</body>
</html>