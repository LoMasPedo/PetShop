package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null,"error al insertar Productos: "+ex);
			//System.out.println("Error al insertar productos"+ex);
		}
		return resul;
		
	}
	

	public boolean Actualizar_Producto(ProductoDTO prod) {
	    boolean resul=false;
		try {
		String sql="update productos set ivacompra=?, nitproveedor=?, nombre_producto=?, precio_compra=?, precio_venta=? where codigo_producto=?";
		ps = con.prepareStatement(sql);
		ps.setDouble(1, prod.getIvaCompra());
		ps.setLong(2, prod.getNitProveedor());
		ps.setString(3, prod.getNombreProducto());
		ps.setDouble(4, prod.getPrecioCompra());
		ps.setDouble(5, prod.getPrecioVenta());
		ps.setLong(6, prod.getCodigoProducto());
		resul=ps.executeUpdate()>0;	
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al actualizar: "+ex);
		}
		return resul;
	}
	
	
	public ProductoDTO Consultar_Producto(Long codigo_Producto) {
		
		ProductoDTO prod= null;
		try {
		String sql="select * from productos where codigo_producto=?";			
		ps=con.prepareStatement(sql);
		ps.setLong(1, codigo_Producto);
		res=ps.executeQuery();
		while(res.next()) {
			prod = new ProductoDTO(res.getLong(1),res.getDouble(2),res.getLong(3),res.getString(4),res.getDouble(5),res.getDouble(6));
		}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al consultar" +e);
			//System.out.println("Error al consultar" +e);

		}
	
		return prod;
	}
}
