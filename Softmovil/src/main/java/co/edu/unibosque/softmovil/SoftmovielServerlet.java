package co.edu.unibosque.softmovil;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SoftmovielServerlet
 */
@WebServlet("/SoftmovielServerlet")
public class SoftmovielServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SoftmovielServerlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void validarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<Usuarios> lista = TestJSON.getJSON();
			request.setAttribute("lista", lista);
			String usua = request.getParameter("username");
			String pass = request.getParameter("password");
			int respuesta = 0;
			if(usua != null && pass != null) {
				System.out.println("esta entrando");
				for (Usuarios usuario : lista) {
	
					if (usuario.getUsuario().equals(usua) && usuario.getPassword().equals(pass)) {
						request.setAttribute("usuario", usuario);
						request.getRequestDispatcher("/adminMenu.jsp").forward(request, response);
						respuesta = 1;
					}
	
				}

				if (respuesta == 0) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					System.out.println("No se encontraron datos");
				}
			}else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				System.out.println("Campos vacios");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println("accion igual a: " + accion);
		if (accion.equals("Ingresar")) {
			System.out.println("Esta ingresando ");
			this.validarUsuarios(request, response);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

}
