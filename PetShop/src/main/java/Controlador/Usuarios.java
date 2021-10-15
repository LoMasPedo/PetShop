package Controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentasDAO;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		if (request.getParameter("registrar") != null) {
			long Cedula_usuario;
			String Email_usuario, Password, Usuario, Nombre_usuario;
			Cedula_usuario = Long.parseLong(request.getParameter("Cedula_usuario"));
			Email_usuario = request.getParameter("Email_usuario");
			Nombre_usuario = request.getParameter("Nombre_usuario");
			Password = request.getParameter("Password");
			Usuario = request.getParameter("Usuario");
			
			UsuarioDTO usuarioDTO = new UsuarioDTO(Cedula_usuario, Email_usuario, Nombre_usuario, Password, Usuario);
			
			if (usuarioDao.Insertar_Usuario(usuarioDTO)) {
				JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
				System.out.println("se registro exitosamente");
				response.sendRedirect("Usuarios.jsp?men=Usuario Registrado Exitosamente");

			} else {
				JOptionPane.showMessageDialog(null, "El Usuario no se registro");
				System.out.println("no se registro");
				response.sendRedirect("Usuarios.jsp?men=Usuario no se Registro");
			}
		}

		if (request.getParameter("consultar") != null) {
			long Cedula_usuario;
			String Email_usuario, Password, Usuario, Nombre_usuario;
			Cedula_usuario = Long.parseLong(request.getParameter("Cedula_usuario"));
			UsuarioDTO lib = usuarioDao.Buscar_Usuario(Cedula_usuario);
			if (lib != null) {
				Cedula_usuario = lib.getCedula_usuario();
				Email_usuario = lib.getEmail_usuario();
				Nombre_usuario = lib.getNombre_usuario();
				Password = lib.getPassword();
				Usuario = lib.getUsuario();
				response.sendRedirect("Usuarios.jsp?Cedula_usuario=" + Cedula_usuario + "&&Email_usuario="
						+ Email_usuario + "&&Nombre_usuario=" + Nombre_usuario + "&&Password=" + Password
						+ "&&Usuarios=" + Usuario);
			} else {
				response.sendRedirect("Usuarios.jsp?men=El Usuario no existe");
			}
			
			
		}

		if (request.getParameter("actualizar") != null) {
			long Cedula_usuario;
			Cedula_usuario = Long.parseLong(request.getParameter("Cedula_usuario"));
			String Email_usuario, Password, Usuario, Nombre_usuario;
			Email_usuario = request.getParameter("Email_usuario");
			Nombre_usuario = request.getParameter("Nombre_usuario");
			Password = request.getParameter("Password");
			Usuario = request.getParameter("Usuario");

			
			int op = JOptionPane.showConfirmDialog(null, "Desea Actualizar el usuario: " + Cedula_usuario,
					"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (op == 0) {
			
			
			UsuarioDTO libDto_Act = new UsuarioDTO(Cedula_usuario, Email_usuario, Nombre_usuario, Password, Usuario);
			if (usuarioDao.Actualizar_Usuario(libDto_Act)) {
				JOptionPane.showMessageDialog(null, "El Usuario Actualizo Exitosamente.");
				System.out.println("se actualizo el usuario");
				response.sendRedirect("Usuarios.jsp?men=Usuario Actualizado Exitosamente.");
						} 
				}else {
				JOptionPane.showMessageDialog(null, "El Usuario no se Actualizo.");
				//System.out.println("el usuario no se actualizo");
				response.sendRedirect("Usuarios.jsp?men=El Usuario no se Actualizo.");
			}
		}

		if (request.getParameter("eliminar") != null) 
		{
			long Cedula_usuario;
			Cedula_usuario = Long.parseLong(request.getParameter("Cedula_usuario"));
			int op = JOptionPane.showConfirmDialog(null, "Desea Eliminar el usuario: " + Cedula_usuario,
					"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (op == 0)
			{
				if (usuarioDao.Eliminar_Usuario(Cedula_usuario)) 
				{
					JOptionPane.showMessageDialog(null, "Usuario Eliminado.");
					response.sendRedirect("Usuarios.jsp?men=Usuario Eliminado");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El Usuario no se puede eliminar, verifique si ya tiene ventas.");
					response.sendRedirect("Usuarios.jsp?men=El Usuario no se elimino.");
				}
			}
			else 
			{
				response.sendRedirect("Usuarios.jsp?men=El Usuario no se elimino.");
				/*
				 * }else { response.sendRedirect("Usuarios.jsp"); }
				 */
			}
		}

	}
}
