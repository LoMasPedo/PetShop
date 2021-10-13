package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentasDAO {
	
	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res=null;
	
	
	
	public boolean Confirmar(VentasDTO p) {
		
		boolean resul=false;
		int cventa;
		try {
			
			String sql="insert into ventas(cedula_cliente, cedula_usuario, ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, p.getCedulaCliente());
			ps.setDouble(2, p.getCedulaUsuario());
			ps.setDouble(3, p.getIvaVenta());
			ps.setDouble(4, p.getTotalVenta());
			ps.setDouble(5, p.getValorVenta());
			resul=ps.executeUpdate()>0; 
			
			System.out.println("Inserto venta correctamente");
			
			if(resul) {
				sql= "select max(codigo_venta) from petshop_db.ventas";
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				cventa=0;
				while(res.next()) {
					cventa = res.getInt(1);
				}
				
				sql="insert into detalle_ventas(cantidad_producto, codigo_producto, codigo_venta,valor_total,valor_venta,valoriva) values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidadP1());
				ps.setLong(2, p.getCodigoProducto1());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto1());
				ps.setDouble(5, p.getValor_VentaDet1());
				ps.setDouble(6, p.getIvaProducto1());
				resul=ps.executeUpdate()>0; 
				
				sql="insert into detalle_ventas(cantidad_producto, codigo_producto, codigo_venta,valor_total,valor_venta,valoriva) values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidadP2());
				ps.setLong(2, p.getCodigoProducto2());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto2());
				ps.setDouble(5, p.getValor_VentaDet2());
				ps.setDouble(6, p.getIvaProducto2());
				resul=ps.executeUpdate()>0;
				
				sql="insert into detalle_ventas(cantidad_producto, codigo_producto, codigo_venta,valor_total,valor_venta,valoriva) values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setFloat(1, p.getCantidadP3());
				ps.setLong(2, p.getCodigoProducto3());
				ps.setLong(3, cventa);
				ps.setDouble(4, p.getValorProducto3());
				ps.setDouble(5, p.getValor_VentaDet3());
				ps.setDouble(6, p.getIvaProducto3());
				resul=ps.executeUpdate()>0;
				System.out.println("Inserto detalle de venta correctamente");
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al confirmar: "+ex);
		}
		return resul;
	}
	
	
	public int consecutivo () {
		int cventa=0;
		try {
			String sql= "select max(codigo_venta) from petshop_db.ventas";
			ps=con.prepareStatement(sql);
			res=ps.executeQuery();
			
			while(res.next()) {
				cventa = res.getInt(1);
			}
			
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al confirmar: "+ex);
			}
		return cventa;
	}
	
	public ArrayList<ReporteVentasDTO> ListaVentas(){
		ReporteVentasDTO venta= null;
		ArrayList<ReporteVentasDTO> lista= new ArrayList<>();
			try 
			{
				String sql="select v.cedula_cliente,sum(v.valor_venta),c.nombre_cliente from Ventas v INNER JOIN clientes c ON v.cedula_cliente=c.cedula_cliente group by v.cedula_cliente";	
				ps=con.prepareStatement(sql);
				res=ps.executeQuery();
				
				while(res.next()) 
				{
					venta = new ReporteVentasDTO(res.getDouble(1),res.getDouble(2), res.getString(3));
					lista.add(venta); 
					
					
				}
			}
			catch(SQLException e) 
			{
				//JOptionPane.showMessageDialog(null,"Error al consultar" +e);
				System.out.println("error al consultar"+e);
			}
		
			return lista;
	}	
}
