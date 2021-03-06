package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Modelo.ProductoDAO;
import Modelo.ProductoDTO;


/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Productos() 
    {
        super();   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		ProductoDAO prodDao = new ProductoDAO();

		if(request.getParameter("cargar")!=null) 
		{
			Part archivo=request.getPart("archivo");
			String nombre=request.getParameter("nombreArch");
			String Url="C:/Users/franc/Documents/GitHub/Equipo4_Grupo31/PetShop/src/main/webapp/Doc/";
			//String Url="C:/Users/andre/Documents/GitHub/Equipo4_Grupo31/PetShop/src/main/webapp/Doc/";
			//String Url="C:/Users/yenny/OneDrive/Documents/GitHub/Equipo4_Grupo31/PetShop/src/main/webapp/Doc";
			
			try 
			{
				InputStream file= archivo.getInputStream();	
				File copia = new File(Url+nombre+".csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while(num != -1) 
				{
					escribir.write(num);
					num=file.read();
				}
				escribir.close();
				file.close();
				
				//System.out.println("Se cargo exitosamente el archivo");
				//response.sendRedirect("Productos.jsp?men=Archivo cargado Exitosamente");

				if(prodDao.Cargar_Producto(Url+nombre+".csv")) 
				{
					System.out.println("Archivo cargado Exitosamente");
					response.sendRedirect("Productos.jsp?men2=Archivo cargado Exitosamente");
				}
				else 
				{
					System.out.println("Los productos del archivo no se cargaron");
				}
			}
			catch(Exception e) 
			{
				System.out.println("Error al cargar Archivo"+e);
			}
		}		

		if(request.getParameter("actualizar")!=null) 
		{
			String nombreProducto;
			Double ivaCompra, precioCompra, precioVenta;
			long codigoProducto, nitProveedor;
			
			codigoProducto =Long.parseLong(request.getParameter("codP"));
			ProductoDTO prod = prodDao.Consultar_Producto(codigoProducto);		
			
			ivaCompra =Double.parseDouble(request.getParameter("IvaC"));
			nitProveedor =prod.getNitProveedor();
			nombreProducto = request.getParameter("NomC");
			precioCompra =Double.parseDouble(request.getParameter("PreC"));
			precioVenta =prod.getPrecioVenta();
			
			ProductoDTO prodDto_Act = new ProductoDTO(codigoProducto,ivaCompra, nitProveedor,nombreProducto, precioCompra,precioVenta);
			
			if(prodDao.Actualizar_Producto(prodDto_Act))
			{
				response.sendRedirect("Productos.jsp?men=Producto Actualizado Exitosamente.");
			}
			else 
			{
				response.sendRedirect("Productos.jsp?men=El Producto no se Modifico.");
			}
		}
	
		if(request.getParameter("consultar")!=null)
		{
			String nombreProducto;
			double ivaCompra, precioCompra; //precioVenta;
			long codigoProducto; //nitProveedor;
			
			codigoProducto=Long.parseLong(request.getParameter("codP"));
			ProductoDTO ProDTO=prodDao.Consultar_Producto(codigoProducto);
			
			if(ProDTO!=null)
			{	
				codigoProducto=ProDTO.getCodigoProducto();
				ivaCompra = ProDTO.getIvaCompra();
				//nitProveedor = ProDTO.getNitProveedor();
				nombreProducto = ProDTO.getNombreProducto();
				precioCompra = ProDTO.getPrecioCompra();
				//precioVenta = ProDTO.getPrecioVenta();
				
				response.sendRedirect("Productos.jsp?codP="+codigoProducto+"&&IvaC="+ivaCompra+"&&NomC="+nombreProducto+"&&PreC="+precioCompra);
			}
			else
			{
				response.sendRedirect("Productos.jsp?men=Producto no existe.");
			}
		}
	}
}


