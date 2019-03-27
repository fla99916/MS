package negocio.empleado;


public class TEmpleado {
	protected int idEmpleado;
	protected String dni;
	protected String nombre;
	protected String domicilio;
	protected double sueldo;
	protected boolean activo;
	protected int departamento;
	
	public TEmpleado(int idEmpleado, String dni, String nombre, String domicilio, boolean activo, int dep, double sueldo){
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
		this.departamento = dep;
		this.sueldo = sueldo;
	}
	//ALTA(sin id)
	
	public TEmpleado(String dni, String nombre, String domicilio, boolean activo, int dep, double sueldo){
		this.departamento = dep;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
		this.sueldo = sueldo;
	}
	//TOTRANSFER!!(sin el departamento)
	public TEmpleado(int idEmpleado, String dni, String nombre, String domicilio, boolean activo, double sueldo){
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
		this.sueldo = sueldo;
	}
	
	//GETTERS
	public int getIdEmpleado(){
		return this.idEmpleado;
	}
	
	public String getDni(){
		return this.dni;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDomicilio(){
		return this.domicilio;
	}
	
	public int getDepartamento(){
		return this.departamento;
	}
	
	public double getSueldo(){
		return this.sueldo;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	//SETTERS
	public void setDni(String dni){
		this.dni = dni;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setDomicilio(String domicilio){
		this.domicilio = domicilio;
	}
	
	public void setSueldo(double sueldo){
		this.sueldo = sueldo;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public String toString() {
		String s = "ID EMPLEADO: " + this.idEmpleado + "\n" +
				"DNI: " + this.dni + "\n" +
				"NOMBRE: " + this.nombre + "\n" +
				"DOMICILIO: " + this.domicilio + "\n" +
				"DEPARTAMENTO: " + this.departamento + "\n"  +
				"SUELDO: " + this.sueldo + "\n" +
				"ACTIVO: " + this.activo + "\n";
		return s;
	}
	
}
