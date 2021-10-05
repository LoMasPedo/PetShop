package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class ReportesClientes
 */
@WebServlet("/ReportesClientes")
public class ReportesClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportesClientes() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("opcion");
		JOptionPane.showMessageDialog(null, op);
		//System.out.println("error");
		// String men=request.getParameter("mensaje");
		// JOptionPane.showMessageDialog(null, men);

		PrintWriter salida = response.getWriter();
		Gson datos = new Gson();

		if (op.equals("Clientes")) {
			try {
				JOptionPane.showMessageDialog(null, "mensaje");
				ClienteDAO clienDao = new ClienteDAO();
				ArrayList<ClienteDTO> lista = new ArrayList<>();
				lista = clienDao.Listar_Cliente();
				salida.println(datos.toJson(lista));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al cargar Archivo" + e);
			}
		}
	}

}