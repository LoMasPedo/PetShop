package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ReporteVentasDTO;
import Modelo.VentasDAO;

/**
 * Servlet implementation class ReportesClientes
 */
@WebServlet("/ReportesVentas")
public class ReportesVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportesVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("opcion");
		System.out.println("opcion de reporte: " + op);

		PrintWriter salida = response.getWriter();
		Gson datos = new Gson();

			
			if (op.equals("Ventas")) {
				try {
					VentasDAO ventasDao = new VentasDAO();
					ArrayList<ReporteVentasDTO> lista = new ArrayList<>();
					lista = ventasDao.ListaVentas();
					salida.println(datos.toJson(lista));
				} catch (Exception e) {
					System.out.println("Error al generar el reporte de Ventas" + e);	
				}
			}
	}

}