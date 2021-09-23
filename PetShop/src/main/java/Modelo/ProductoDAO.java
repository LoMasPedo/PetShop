package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controlador.Conexion;

public class ProductoDAO {
	
	Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Cargar_Producto(String Url) {
		boolean resul=false;
		
		try {
		String sql="load data infile '"+Url+"' into table productos fields terminated by ',' lines terminated by '\r\n'";
		ps = con.prepareStatement(sql);
		//ps.setString(1, Url);
		resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"error al insertar Productos: "+ex);
			System.out.println("Error al insertar productos"+ex);
		}
		return resul;
		
	}
	

}
