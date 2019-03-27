package negocio.empleado;



public class TDirector extends TEmpleado{

	private String politicaEmpresarial;
	
	public TDirector(int idEmpleado, String dni, String nombre, String domicilio, boolean activo, int dep, String politicaEmpresarial, double sueldo){
		super(idEmpleado,  dni, nombre, domicilio, activo, dep, sueldo);
		this.politicaEmpresarial = politicaEmpresarial;
	}
	public TDirector(String dni, String nombre, String domicilio, boolean activo, int dep,String politicaEmpresarial, double sueldo){
		super(dni, nombre, domicilio, activo, dep, sueldo);
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	public String getPoliticaEmpresarial(){
		return this.politicaEmpresarial;
	}
	
	public void setPoliticaEmpresarial(String politicaEmpresarial){
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	public String toString() {
		String s = super.toString();
		s += "POLITICA EMPRESARIAL: " + this.politicaEmpresarial + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
