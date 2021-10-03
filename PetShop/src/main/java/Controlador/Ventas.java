package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import Modelo.ClienteDTO;
import Modelo.ClienteDAO;
import Modelo.ProductoDTO;
import Modelo.ProductoDAO;
import Modelo.ProveedoresDAO;
import Modelo.ProveedoresDTO;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//import Modelo.VentasDAO;
//import Modelo.VentasDTO;
/**
 * Servlet implementation class Ventas
 */
@WebServlet("/Ventas")
public class Ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ventas() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
		if(request.getParameter("consultar_cliente")!=null) {
			Long cedulaCliente; 
			String nombreCliente;
			String consec = "10";
			
			ClienteDAO conexionClientes= new ClienteDAO();
			
			cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
			ClienteDTO clien=conexionClientes.Buscar_Cliente(cedulaCliente);
			if(clien!=null) {
				
				//cedulaCliente=clien.getCedula_cliente();
				//emailCliente = clien.getEmail_cliente();
				nombreCliente = clien.getNombre_cliente();
				//telefonoCliente = clien.getTelefono_cliente();
				
				response.sendRedirect("Ventas.jsp?cedula_cliente="+cedulaCliente+"&&consec="+
				URLEncoder.encode(consec, StandardCharsets.UTF_8)+"&&nombre_cliente="+
						URLEncoder.encode(nombreCliente, StandardCharsets.UTF_8));
					
			}else
					{
					response.sendRedirect("Ventas.jsp?men=Cliente no existe.");
					}
			}
		
		if(request.getParameter("consultar_p1")!=null)
		{
			String nombreProducto;
			double precioVenta;
			long codigoProducto;
			
			ProductoDAO conexionProducto=new ProductoDAO();
			
			codigoProducto=Long.parseLong(request.getParameter("codP1"));
			ProductoDTO ProDTO=conexionProducto.Consultar_Producto(codigoProducto);
			
			if(ProDTO!=null)
			{	
				//codigoProducto=ProDTO.getCodigoProducto();
				//ivaCompra = ProDTO.getIvaCompra();
				nombreProducto = ProDTO.getNombreProducto();
				precioVenta = ProDTO.getPrecioVenta();
				
				response.sendRedirect("Ventas.jsp?nomP1="+nombreProducto+"&&vlrt1="+precioVenta);
			}
			else
			{
				response.sendRedirect("Ventas.jsp?men=Producto no existe.");
			}
		}
		
		/*
		if(request.getParameter("consultar_p2")!=null)
		{
			String nombreProducto;
			double precioVenta;
			long codigoProducto;
			
			ProductoDAO conexionProducto=new ProductoDAO();
			
			codigoProducto=Long.parseLong(request.getParameter("codP"));
			ProductoDTO ProDTO=conexionProducto.Consultar_Producto(codigoProducto);
			
			if(ProDTO!=null)
			{	
				//codigoProducto=ProDTO.getCodigoProducto();
				//ivaCompra = ProDTO.getIvaCompra();
				nombreProducto = ProDTO.getNombreProducto();
				precioVenta = ProDTO.getPrecioVenta();
				
				//response.sendRedirect("Ventas.jsp?nomP1="+nombreProducto+"&&vlrt1="+precioVenta);
			}
			else
			{
				//response.sendRedirect("Ventas.jsp?men=Producto no existe.");
			}
		}
		
		*/
		
		
		
		
	}

}
