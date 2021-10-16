package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {


	private String db= "Grupo31_Equipo_4";
	private String url="jdbc:mariadb://prestamosvf.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/"+db;
	private String user="admin";
	private String pass="Ciclo3_admi123";
	Connection conec=null;
	
	public Connection Conectar() {
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		conec=DriverManager.getConnection(url,user,pass);
		System.out.println("Conexion ok...");
			
		
	}catch(Exception e) {
		System.out.println("Error en la conexion"+e);
	}
	return conec;
	}
	
}
