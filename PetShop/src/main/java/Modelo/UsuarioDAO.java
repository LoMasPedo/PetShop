package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class UsuarioDAO {
	
	Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Insertar_Usuario(UsuarioDTO usua) {
	    boolean resul=false;
		try {
		String sql="insert into usuario values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setLong(1, usua.getCedula_usuario());
		ps.setString(2, usua.getEmail_usuario());
		ps.setString(3, usua.getNombre_usuario());
		ps.setString(4, usua.getPassword());
		ps.setString(5, usua.getUsuario());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al insertar usuario: "+ex);
		}
		return resul;
	}
}