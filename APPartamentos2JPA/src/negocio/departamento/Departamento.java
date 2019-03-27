package negocio.departamento;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import negocio.empleado.Empleado;

@Entity
@NamedQueries({
	@NamedQuery(name = "buscarDepartamentoPorId", query = "SELECT dep FROM Departamento dep WHERE dep.idDepartamento = :idDepartamento"),
	@NamedQuery(name = "buscarDepartamentoPorNombre", query = "SELECT dep FROM Departamento dep WHERE dep.nombre = :nombre"),	
	@NamedQuery(name = "listarDepartamentos", query = "SELECT dep FROM Departamento dep") 
	})
public class Departamento implements Serializable{
	
	private static final long serialVersionUID = 0;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int idDepartamento;
	@OneToMany(mappedBy="departamento") //relaccionde 1-n con empleados
	private ArrayList<Empleado> empleado;
	private String nombre;
	private String categoria;
	private boolean activo;
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Version private Long version;//version de la tabla
	
	
	
	//CONSTRUCTORES Y MÉTODOS
	public Departamento(){
	}
	
	 public Departamento(TDepartamento td, int id){
		 this.idDepartamento = id;
		 this.nombre = td.getNombre();
		 this.categoria = td.getCategoria();
		 this.activo = td.getActivo();		 
	 }
	 
	 
	 public Departamento(TDepartamento td){
		 this.nombre = td.getNombre();
		 this.categoria = td.getCategoria();
		 this.activo = td.getActivo();		 
	 }
	
	//GETTERS
	public int getIdDepartamento(){
		return this.idDepartamento;	
	}
	
	public String getNombre(){
		return this.nombre;	
	}
	
	public String getCategoria(){
		return this.categoria;	
	}
	
	
	public boolean getActivo(){
		return this.activo;	
	}
	
	//SETTTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
	
	public TDepartamento ToTransfer(){
		return new TDepartamento(this.idDepartamento, this.nombre, this.categoria, this.activo);
	}	
}
