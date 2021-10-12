package co.edu.unibosque.softmovil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//**************Variables generales***************
	
	double subtotal=0, totalapagar=0;
	double precio=0, valor_iva=0, iva=0, subtotaliva=0, acusubtotal=0;
	long numfac=0, codProducto=0;
	int cantidad=0, item=0;
	
	
	String descripcion, cedulaCliente;
	
	
	List<Detalle_Venta> listaVentas= new ArrayList<>();
	Usuarios usuarios= new Usuarios();
	Detalle_Venta detalle_venta= new Detalle_Venta();
	
	//***********************************************

	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//***************** Metodos Locales**************
	
	public void buscarClientes(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(id);
		
		try {
			ArrayList<Clientes> listac= TestJSONClientes.getJSON();
			for(Clientes clientes:listac) {
				if(clientes.getCedula_cliente().equals(Long.parseLong(id))) {
					//System.out.println("clientes" + clientes.getCedula_cliente());
					request.setAttribute("clientesSeleccionado", clientes);
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Long buscarClientesId(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println(id);
			
			try {
				ArrayList<Clientes> listac= TestJSONClientes.getJSON();
				for(Clientes clientes:listac) {
					if(clientes.getCedula_cliente().equals(Long.parseLong(id))) {
						//System.out.println("clientes" + clientes.getCedula_cliente());
						request.setAttribute("clientesSeleccionado", clientes);
						return clientes.getCedula_cliente();
					}
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public void buscarProducto(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Productos> listap= TestJSONProductos.getJSON();
			for(Productos producto:listap) {
				if(producto.getCodigo_producto().equals(Long.parseLong(id))) {
					request.setAttribute("productoSeleccionado", producto);
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void mostrarFactura(String numFact, HttpServletRequest request, HttpServletResponse response)
		  throws ServletException, IOException {
		if(numFact == null) {
			numFact = "1";
			numfac=Integer.parseInt(numFact)+1;
			
		}else {
			numfac=Integer.parseInt(numFact)+1;
		}
		
		request.setAttribute("numerofactura", numfac);
	}
	
	public void grabarDetalle_Ventas(List<Detalle_Venta> listaVentas, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//************** Grabar en la tabla de detalles ventas **************
		
		for(Detalle_Venta detalle_venta : listaVentas) {
			System.out.println(detalle_venta.getDescripcion_producto());
			int respuesta = 0;
			try {
				respuesta = TestJSONDetalleVenta.postJSON(detalle_venta);
				PrintWriter write = response.getWriter();
				if(respuesta == 200) {
					System.out.println("Registros Grabados en Detalle ventas");
					
				}else {
					System.out.println("Hubo error");
					write.println("Error Detalle Ventas: " + respuesta);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		request.getRequestDispatcher("Controlador?menu=adminVentas&accion=default").forward(request, response);
		listaVentas.clear();
		item = 0;
		totalapagar = 0;
		subtotal = 0;
		valor_iva = 0;
		acusubtotal = 0;
		subtotaliva = 0;
		totalapagar = 0;
	}
	

	//**********************************************
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		
		
		
		//********************************************************************************************************************
		

		switch (menu) {
		
		case "adminUsuario":

			if (accion.equals("Listar")) {
				try {

					ArrayList<Usuarios> lista = TestJSON.getJSON();
					request.setAttribute("lista", lista);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Agregar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setPassword(request.getParameter("txtpassword"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				
				int res = 0;
				
				try {
					res = TestJSON.postJSON(usuario);
					if (res == 200) {
						request.getRequestDispatcher("Controlador?menu=adminUsuario&accion=Listar").forward(request,
								response);
					} else {
						System.out.println("Error al agregar registro STATUS: " + res);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				
			} else if (accion.equals("Actualizar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				
				try {
					respuesta = TestJSON.putJSON(usuario, usuario.getCedula_usuario());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminUsuario&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");
				String idParametro = id;
				try {

					ArrayList<Usuarios> lista1 = TestJSON.getJSON();

					for (Usuarios usuarios : lista1) {
						String idLista = String.valueOf(usuarios.getCedula_usuario());
						if (idLista.equals(idParametro)) {

							request.setAttribute("usuarioSeleccionado", usuarios);
							request.getRequestDispatcher("Controlador?menu=adminUsuario&accion=Listar").forward(request,
									response);
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				
				try {
					respuesta = TestJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminUsuario&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			request.getRequestDispatcher("/adminUsuario.jsp").forward(request, response);
			break;
			
		case "adminProveedores":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Proveedores> lista = TestJSONProveedores.getJSON();
					request.setAttribute("lista", lista);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Agregar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNit(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setTelefono_proveedor(request.getParameter("txtelefono"));

				int respuesta = 0;
				
				try {
					respuesta = TestJSONProveedores.postJSON(proveedor);
					if (respuesta == 200) {

						request.getRequestDispatcher("Controlador?menu=adminProveedores&accion=Listar").forward(request,
								response);

					} else {
						System.out.println("Error: " + respuesta);
					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Actualizar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNit(Long.parseLong(request.getParameter("txtnit")));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedor.setTelefono_proveedor(request.getParameter("txtelefono"));

				int respuesta = 0;

				try {
					respuesta = TestJSONProveedores.putJSON(proveedor, proveedor.getNit());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminProveedores&accion=Listar").forward(request,
								response);

					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				String idParametro = Long.toString(id);
				System.out.println(id + "buscar");

				try {
					ArrayList<Proveedores> lista1 = TestJSONProveedores.getJSON();

					for (Proveedores proveedor : lista1) {
						String idLista = Long.toString(proveedor.getNit());
						if (idLista.equals(idParametro)) {
							System.out.println("ingrese");
							request.setAttribute("proveedoresSeleccionado", proveedor);
							request.getRequestDispatcher("Controlador?menu=adminProveedores&accion=Listar")
									.forward(request, response);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;

				try {
					respuesta = TestJSONProveedores.deleteJSON(id);
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminProveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			request.getRequestDispatcher("/adminProveedores.jsp").forward(request, response);
			break;
			
		case "adminClientes":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Clientes> lista = TestJSONClientes.getJSON();
					request.setAttribute("lista", lista);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Agregar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtCedulaCliente")));
				cliente.setCorreo_cliente(request.getParameter("txtCorreoCliente"));
				cliente.setDireccion(request.getParameter("txtDireccion"));
				cliente.setNombre_cliente(request.getParameter("txtNombreCliente"));
				cliente.setTelefono_cliente(Long.parseLong(request.getParameter("txTelefonoCliente")));

				int respuesta = 0;
				
				try {
					respuesta = TestJSONClientes.postJSON(cliente);
					if (respuesta == 200) {

						request.getRequestDispatcher("Controlador?menu=adminClientes&accion=Listar").forward(request,
								response);

					} else {
						System.out.println("Error: " + respuesta);
					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Actualizar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente (Long.parseLong(request.getParameter("txtCedulaCliente")));
				cliente.setCorreo_cliente(request.getParameter("txtCorreoCliente"));
				cliente.setDireccion(request.getParameter("txtDireccion"));
				cliente.setNombre_cliente(request.getParameter("txtNombreCliente"));
				cliente.setTelefono_cliente(Long.parseLong(request.getParameter("txTelefonoCliente")));

				int respuesta = 0;

				try {
					respuesta = TestJSONClientes.putJSON(cliente, cliente.getCedula_cliente());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminClientes&accion=Listar").forward(request,
								response);

					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				String idParametro = Long.toString(id);

				try {
					ArrayList<Clientes> lista1 = TestJSONClientes.getJSON();

					for (Clientes cliente : lista1) {
						String idLista = String.valueOf(cliente.getCedula_cliente());
						if (idLista.equals(idParametro)) {

							request.setAttribute("clienteSeleccionado", cliente);
							request.getRequestDispatcher("Controlador?menu=adminClientes&accion=Listar")
									.forward(request, response);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;

				try {
					respuesta = TestJSONClientes.deleteJSON(id);
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminClientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/adminClientes.jsp").forward(request, response);
			break;
		
			case "adminProductos":
			
			if (accion.equals("Listar")) {
				try {
					ArrayList<Productos> lista = TestJSONProductos.getJSON();
					request.setAttribute("lista", lista);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Agregar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo")));
				producto.setIva_compra(Double.parseDouble(request.getParameter("txtiva")));
				producto.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				producto.setNombre_producto(request.getParameter("txtnombre_producto"));
				producto.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio_compra")));
				producto.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio_venta")));

				int respuesta = 0;
				try {
					respuesta = TestJSONProductos.postJSON(producto);
					if (respuesta == 200) {

						request.getRequestDispatcher("Controlador?menu=adminProductos&accion=Listar").forward(request,
								response);

					} else {
						System.out.println("Error: " + respuesta);
					}

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Actualizar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo")));
				producto.setIva_compra(Double.parseDouble(request.getParameter("txtiva")));
				producto.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				producto.setNombre_producto(request.getParameter("txtnombre_producto"));
				producto.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio_compra")));
				producto.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio_venta")));

				int respuesta = 0;

				try {
					respuesta = TestJSONProductos.putJSON(producto, producto.getCodigo_producto());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminProductos&accion=Listar").forward(request,
								response);

					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();

				}

			} else if (accion.equals("Cargar")) {
				String id = request.getParameter("id");
				System.out.println(id);
				String idParametro = id;

				try {
					ArrayList<Productos> lista1 = TestJSONProductos.getJSON();

					for (Productos producto : lista1) {
						String idLista = String.valueOf(producto.getCodigo_producto());
						if (idLista.equals(idParametro)) {
							
							request.setAttribute("productoSeleccionado", producto);
							request.getRequestDispatcher("Controlador?menu=adminProductos&accion=Listar").forward(request, response);
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;

				try {
					respuesta = TestJSONProductos.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=adminProductos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/adminProductos.jsp").forward(request, response);
			break;
			
		case "adminVentas":
			//*******************Variable para recibir la cedula del usuario y usarla para guardar la venta **********************
			String cedula_usuario_activo = request.getParameter("UsuarioActivo");
			usuarios.setCedula_usuario(Long.parseLong(cedula_usuario_activo));
			request.setAttribute("usuarioSeleccionado", cedula_usuario_activo);
			
			Long cedula_id = 0L;
			//System.out.println(usuarios.getCedula_usuario());
			//System.out.println(cedula_usuario_activo + "usuarioActivo");
			
			
			//****************************** Enviaremos al formulario adminVentas.jsp la cedula del usuario activo y la factura ***************
			request.setAttribute("usuarioSeleccionado", usuarios);
			request.setAttribute("numerofactura", numfac);
			//*****************************************************************************************************************
			if(accion.equals("BuscarCliente")) {
				
				String id=request.getParameter("cedulacliente");
				System.out.println(id);
				//System.out.println("cedula cliente" + id);
				this.buscarClientes(id, request, response);
				cedula_id = this.buscarClientesId(id, request, response);
				
			} else if (accion.equals("BuscarProducto")) {
				String id = request.getParameter("cedulacliente");
				this.buscarClientes(id, request, response);
				
				String cod= request.getParameter("codigoproducto");
				this.buscarProducto(cod, request, response);
				
			} else if (accion.equals("AgregarProducto")) {
				String id=request.getParameter("cedulacliente");
				this.buscarClientes(id, request, response);
				
				detalle_venta = new Detalle_Venta();
				item++;
				totalapagar = 0;
				acusubtotal = 0;
				subtotaliva = 0;
				
				codProducto= Long.parseLong(request.getParameter("codigoproducto"));
				descripcion = request.getParameter("nombreproducto");
				precio = Double.parseDouble(request.getParameter("precioproducto"));
				cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
				iva = Double.parseDouble(request.getParameter("ivaproducto"));
				
				subtotal= (precio * cantidad);
				valor_iva = subtotal*iva/100;
				
				detalle_venta.setCodigo_detalle_venta(item);
				detalle_venta.setCodigo_producto(codProducto);
				detalle_venta.setDescripcion_producto(descripcion);
				detalle_venta.setPrecio_producto(precio);
				detalle_venta.setCantidad_producto(cantidad);
				detalle_venta.setCodigo_venta(numfac);
				detalle_venta.setValor_iva(iva);
				detalle_venta.setValor_venta(subtotal);
				listaVentas.add(detalle_venta);
				
				for(int i=0; i < listaVentas.size(); i++) {
					acusubtotal += listaVentas.get(i).getValor_venta();	
					subtotaliva += listaVentas.get(i).getValor_iva();
					
				}
				
				totalapagar = acusubtotal + subtotaliva;
				detalle_venta.setValor_total(totalapagar);
				
				for(Detalle_Venta venta : listaVentas) {
					System.out.println(venta.getCodigo_detalle_venta());
					System.out.println(venta.getDescripcion_producto());
				}
				
				request.setAttribute("listaventas", listaVentas);
				request.setAttribute("totalsubtotal", acusubtotal);
				request.setAttribute("totaliva", subtotaliva);
				request.setAttribute("totalapagar", totalapagar);
				
	
			} else if (accion.equals("GenerarVenta")) {
				
				System.out.println("Entro por el boton generar venta");
				String numFact= request.getParameter("numerofactura");
				
				String cedulaCliente = request.getParameter("cedulacliente");
				
				System.out.println("cedula del cliente: ");
				
			
				System.out.println(numFact);
				System.out.println("cedulacliente");
				System.out.println(usuarios.getCedula_usuario());
				System.out.println(subtotaliva);
				System.out.println(acusubtotal);
				System.out.println(totalapagar);
				
				Ventas ventas = new Ventas();
				ventas.setCodigo_venta(Long.parseLong(numFact));

				ventas.setCedula_cliente(Long.parseLong(cedulaCliente));
				ventas.setCedula_usuario(usuarios.getCedula_usuario());
				ventas.setIva_venta(subtotaliva);
				ventas.setValor_venta(acusubtotal);
				ventas.setTotal_venta(totalapagar);
				
				
				int respuesta=0;
				
				try {
					respuesta = TestJSONVentas.postJSON(ventas);
					PrintWriter write = response.getWriter();
					if(respuesta==200) {
						this.grabarDetalle_Ventas(listaVentas, request, response);
						System.out.println("Grabacion Exitosa: " + respuesta);
						this.mostrarFactura(numFact, request, response);
						
					}else {
						write.println("Error Ventas: " + respuesta);
					}
					write.close();
					
				} catch (Exception e) {
					System.out.println("Hubo un error xd");
					e.printStackTrace();
				}
			
				
			}else {
				// *********** Muestro por primera vez el numero de la factura **************
				String factura = "0"; //request.getParameter("numerofactura");
				//System.out.println("numero factura" + factura);
				this.mostrarFactura(factura, request, response);
			
				
			}
				
			request.getRequestDispatcher("/adminVentas.jsp").forward(request, response);
			
			break;
			default:
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
