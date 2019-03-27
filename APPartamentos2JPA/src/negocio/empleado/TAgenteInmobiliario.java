package negocio.empleado;


public class TAgenteInmobiliario extends TEmpleado{

	private int añosExperiencia;

	public TAgenteInmobiliario(int idEmpleado, String dni, String nombre, String domicilio, boolean activo, int dep,int añosExperiencia, double sueldo){
		super(idEmpleado,  dni, nombre, domicilio, activo, dep, sueldo);
		this.añosExperiencia = añosExperiencia;
	}
	public TAgenteInmobiliario(String dni, String nombre, String domicilio, boolean activo, int dep, int añosExperiencia, double sueldo){
		super(dni, nombre, domicilio, activo, dep, sueldo);
		this.añosExperiencia = añosExperiencia;
	}
	
	public int getAñosExperiencia(){
		return this.añosExperiencia;
	}
	
	public void setAñosExperiencia(int añosExperiencia){
		this.añosExperiencia = añosExperiencia;
	}
	
	public String toString() {
		String s = super.toString();
		s += "AÑOS EXPERIENCIA: " + this.añosExperiencia + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
