package negocio.tipoVivienda;

public class TTipoVivienda {
	private int idTipoVivienda;
	private int cantidad;
	private String direccion;
	private String ciudad;
	private double precio;
	private boolean activo;
	
	public TTipoVivienda(){}
	
	public TTipoVivienda(int id, int cantidad, String direccion, String ciudad, double precio, boolean activo) {
		this.idTipoVivienda = id;
		this.cantidad = cantidad;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.precio = precio;
		this.activo = activo;
	}
	
	public int getId() {
		return this.idTipoVivienda;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	
	public String toString() {
		String s = "ID VIVIENDA: " + this.idTipoVivienda + "\n" +
				"CANTIDAD: " + this.cantidad + "\n" +
				"DIRECCION: " + this.direccion + "\n" +
				"CIUDAD: " + this.ciudad + "\n" +
				"PRECIO UNITARIO: " + this.precio+ "\n \n" ;
		return s;
	}
}
