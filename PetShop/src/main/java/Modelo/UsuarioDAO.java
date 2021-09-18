package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlador.Conexion;

public class UsuarioDAO {
	
	Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Insertar_Usuario(UsuarioDTO usua) {
	    boolean resul=false;
		try {
		String sql="insert into usuarios values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setLong(1, usua.getCedula_usuario());
		ps.setString(2, usua.getEmail_usuario());
		ps.setString(3, usua.getNombre_usuario());
		ps.setString(4, usua.getPassword());
		ps.setString(5, usua.getUsuario());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"Error al insertar usuario: "+ex);
			System.out.println("error al insertar"+ex);
		}
		return resul;
	}
	
	public boolean Actualizar_Usuario(UsuarioDTO lib) {
	    boolean resul=false;
		try {
		String sql="update usuarios set Email_usuario=?, Nombre_usuario=?, Password=?, Usuario=? where Cedula_usuario=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, lib.getEmail_usuario());
		ps.setString(2, lib.getNombre_usuario());
		ps.setString(3, lib.getPassword());
		ps.setString(4, lib.getUsuario());
		ps.setLong(5, lib.getCedula_usuario());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
			System.out.println("error actualizar"+ ex);
		}
		return resul;
	}

	public boolean Eliminar_Usuario(Long Cedula_usuario) {
	    boolean resul=false;
		try {
		String sql="delete from usuarios where Cedula_usuario=?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, Cedula_usuario);
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"error al eliminar Usuario: "+ex);
			System.out.println("error a eliminar usuario"+ex);
		}
		return resul;
	}	
	
	
	public UsuarioDTO Buscar_Usuario(Long Cedula_usuario) {
		
		UsuarioDTO lib= null;
		try {
		String sql="select cedula_usuario,email_usuario,nombre_usuario,password,usuario from usuarios where Cedula_usuario=?";	
		ps=con.prepareStatement(sql);
		ps.setLong(1, Cedula_usuario);
		res=ps.executeQuery();
		while(res.next()) {
			lib = new UsuarioDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
		}
		}catch(SQLException e) {
			//JOptionPane.showMessageDialog(null,"Error al consultar" +e);
			System.out.println("Error al consultar" +e);

		}
	
		return lib;
	}
	
}