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
	
	public boolean Insertar_Cliente(ClienteDTO clien) 
	{
	    boolean resul=false;
		try 
		{
			String sql="insert into clientes values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, clien.getCedula_cliente());
			ps.setString(2, clien.getDireccion_cliente());
			ps.setString(3, clien.getEmail_cliente());
			ps.setString(4, clien.getNombre_cliente());
			ps.setString(5, clien.getTelefono_cliente());
			resul=ps.executeUpdate()>0;	
		}
		catch(SQLException ex) 
		{
			//JOptionPane.showMessageDialog(null,"Error al insertar cliente: "+ex);
			System.out.println("error al insertar cliente"+ex);
		}
		return resul;
	}
	
	public ClienteDTO Buscar_Cliente(Long cedulaCliente) 
	{
			ClienteDTO clien= null;
		try 
		{
			String sql="select * from clientes where cedula_cliente=?";	
			ps=con.prepareStatement(sql);
			ps.setLong(1, cedulaCliente);
			res=ps.executeQuery();
			while(res.next()) 
			{
				clien = new ClienteDTO(res.getLong(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
			}
		}
		catch(SQLException e) 
		{
			//JOptionPane.showMessageDialog(null,"Error al consultar" +e);
			System.out.println("error al consultar"+e);
		}
	
		return clien;
	}

	public boolean Actualizar_Cliente(ClienteDTO clien) 
	{
	    boolean resul=false;
		try 
		{
			String sql="update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, clien.getDireccion_cliente());
			ps.setString(2, clien.getEmail_cliente());
			ps.setString(3, clien.getNombre_cliente());
			ps.setString(4, clien.getTelefono_cliente());
			ps.setLong(5, clien.getCedula_cliente());
			resul=ps.executeUpdate()>0;	
		}
		catch(SQLException ex) 
		{
			//JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
			System.out.println("error actualizar"+ ex);
		}
		return resul;
	}

	public boolean Eliminar_Cliente(Long cedula_cliente) 
	{
	    boolean resul=false;
		try 
		{
			String sql="delete from clientes where cedula_cliente=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, cedula_cliente);
			resul=ps.executeUpdate()>0;	
		}
		catch(SQLException ex) 
		{
			//JOptionPane.showMessageDialog(null,"error al eliminar Usuario: "+ex);
			System.out.println("error a eliminar usuario"+ex);
		}
		return resul;
	}	

}
