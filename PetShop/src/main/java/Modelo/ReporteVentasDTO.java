package Modelo;

public class ReporteVentasDTO {
	

	private double cedula_cliente,valor_venta;
	private String nombre_cliente;
	
	
	public ReporteVentasDTO(double cedulaCliente, double valorVenta, String nombreCliente) {
		setCedula_cliente(cedulaCliente);
		setValor_venta(valorVenta);
		setNombre_cliente(nombreCliente);
		
	}


	public double getCedula_cliente() {
		return cedula_cliente;
	}


	public void setCedula_cliente(double cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}


	public String getNombre_cliente() {
		return nombre_cliente;
	}


	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}


	public double getValor_venta() {
		return valor_venta;
	}


	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	

	
	
	
	
}
