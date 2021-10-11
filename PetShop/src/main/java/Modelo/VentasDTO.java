package Modelo;

public class VentasDTO {
	
	private Long CodigoVenta, CodigoDeVenta,
	CodigoProducto1,CodigoProducto2,CodigoProducto3;
	
	private double CedulaCliente,CedulaUsuario,IvaVenta,TotalVenta,ValorVenta,
	ValorProducto1,ValorProducto2,ValorProducto3,IvaProducto1,IvaProducto2,IvaProducto3,Valor_VentaDet1,Valor_VentaDet2,Valor_VentaDet3;
	
	private int CantidadP1,CantidadP2,CantidadP3;
	
	private String NombreProducto1,NombreProducto2,NombreProducto3;
	
	public VentasDTO() {
		super();
	}
	
	public VentasDTO(Long codigoProducto1, Long codigoProducto2,
			Long codigoProducto3, double cedulaCliente, double cedulaUsuario, double ivaVenta, double totalVenta,
			double valorVenta, double valorProducto1, double valorProducto2, double valorProducto3, double ivaProducto1,
			double ivaProducto2, double ivaProducto3, double valor_VentaDet1, double valor_VentaDet2,
			double valor_VentaDet3, int cantidadP1, int cantidadP2, int cantidadP3) {
	
		CodigoProducto1 = codigoProducto1;
		CodigoProducto2 = codigoProducto2;
		CodigoProducto3 = codigoProducto3;
		CedulaCliente = cedulaCliente;
		CedulaUsuario = cedulaUsuario;
		IvaVenta = ivaVenta;
		TotalVenta = totalVenta;
		ValorVenta = valorVenta;
		ValorProducto1 = valorProducto1;
		ValorProducto2 = valorProducto2;
		ValorProducto3 = valorProducto3;
		IvaProducto1 = ivaProducto1;
		IvaProducto2 = ivaProducto2;
		IvaProducto3 = ivaProducto3;
		Valor_VentaDet1 = valor_VentaDet1;
		Valor_VentaDet2 = valor_VentaDet2;
		Valor_VentaDet3 = valor_VentaDet3;
		CantidadP1 = cantidadP1;
		CantidadP2 = cantidadP2;
		CantidadP3 = cantidadP3;
	}



	public Long getCodigoVenta() {
		return CodigoVenta;
	}

	public void setCodigoVenta(Long codigoVenta) {
		CodigoVenta = codigoVenta;
	}

	public Long getCodigoDeVenta() {
		return CodigoDeVenta;
	}

	public void setCodigoDeVenta(Long codigoDeVenta) {
		CodigoDeVenta = codigoDeVenta;
	}

	public Long getCodigoProducto1() {
		return CodigoProducto1;
	}

	public void setCodigoProducto1(Long codigoProducto1) {
		CodigoProducto1 = codigoProducto1;
	}

	public Long getCodigoProducto2() {
		return CodigoProducto2;
	}

	public void setCodigoProducto2(Long codigoProducto2) {
		CodigoProducto2 = codigoProducto2;
	}

	public Long getCodigoProducto3() {
		return CodigoProducto3;
	}

	public void setCodigoProducto3(Long codigoProducto3) {
		CodigoProducto3 = codigoProducto3;
	}

	public double getCedulaCliente() {
		return CedulaCliente;
	}

	public void setCedulaCliente(double cedulaCliente) {
		CedulaCliente = cedulaCliente;
	}

	public double getCedulaUsuario() {
		return CedulaUsuario;
	}

	public void setCedulaUsuario(double cedulaUsuario) {
		CedulaUsuario = cedulaUsuario;
	}

	public double getIvaVenta() {
		return IvaVenta;
	}

	public void setIvaVenta(double ivaVenta) {
		IvaVenta = ivaVenta;
	}

	public double getTotalVenta() {
		return TotalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		TotalVenta = totalVenta;
	}

	public double getValorVenta() {
		return ValorVenta;
	}

	public void setValorVenta(double valorVenta) {
		ValorVenta = valorVenta;
	}

	public double getValorProducto1() {
		return ValorProducto1;
	}

	public void setValorProducto1(double valorProducto1) {
		ValorProducto1 = valorProducto1;
	}

	public double getValorProducto2() {
		return ValorProducto2;
	}

	public void setValorProducto2(double valorProducto2) {
		ValorProducto2 = valorProducto2;
	}

	public double getValorProducto3() {
		return ValorProducto3;
	}

	public void setValorProducto3(double valorProducto3) {
		ValorProducto3 = valorProducto3;
	}

	public double getIvaProducto1() {
		return IvaProducto1;
	}

	public void setIvaProducto1(double ivaProducto1) {
		IvaProducto1 = ivaProducto1;
	}

	public double getIvaProducto2() {
		return IvaProducto2;
	}

	public void setIvaProducto2(double ivaProducto2) {
		IvaProducto2 = ivaProducto2;
	}

	public double getIvaProducto3() {
		return IvaProducto3;
	}

	public void setIvaProducto3(double ivaProducto3) {
		IvaProducto3 = ivaProducto3;
	}

	public double getValor_VentaDet1() {
		return Valor_VentaDet1;
	}

	public void setValor_VentaDet1(double valor_VentaDet1) {
		Valor_VentaDet1 = valor_VentaDet1;
	}

	public double getValor_VentaDet2() {
		return Valor_VentaDet2;
	}

	public void setValor_VentaDet2(double valor_VentaDet2) {
		Valor_VentaDet2 = valor_VentaDet2;
	}

	public double getValor_VentaDet3() {
		return Valor_VentaDet3;
	}

	public void setValor_VentaDet3(double valor_VentaDet3) {
		Valor_VentaDet3 = valor_VentaDet3;
	}

	public int getCantidadP1() {
		return CantidadP1;
	}

	public void setCantidadP1(int cantidadP1) {
		CantidadP1 = cantidadP1;
	}

	public int getCantidadP2() {
		return CantidadP2;
	}

	public void setCantidadP2(int cantidadP2) {
		CantidadP2 = cantidadP2;
	}

	public int getCantidadP3() {
		return CantidadP3;
	}

	public void setCantidadP3(int cantidadP3) {
		CantidadP3 = cantidadP3;
	}

	public String getNombreProducto1() {
		return NombreProducto1;
	}

	public void setNombreProducto1(String nombreProducto1) {
		NombreProducto1 = nombreProducto1;
	}

	public String getNombreProducto2() {
		return NombreProducto2;
	}

	public void setNombreProducto2(String nombreProducto2) {
		NombreProducto2 = nombreProducto2;
	}

	public String getNombreProducto3() {
		return NombreProducto3;
	}

	public void setNombreProducto3(String nombreProducto3) {
		NombreProducto3 = nombreProducto3;
	}

	
	
	
	
}
