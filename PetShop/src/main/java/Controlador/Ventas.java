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
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//BOTON DE CALCULAR 
		if(request.getParameter("calcular")!=null) {
			
			double TotalVenta,TotalIva,TotalConIva,Iva1,Iva2,Iva3,Precio1,Precio2,Precio3,
			Costo1,Costo2,Costo3;
			int Cantidad1,Cantidad2,Cantidad3;
			Long codigoProducto1,codigoProducto2,codigoProducto3;
			
			Cantidad1=Integer.parseInt(request.getParameter("cantidadp1"));
			Cantidad2=Integer.parseInt(request.getParameter("cantidadp2"));
			Cantidad3=Integer.parseInt(request.getParameter("cantidadp3"));
						
			codigoProducto1=Long.parseLong(request.getParameter("codP1"));
			codigoProducto2=Long.parseLong(request.getParameter("codP2"));
			codigoProducto3=Long.parseLong(request.getParameter("codP3"));
			
			ProductoDAO conexionProducto=new ProductoDAO();
			ProductoDTO Pro1DTO=conexionProducto.Consultar_Producto(codigoProducto1);
			Iva1= Pro1DTO.getIvaCompra();
			Precio1=Pro1DTO.getPrecioVenta();
			
			ProductoDTO Pro2DTO=conexionProducto.Consultar_Producto(codigoProducto2);
			Iva2= Pro2DTO.getIvaCompra();
			Precio2=Pro2DTO.getPrecioVenta();
			
			ProductoDTO Pro3DTO=conexionProducto.Consultar_Producto(codigoProducto3);
			Iva3= Pro3DTO.getIvaCompra();
			Precio3=Pro3DTO.getPrecioVenta();
			
			Costo1=Cantidad1*Precio1;
			Costo2=Cantidad2*Precio2;
			Costo3=Cantidad3*Precio3;
					
			TotalVenta= Costo1+Costo2+Costo3;
			TotalIva=(Costo1*Iva1)+(Costo2*Iva2)+(Costo3*Iva3);
			TotalConIva=TotalVenta+TotalIva;
			
			response.sendRedirect("Ventas.jsp?vlrt1="+Costo1+"&&vlrt2="+Costo2
					+"&&vlrt3="+Costo3+"&&totalventa="+ TotalVenta 
					+"&&totaliva="+TotalIva+"&&totalconiva="+TotalConIva
					+"&&cantidadp1="+Cantidad1+"&&cantidadp2="+Cantidad2+"&&cantidadp3="+Cantidad3);
			
		}
		
		
		
		//BOTON DE CONSULTA USUARIO
		if(request.getParameter("consultar_usuario")!=null) {
			Long cedulaUsuario; 
			String nombreUsuario;
			
			UsuarioDAO conexionUsuario= new UsuarioDAO();
			
			cedulaUsuario=Long.parseLong(request.getParameter("cedula_usuario"));
			UsuarioDTO user=conexionUsuario.Buscar_Usuario(cedulaUsuario);
			if(user!=null) {
				
				//cedulaCliente=clien.getCedula_cliente();
				//emailCliente = clien.getEmail_cliente();
				nombreUsuario = user.getNombre_usuario();
				//telefonoCliente = clien.getTelefono_cliente();
				
				response.sendRedirect("Ventas.jsp?cedula_usuario="+cedulaUsuario+"&&nombre_usuario="+
						URLEncoder.encode(nombreUsuario, StandardCharsets.UTF_8));
					
			}else
					{
					JOptionPane.showMessageDialog(null, "Usuario no existe.");
					response.sendRedirect("Ventas.jsp?men=Usuario no existe.");
					}
			}
		
		
		
		//BOTON DE CONSULTA CLIENTE
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
				
				response.sendRedirect("Ventas.jsp?cedula_cliente="+cedulaCliente+"&&nombre_cliente="+
						URLEncoder.encode(nombreCliente, StandardCharsets.UTF_8));
					
			}else
					{
					JOptionPane.showMessageDialog(null, "Cliente no existe.");
					response.sendRedirect("Ventas.jsp?men=Cliente no existe.");
					}
			}
		
		
		
		
		//BOTON DE CONSULTA PRODUCTO 1
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
				
				response.sendRedirect("Ventas.jsp?codP1="+codigoProducto+"&&nomP1="+nombreProducto+"&&vlru1="+precioVenta);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Producto no existe.");
				response.sendRedirect("Ventas.jsp?men=Producto no existe.");
			}
		}
		
		
		
		//BOTON DE CONSULTA PRODUCTO 1
		if(request.getParameter("consultar_p2")!=null)
		{
			String nombreProducto;
			double precioVenta;
			long codigoProducto;
			
			ProductoDAO conexionProducto=new ProductoDAO();
			
			codigoProducto=Long.parseLong(request.getParameter("codP2"));
			ProductoDTO ProDTO=conexionProducto.Consultar_Producto(codigoProducto);
			
			if(ProDTO!=null)
			{	
				//codigoProducto=ProDTO.getCodigoProducto();
				//ivaCompra = ProDTO.getIvaCompra();
				nombreProducto = ProDTO.getNombreProducto();
				precioVenta = ProDTO.getPrecioVenta();
				
				response.sendRedirect("Ventas.jsp?codP2="+codigoProducto+"&&nomP2="
				+nombreProducto+"&&vlru2="+precioVenta);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Producto no existe.");
				response.sendRedirect("Ventas.jsp?men=Producto no existe.");
			}
		}
		
		
		
		//BOTON DE CONSULTA PRODUCTO 1
		if(request.getParameter("consultar_p3")!=null)
		{
			String nombreProducto;
			double precioVenta;
			long codigoProducto;
			
			ProductoDAO conexionProducto=new ProductoDAO();
			
			codigoProducto=Long.parseLong(request.getParameter("codP3"));
			ProductoDTO ProDTO=conexionProducto.Consultar_Producto(codigoProducto);
			
			if(ProDTO!=null)
			{	
				//codigoProducto=ProDTO.getCodigoProducto();
				//ivaCompra = ProDTO.getIvaCompra();
				nombreProducto = ProDTO.getNombreProducto();
				precioVenta = ProDTO.getPrecioVenta();
				
				response.sendRedirect("Ventas.jsp?codP3="+codigoProducto+"&&nomP3="
				+nombreProducto+"&&vlru3="+precioVenta);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Producto no existe.");
				response.sendRedirect("Ventas.jsp?men=Producto no existe.");
			}
		}
		
		
		
		//BOTON DE CONFIRMAR, ENVIAR TODO AL CONTROLADOR VentasDTO, PARA POSTERIORMENTE 
		//SUBIR TODO A LA BASE DE DATOS POR MEDIO DEL DAO
		if(request.getParameter("confirmar")!=null) {

				try {
				double cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
				double cedulaUsuario=Long.parseLong(request.getParameter("cedula_usuario"));
				Long codigoProducto1=Long.parseLong(request.getParameter("codP1"));
				Long codigoProducto2=Long.parseLong(request.getParameter("codP2"));
				Long codigoProducto3=Long.parseLong(request.getParameter("codP3"));
				int Cantidad1=Integer.parseInt(request.getParameter("cantidadp1"));
				int Cantidad2=Integer.parseInt(request.getParameter("cantidadp2"));
				int Cantidad3=Integer.parseInt(request.getParameter("cantidadp3"));
				
				ProductoDAO conexionProducto=new ProductoDAO();
				ProductoDTO Pro1DTO=conexionProducto.Consultar_Producto(codigoProducto1);
				double Iva1= Pro1DTO.getIvaCompra();
				double Precio1=Pro1DTO.getPrecioVenta();
				
				ProductoDTO Pro2DTO=conexionProducto.Consultar_Producto(codigoProducto2);
				double Iva2= Pro2DTO.getIvaCompra();
				double Precio2=Pro2DTO.getPrecioVenta();
				
				ProductoDTO Pro3DTO=conexionProducto.Consultar_Producto(codigoProducto3);
				double Iva3= Pro3DTO.getIvaCompra();
				double Precio3=Pro3DTO.getPrecioVenta();
				
				double Costo1=Cantidad1*Precio1;
				double Costo2=Cantidad2*Precio2;
				double Costo3=Cantidad3*Precio3;
						
				double TotalVenta= Costo1+Costo2+Costo3;
				double TotalIva=(Costo1*Iva1)+(Costo2*Iva2)+(Costo3*Iva3);
				double TotalConIva=TotalVenta+TotalIva;
				
				
				VentasDTO ven = new VentasDTO(codigoProducto1,codigoProducto2,codigoProducto3,
						cedulaCliente,cedulaUsuario,TotalIva,TotalVenta,TotalConIva,
						Precio1,Precio2,Precio3,Iva1,Iva2,Iva3,Costo1,Costo2,Costo3,Cantidad1,Cantidad2,Cantidad3);
				
				VentasDAO vDAO = new VentasDAO();
				vDAO.Confirmar(ven);
				int cventa=vDAO.consecutivo();
				//esto deberia llamarse en el DAO, no en este archivo
				//String sql= "select max(codigo_venta) from petshop_db.ventas";
				//ps=con.prepareStatement(sql);
				//res=ps.executeQuery();
				//int cventa=0;
				//while(res.next()) {
					//cventa = res.getInt(1);
				//}
				
				JOptionPane.showMessageDialog(null, "Factura registrada exitosamente");
				response.sendRedirect("Ventas.jsp?men=Factura registrada exitosamente"+"&&consec="+cventa);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Factura no registrada");
				response.sendRedirect("Ventas.jsp?men=Factura no registrada");
		}
			
		
	}
	}
}
