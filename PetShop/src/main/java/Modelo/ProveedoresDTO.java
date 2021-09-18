package Modelo;

public class ProveedoresDTO {
	
	private Long   NitProveedor;
	private String Ciudad_Proveedor;
	private String Direccion_Proveedor;
	private String Nombre_Proveedor;
	private String Telefono_Proveedor;
	
	
	public ProveedoresDTO(Long nitProveedor, String ciudad_Proveedor, String direccion_Proveedor,
			String nombre_Proveedor, String telefono_Proveedor) {
		
		NitProveedor = nitProveedor;
		Ciudad_Proveedor = ciudad_Proveedor;
		Direccion_Proveedor = direccion_Proveedor;
		Nombre_Proveedor = nombre_Proveedor;
		Telefono_Proveedor = telefono_Proveedor;
	}


	public Long getNitProveedor() {
		return NitProveedor;
	}


	public void setNitProveedor(Long nitProveedor) {
		NitProveedor = nitProveedor;
	}


	public String getCiudad_Proveedor() {
		return Ciudad_Proveedor;
	}


	public void setCiudad_Proveedor(String ciudad_Proveedor) {
		Ciudad_Proveedor = ciudad_Proveedor;
	}


	public String getDireccion_Proveedor() {
		return Direccion_Proveedor;
	}


	public void setDireccion_Proveedor(String direccion_Proveedor) {
		Direccion_Proveedor = direccion_Proveedor;
	}


	public String getNombre_Proveedor() {
		return Nombre_Proveedor;
	}


	public void setNombre_Proveedor(String nombre_Proveedor) {
		Nombre_Proveedor = nombre_Proveedor;
	}


	public String getTelefono_Proveedor() {
		return Telefono_Proveedor;
	}


	public void setTelefono_Proveedor(String telefono_Proveedor) {
		Telefono_Proveedor = telefono_Proveedor;
	}
	
	
	
	
	
	
	
}
