package Modelo;

public class ProductoDTO {
	
	private Long   CodigoProducto;
	private double IvaCompra;
	private Long   NitProveedor;
	private String NombreProducto;
	private double PrecioCompra;
	private double PrecioVenta;
	
	public ProductoDTO(  Long codigoProducto, double ivaCompra, Long nitProveedor, String nombreProducto,
			double precioCompra, double precioVenta) {
		
		CodigoProducto = codigoProducto;
		IvaCompra = ivaCompra;
		NitProveedor = nitProveedor;
		NombreProducto = nombreProducto;
		PrecioCompra = precioCompra;
		PrecioVenta = precioVenta;
		
	}
	
	

	public Long getCodigoProducto() {
		return CodigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		CodigoProducto = codigoProducto;
	}

	public double getIvaCompra() {
		return IvaCompra;
	}

	public void setIvaCompra(double ivaCompra) {
		IvaCompra = ivaCompra;
	}

	public Long getNitProveedor() {
		return NitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		NitProveedor = nitProveedor;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public double getPrecioCompra() {
		return PrecioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		PrecioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		PrecioVenta = precioVenta;
	}
	
	
	
}
