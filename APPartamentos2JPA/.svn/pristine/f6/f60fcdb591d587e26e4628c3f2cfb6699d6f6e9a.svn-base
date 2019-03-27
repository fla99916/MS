package negocio.empleado;

import javax.persistence.Entity;
import java.io.Serializable;

import negocio.departamento.Departamento;

@Entity
public class AgenteInmobiliario extends Empleado implements Serializable{
	
	private static final long serialVersionUID = 0;
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private int id;
	private int anosExperiencia;
	
	public AgenteInmobiliario(){
	}
	
	public AgenteInmobiliario(int id,String dni, String nombre, String domicilio, boolean activo, Departamento departamento, int anosExperiencia, double sueldo){
		super(id, dni, nombre, domicilio, activo, sueldo, departamento);
		this.anosExperiencia = anosExperiencia;		
	}
	public AgenteInmobiliario(String dni, String nombre, String domicilio, boolean activo, Departamento departamento, int anosExperiencia, double sueldo){
		super(dni, nombre, domicilio, activo, sueldo, departamento);
		this.anosExperiencia = anosExperiencia;		
	}
	
	public AgenteInmobiliario(TEmpleado e, Departamento departamento) {
		super(e,departamento);
		this.anosExperiencia = ((TAgenteInmobiliario) e).getAñosExperiencia();
	}
	
	public int getAnosExperiencia(){
		return this.anosExperiencia;
	}
	
	public void setAnosExperiencia(int anosExperiencia){
		this.anosExperiencia = anosExperiencia;
	}
	
	
	public TAgenteInmobiliario toTransfer(){
		return new TAgenteInmobiliario(super.getIdEmpleado(), super.getDni(), super.getNombre(), super.getDomicilio(), super.getActivo(), super.getDepartamento().getIdDepartamento(),this.anosExperiencia, this.sueldo);	
	}
	
	public Director toDirector(){
		return new Director();
	}

	@Override
	public double obtenerSueldo() {
		// TODO Auto-generated method stub
		return sueldo + 100 * anosExperiencia;
	}
}
