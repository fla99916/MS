package negocio.departamento;

public class TDepartamento {
	private int idDepartamento;
	private String categoria;
	private String nombre;
	private boolean activo;
	
	public TDepartamento(int idDep,  String nombre, String categoria, boolean activo){
		this.idDepartamento = idDep;
		this.nombre = nombre;
		this.categoria = categoria;
		this.activo = activo;
	}
	
	
	public TDepartamento(String nombre,String categoria , boolean activo){
		this.nombre = nombre;
		this.categoria = categoria;
		this.activo = activo;
	}
	
	//GETTERS
	public int getIdDepartamento(){
		return this.idDepartamento;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public boolean getActivo(){
		return this.activo;
	}
	
	
	//SETTERS
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	
	public String toString(){
		String toString= "";
		toString = "ID : " + this.idDepartamento + "\nNombre : " + this.nombre + "\nCategoria : "
				+ this.categoria + "\n" + "Activo: " + this.activo + "\n" ;
		return toString;
		
	}
}
