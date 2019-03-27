package negocio.cliente;

public class TCliente {
	private int idCliente;		
	private String dni;	
	private String nombre;
	private String direccion;	
	private String ciudad;	
	private boolean activo;
	
	public TCliente(){};
	
	public TCliente(int idCliente, String nombre, String dni, String direccion, String ciudad, boolean activo){
		this.idCliente = idCliente;
		this.dni = dni; 
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.activo = activo;
	}
	
	public int getId() {		
		return this.idCliente;		
	}

	public void setNombre(String n) {
		this.nombre = n; 
	}	
	public String getNombre() {		
		return this.nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDireccion(String d) {
		this.direccion = d;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}
	
	public void setCiudad(String c) {
		this.ciudad = c;
	}
	
	public void setActivo(boolean a) {
		this.activo = a;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public String toString(){
		String s = "ID CLIENTE: " + idCliente + "\n"
				+ "DNI: " + dni + "\n"
				+ "NOMBRE: " + nombre + "\n"
				+ "DIRECCION: " + direccion + "\n"
				+ "CIUDAD: " + ciudad;
		s += "\n";
		return s.toString();
	}
}

