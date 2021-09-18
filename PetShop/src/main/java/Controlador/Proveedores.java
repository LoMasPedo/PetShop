package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ProveedoresDAO;
import Modelo.ProveedoresDTO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Proveedores
 */
@WebServlet("/Proveedores")
public class Proveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proveedores() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedoresDAO proveedoresDAO= new ProveedoresDAO();
		if(request.getParameter("registrar")!=null){
		long Nit_Proveedor;	
		String Ciudad_Proveedor,Direccion_Proveedor,Nombre_Proveedor,Telefono_Proveedor;
		Nit_Proveedor =Long.parseLong( request.getParameter("Nit_Proveedor"));
		Ciudad_Proveedor = request.getParameter("Ciudad_Proveedor");
		Direccion_Proveedor = request.getParameter("Direccion_Proveedor");
		Nombre_Proveedor = request.getParameter("Nombre_Proveedor");
		Telefono_Proveedor = request.getParameter("Telefono_Proveedor");
		ProveedoresDTO proveedoresDTO = new ProveedoresDTO (Nit_Proveedor, Ciudad_Proveedor, Direccion_Proveedor, Nombre_Proveedor, Telefono_Proveedor);
		
		if(proveedoresDAO.Insertar_Provedores(proveedoresDTO)) {
			//JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
			System.out.println("se registro exitosamente");
			response.sendRedirect("Proveedores.jsp?men=Proveedor Registrado Exitosamente");
			
		}else {
			//JOptionPane.showMessageDialog(null, "El Usuario no se registro");
			System.out.println("no se registro");
			response.sendRedirect("Proveedores.jsp?men=Proveedor Registrado Exitosamente");
		}
	}
		
		
		
		if(request.getParameter("consultar")!=null) {
			long Nit_Proveedor;	
			String Ciudad_Proveedor,Direccion_Proveedor,Nombre_Proveedor,Telefono_Proveedor;
			Nit_Proveedor =Long.parseLong( request.getParameter("Nit_Proveedor"));
			ProveedoresDTO lib=proveedoresDAO.Buscar_Proveedores(Nit_Proveedor);
			if(lib!=null) {
			Nit_Proveedor=lib.getNitProveedor();
			Ciudad_Proveedor= lib.getCiudad_Proveedor();
			Direccion_Proveedor = lib.getDireccion_Proveedor();
			Nombre_Proveedor = lib.getNombre_Proveedor();
			Telefono_Proveedor = lib.getTelefono_Proveedor();
			response.sendRedirect("Proveedores.jsp?Nit_Proveedor="+Nit_Proveedor+"&&Ciudad_Proveedor="+Ciudad_Proveedor+"&&Direccion_Proveedor="
			+Direccion_Proveedor+"&&Nombre_Proveedor="+Nombre_Proveedor+"&&Telefono_Proveedor="+Telefono_Proveedor);
			}else
			{
				response.sendRedirect("Proveedores.jsp?men=El proveedor no existe");
			}
		}
		
		
		
		if(request.getParameter("actualizar")!=null) {
			long Nit_Proveedor;
			Nit_Proveedor =Long.parseLong( request.getParameter("Nit_Proveedor"));
			String Ciudad_Proveedor,Direccion_Proveedor,Nombre_Proveedor,Telefono_Proveedor;
			Ciudad_Proveedor = request.getParameter("Ciudad_Proveedor");
			Direccion_Proveedor = request.getParameter("Direccion_Proveedor");
			Nombre_Proveedor = request.getParameter("Nombre_Proveedor");
			Telefono_Proveedor = request.getParameter("Telefono_Proveedor");
			
			ProveedoresDTO libDto_Act = new ProveedoresDTO (Nit_Proveedor, Ciudad_Proveedor, Direccion_Proveedor, Nombre_Proveedor, Telefono_Proveedor);
			if(proveedoresDAO.Actualizar_Proveedores(libDto_Act)) {
				//JOptionPane.showMessageDialog(null, "El Usuario Actualizo Exitosamente.");
				System.out.println("se actualizo el proveedor");
				response.sendRedirect("Proveedores.jsp?men=Proveedor Actualizado Exitosamente.");
			}else {
				//JOptionPane.showMessageDialog(null, "El Usuario no se Modifico.");
				System.out.println("el proveedor no se actualizo");
				response.sendRedirect("Proveedores.jsp?men=El proveedor no se Modifico.");
			}
			}
		
		if(request.getParameter("eliminar")!=null) {
			long Nit_Proveedor;
			Nit_Proveedor =Long.parseLong( request.getParameter("Nit_Proveedor"));
			//int op=JOptionPane.showConfirmDialog(null, "Desea Eliminar el Usuario digitado:" + Cedula_usuario );
			//if(op==0) {
			if(proveedoresDAO.Eliminar_Proveedores(Nit_Proveedor)) {
				System.out.println("se eliminio el proveedor");
				response.sendRedirect("Proveedores.jsp?men=Proveedor Eliminado");
			}else {
				System.out.println("Proveedor no se elimino");
				response.sendRedirect("Proveedores.jsp?men=El proveedor no se elimino.");
			}
		    /*	}else {
				response.sendRedirect("Usuarios.jsp");
			}*/
					
		}
	}
		
}
