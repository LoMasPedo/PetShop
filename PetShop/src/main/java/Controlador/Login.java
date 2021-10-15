package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario,password;
		if(request.getParameter("enviar")!=null) {
			usuario=request.getParameter("user");
			password=request.getParameter("pass");
			
			if(usuario.equals("admininicial")&& password.equals("admin123456")) {
				response.sendRedirect("index.jsp?nom="+usuario);
			
			}else {
				JOptionPane.showMessageDialog(null,"Usuario o Password Errado");
				response.sendRedirect("login.jsp");
			}
			
		}else {
			response.sendRedirect("login.jsp");
			}
		
	}

}
