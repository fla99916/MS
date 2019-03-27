package negocio.empleado;

import javax.persistence.Entity;
import java.io.Serializable;

import negocio.departamento.Departamento;

@Entity
public class Director extends Empleado implements Serializable{
	
	private static final long serialVersionUID = 0;
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private int id;
	private String politicaEmpresarial;
	
	public Director(){
	}
	
	public Director(int id, String politicaEmpresarial,String dni, String nombre, String domicilio, double sueldo, Departamento departamento, boolean activo){
		super(id, dni, nombre, domicilio, activo, sueldo, departamento);
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	public Director(String politicaEmpresarial,String dni, String nombre, String domicilio, double sueldo, Departamento departamento, boolean activo){
		super(dni, nombre, domicilio, activo, sueldo, departamento);
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	
	public Director(TEmpleado e, Departamento departamento) {
		super(e,departamento);
		this.politicaEmpresarial = ((TDirector)e).getPoliticaEmpresarial();
	}

	public String getPoliticaEmpresarial() {
		return politicaEmpresarial;
	}

	public void setPoliticaEmpresarial(String politicaEmpresarial) {
		this.politicaEmpresarial = politicaEmpresarial;
	}
	
	public double obtenerSueldo()
	{
		return sueldo * 3;
	}
	
	
	public TDirector toTransfer(){
		return new TDirector(super.getIdEmpleado(), super.getDni(), super.getNombre(), super.getDomicilio(), super.getActivo(), super.getDepartamento().getIdDepartamento(), this.politicaEmpresarial, this.sueldo);	
	}
	
	public AgenteInmobiliario toAgenteInmobiliario(){
		return new AgenteInmobiliario();
	}
	

}
