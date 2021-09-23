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



/**
 * Servlet implementation class Productos
 */
@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Productos() {
        super();
   
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO prodDao = new ProductoDAO();

		if(request.getParameter("cargar")!=null) {
			Part archivo=request.getPart("archivo");
			String nombre=request.getParameter("nombreArch");
			//JOptionPane.showMessageDialog(null, archivo.getSubmittedFileName());
			String Url="C:/Users/andre/Documents/GitHub/Equipo4_Grupo31/PetShop/src/main/webapp/Doc\\";
			//JOptionPane.showMessageDialog(null, Url);
			try {
			InputStream file= archivo.getInputStream();	
			File copia = new File(Url+nombre+".csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num=file.read();
			while(num != -1) {
				escribir.write(num);
				num=file.read();
			}
			escribir.close();
			file.close();
			System.out.println("se cargo exitosamente el archivo ");
			response.sendRedirect("Productos.jsp?men=Archivo cargado Exitosamente");
			//JOptionPane.showMessageDialog(null, "Archivo Cargado Correctamente");
			System.out.println("Archivo Cargado Correctamente");
			if(prodDao.Cargar_Producto(Url+nombre+".csv")) {
				System.out.println("Archivo cargado Exitosamente");
			}
			else {
				//JOptionPane.showMessageDialog(null, "Libros no se Registraron");
				System.out.println("Los productos del archivo no se cargaron");
			}
			}catch(Exception e) {
				//JOptionPane.showMessageDialog(null, "Error al cargar Archivo"+e);
				System.out.println("Error al cargar Archivo"+e);
			}
		}
		

		}
		
}


