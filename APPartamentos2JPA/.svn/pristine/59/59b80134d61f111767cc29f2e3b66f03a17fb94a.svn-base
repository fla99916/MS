package negocio.empleado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import java.io.Serializable;


import negocio.departamento.Departamento;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		// Buscar empleado por dni
		@NamedQuery(name = "buscarEmpleadoPorDni", query = "SELECT emp FROM Empleado emp  WHERE emp.dni = :dni"),
		//para dar de baja a un departamento, comprobamos si hay empleados activos asociados
		@NamedQuery(name="buscarEmpleadoActivoAsociadoADepartamento", query="SELECT emp FROM Empleado emp WHERE emp.departamento = :departamento AND emp.activo = :activo"),
		//Listar empleados
		@NamedQuery(name = "listarEmpleados", query = "SELECT emp FROM Empleado emp") })

public abstract class Empleado implements Serializable{
	private static final long serialVersionUID = 0;
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)	protected int idEmpleado;	
	@Version protected Long version;
	protected String dni;
	protected String nombre;
	protected String domicilio;
	protected boolean activo;
	protected double sueldo;

	@ManyToOne @JoinColumn(name = "departamento")	protected Departamento departamento;
	
	public Empleado() {
	}

	public Empleado(int idEmpleado, String dni, String nombre, String domicilio, boolean activo, double sueldo, Departamento departamento) {
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	public Empleado(String dni, String nombre, String domicilio, boolean activo, double sueldo, Departamento departamento) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.activo = activo;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	//altas
	public Empleado(TEmpleado empleado, Departamento dep) {
		this.idEmpleado = empleado.getIdEmpleado();
		this.dni = empleado.getDni();
		this.nombre = empleado.getNombre();
		this.domicilio = empleado.getDomicilio();
		this.activo = empleado.getActivo();
		this.departamento = dep;
		this.sueldo = empleado.getSueldo();
	}

	
	public Departamento getDepartamento() {
		return departamento;
	}
	// GETTERS

	// puede que no haga falta
	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}
	
	public double getSueldo(){
		return this.sueldo;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public Long getVersion() {
		return version;
	}


	// SETTERS
	public void setDepartamento(Departamento dep) {
		this.departamento = dep;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public void setSueldo(double sueldo){
		this.sueldo = sueldo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setVersion(Long version) {
		this.version = version;
	}

	//mostrar y listar
	public TEmpleado toTransfer() {
		return new TEmpleado(this.idEmpleado, this.dni, this.nombre, this.domicilio, this.activo, this.departamento.getIdDepartamento());
	}
	
	
	public abstract double obtenerSueldo();
}
