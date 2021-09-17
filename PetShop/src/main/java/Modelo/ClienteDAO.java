package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ClienteDAO {

	Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Insertar_Cliente(ClienteDTO clien) {
	    boolean resul=false;
		try {
		String sql="insert into cliente values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setLong(1, clien.getCedula_cliente());
		ps.setString(2, clien.getDireccion_cliente());
		ps.setString(3, clien.getEmail_cliente());
		ps.setString(4, clien.getNombre_cliente());
		ps.setString(5, clien.getTelefono_cliente());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al insertar cliente: "+ex);
		}
		return resul;
	}
}
