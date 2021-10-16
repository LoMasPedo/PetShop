package Controlador;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ClienteDAO clienDao = new ClienteDAO();
		
		if(request.getParameter("registrar")!=null) 
		{
			
			Long cedulaCliente;
			String direccionCliente,emailCliente,nombreCliente,telefonoCliente;
				
			cedulaCliente = Long.parseLong(request.getParameter("cedula_cliente"));
			direccionCliente = request.getParameter("direccion_cliente");
			emailCliente = request.getParameter("email_cliente");
			nombreCliente = request.getParameter("nombre_cliente");
			telefonoCliente = request.getParameter("telefono_cliente");
			ClienteDTO clienDto = new ClienteDTO(cedulaCliente,direccionCliente,emailCliente,nombreCliente,telefonoCliente);
			
			if(clienDao.Insertar_Cliente(clienDto)) 
			{
				System.out.println("se registro exitosamente");
				response.sendRedirect("Clientes.jsp?men=Cliente Creado Exitosamente.");
			}
			else 
			{
				System.out.println("el cliente no se registro");
				response.sendRedirect("Clientes.jsp?men=El Cliente no se creo.");
			}
		}
		
		if(request.getParameter("consultar")!=null) {
			Long cedulaCliente; 
			String direccionCliente,emailCliente,nombreCliente,telefonoCliente;
			
			cedulaCliente=Long.parseLong(request.getParameter("cedula_cliente"));
			ClienteDTO clien=clienDao.Buscar_Cliente(cedulaCliente);
			if(clien!=null) {
				
				cedulaCliente=clien.getCedula_cliente();
				direccionCliente = clien.getDireccion_cliente();
				emailCliente = clien.getEmail_cliente();
				nombreCliente = clien.getNombre_cliente();
				telefonoCliente = clien.getTelefono_cliente();
				
				response.sendRedirect("Clientes.jsp?cedula_cliente="+cedulaCliente+"&&direccion_cliente="+URLEncoder.encode(direccionCliente, StandardCharsets.UTF_8)+"&&email_cliente="+URLEncoder.encode(emailCliente, StandardCharsets.UTF_8)
						+"&&nombre_cliente="+URLEncoder.encode(nombreCliente, StandardCharsets.UTF_8)+"&&telefono_cliente="+URLEncoder.encode(telefonoCliente, StandardCharsets.UTF_8));
		
			
			}else
				{
					response.sendRedirect("Clientes.jsp?men=Cliente no existe.");
				}
		}
	
		if(request.getParameter("actualizar")!=null) 
		{
			long cedula_cliente;
			String direccionCliente,emailCliente,nombreCliente,telefonoCliente;
			
			cedula_cliente =Long.parseLong( request.getParameter("cedula_cliente"));
			direccionCliente = request.getParameter("direccion_cliente");
			emailCliente = request.getParameter("email_cliente");
			nombreCliente = request.getParameter("nombre_cliente");
			telefonoCliente = request.getParameter("telefono_cliente");
			
			int op = 0;//JOptionPane.showConfirmDialog(null, "Desea actualizar el cliente: " + cedula_cliente,"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (op == 0) {
			
				
			ClienteDTO clienDto_Act = new ClienteDTO(cedula_cliente,direccionCliente,emailCliente,nombreCliente,telefonoCliente);
			if(clienDao.Actualizar_Cliente(clienDto_Act)) 
			{
				System.out.println("Se actualizo el cliente");
				response.sendRedirect("Clientes.jsp?men=Cliente Actualizado Exitosamente.");
			}
			   }else 	{
				   
					System.out.println("el cliente no se actualizo");
					response.sendRedirect("Clientes.jsp?men=El cliente no se Actualizo.");
				 }
			}
			
			
			if(request.getParameter("eliminar")!=null) 
			{
				long cedula_cliente;
				cedula_cliente =Long.parseLong( request.getParameter("cedula_cliente"));

				int op =0; //JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente: " + cedula_cliente,"YES_NO_OPTION", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (op == 0) {
				
					if(clienDao.Eliminar_Cliente(cedula_cliente)) 
					{
						System.out.println("Se eliminio el cliente");
						response.sendRedirect("Clientes.jsp?men=Cliente Eliminado");
					}
					else
					{
						response.sendRedirect("Clientes.jsp?men=El cliente no se elimino.");
					}
				}
				else 
				{
					System.out.println("cliente no se elimino");
					response.sendRedirect("Clientes.jsp?men=El Cliente no se elimino.");
				}
			    /*	}else {
					response.sendRedirect("Usuarios.jsp");
				}*/
			}
		}
	}
			   
				