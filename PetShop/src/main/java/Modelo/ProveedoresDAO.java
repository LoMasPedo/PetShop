package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controlador.Conexion;

public class ProveedoresDAO {
	
	Conexion   cnn= new Conexion();
	Connection con= cnn.Conectar();
	
	PreparedStatement ps= null;
	ResultSet res= null;
	
	public boolean Insertar_Provedores(ProveedoresDTO usua) {
	    boolean resul=false;
		try {
		String sql="insert into proveedores values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setLong(1, usua.getNitProveedor());
		ps.setString(2, usua.getCiudad_Proveedor());
		ps.setString(3, usua.getDireccion_Proveedor());
		ps.setString(4, usua.getNombre_Proveedor());
		ps.setString(5, usua.getTelefono_Proveedor());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"Error al insertar usuario: "+ex);
			System.out.println("error al insertar"+ex);
		}
		return resul;
	}
	
	public boolean Actualizar_Proveedores(ProveedoresDTO lib) {
	    boolean resul=false;
		try {
		String sql="update proveedores set ciudad_proveedor, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nitproveedor=?";
		ps = con.prepareStatement(sql);
		ps.setString(1, lib.getCiudad_Proveedor());
		ps.setString(2, lib.getDireccion_Proveedor());
		ps.setString(3, lib.getNombre_Proveedor());
		ps.setString(4, lib.getTelefono_Proveedor());
		ps.setLong(5, lib.getNitProveedor());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
			System.out.println("error actualizar"+ ex);
		}
		return resul;
	}

	public boolean Eliminar_Proveedores(Long Nit_Proveedor) {
	    boolean resul=false;
		try {
		String sql="delete from proveedores where nitproveedor=?";
		ps = con.prepareStatement(sql);
		ps.setLong(1, Nit_Proveedor);
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			//JOptionPane.showMessageDialog(null,"error al eliminar Usuario: "+ex);
			System.out.println("error a eliminar usuario"+ex);
		}
		return resul;
	}	
	
	
	public ProveedoresDTO Buscar_Proveedores(Long Nit_Proveedor) {
		
		ProveedoresDTO lib= null;
		try {
		String sql="select nitproveedor,ciudad_proveedor,direccion_proveedor,nombre_proveedor from usuarios where Nit_Proveedor=?";	
		ps=con.prepareStatement(sql);
		ps.setLong(1, Nit_Proveedor);
		res=ps.executeQuery();
		while(res.next()) {
			lib = new ProveedoresDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
		}
		}catch(SQLException e) {
			//JOptionPane.showMessageDialog(null,"Error al consultar" +e);
			System.out.println("Error al consultar" +e);

		}
	
		return lib;
	}
	
}