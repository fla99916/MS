package negocio.empleado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.departamento.Departamento;

public class SAEmpleadoImp implements SAEmpleado {

	@Override
	public int altaEmpleado(TEmpleado emp) {
		int resultado = 0;
		Empleado auxEmp;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Empleado> buscarEmpleadoPorDni = em.createNamedQuery("buscarEmpleadoPorDni", Empleado.class);//buscamos empleado por dni
		buscarEmpleadoPorDni.setParameter("dni", emp.getDni());
		buscarEmpleadoPorDni.setLockMode(LockModeType.OPTIMISTIC);
		List<Empleado> listaEmp = buscarEmpleadoPorDni.getResultList();//obtenemos los posibles resultados
		
		Departamento depAux = em.find(Departamento.class, emp.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);//buscamos si el departamento existe
		if (depAux != null){//si  existe el departamento
			if(depAux.getActivo()){//si el departamento esta activo
				if (listaEmp.size() == 0){
					if (emp instanceof TDirector)
						auxEmp = new Director(emp,depAux);
					else auxEmp = new AgenteInmobiliario(emp, depAux);
					
					em.persist(auxEmp);//guardamos
					try{
						
						et.commit();
						resultado = auxEmp.getIdEmpleado();	//éxito en dar de alta el empleado, devolvemos el id
					}catch(Exception e){
						et.rollback();
						resultado = -1;	//fallo	al dar de alta	
					}
				}
				else {//Se ha encontrado empleado con el mismo dni
					auxEmp = listaEmp.get(0);
					if(!auxEmp.getActivo()){//si esta inactivo
						
						if (emp instanceof TDirector && auxEmp instanceof Director || emp instanceof TAgenteInmobiliario && auxEmp instanceof AgenteInmobiliario){
							auxEmp.setActivo(true);//Lo volvemos a activar
							auxEmp.setDepartamento(depAux);
							auxEmp.setDni(emp.getDni());
							auxEmp.setDomicilio(emp.getDomicilio());
							auxEmp.setNombre(emp.getNombre());
							auxEmp.setSueldo(emp.getSueldo());
							if(emp instanceof TDirector && auxEmp instanceof Director)
								((Director) auxEmp).setPoliticaEmpresarial(((TDirector) emp).getPoliticaEmpresarial());
							else if (emp instanceof TAgenteInmobiliario && auxEmp instanceof AgenteInmobiliario)
								((AgenteInmobiliario) auxEmp).setAnosExperiencia(((TAgenteInmobiliario) emp).getAñosExperiencia());
							try{
								et.commit();
								resultado = auxEmp.getIdEmpleado();		//correcto, devolvemos el id
							}catch(Exception e){
								et.rollback();
								resultado = -2;   //Fallo al activar el empleado
							}
						}
						else{
							resultado = -6;  //No se puede reactivar con tipo distinto
						}
					
					}
					else{ 
						resultado = -4;		//El empleado ya existe y esta activo 
					}
				}				
			}
			else {
				resultado = -5; //el departamento está dado de baja
			}
			
		}
		else {
			resultado = -3; //No existe el departamento
		}
		
		em.close();
		return resultado;
	}

	
	@Override
	public int bajaEmpleado(int id) {
		int resultado = 0;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Empleado auxEmp = em.find(Empleado.class, id, LockModeType.OPTIMISTIC);//buscamos el empleado por id
		
		if(auxEmp != null){//si existe el empleado
			if(auxEmp.getActivo()){//si esta activo el empleado
				auxEmp.setActivo(false);//lo ponemos a inactivo
				try{
					//Si el empleado existe y esta activo, bloqueamos la tabla dep(ya sabemos que existe) lo metemos dentro del try por si acaso
					em.lock(auxEmp.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					et.commit();
					resultado = id;	//éxito en dar de baja el empleado, devolvemos el id
				}
				catch(Exception e){
					et.rollback();
					resultado = -1;	//fallo	al dar de alta	
				}
			}
			else{
				resultado = -3; 	//El empleado ya está dado de baja
			}
		}
		else{
			resultado = -2;	//No existe el empleado
		}	
		
		em.close();
		return resultado;
	}

	@Override
	public int modificarEmpleado(TEmpleado tEmp) {
		int resultado = 0;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Empleado auxEmp = em.find(Empleado.class, tEmp.getIdEmpleado(), LockModeType.OPTIMISTIC);//buscamos si existe el empleado a momdificar	
		
		if(auxEmp != null){//si el empleado existe			
			if(auxEmp.getActivo()){//si el empleado está activo
				//comprobamos que el empleado a modificar sea director o agente(no damos la posibilidad de ser un director y cambiar a agente inmobiliario y viceversa)
				if((tEmp instanceof TDirector && auxEmp instanceof Director) || (tEmp instanceof TAgenteInmobiliario && auxEmp instanceof AgenteInmobiliario)){
					Departamento auxDep = em.find(Departamento.class, tEmp.getDepartamento(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);//buscamos si existe el departamento por id, bloqueamos el nuevo departamento					
					if(auxDep != null){//si existe el departamento nuevo					
						if(auxDep.getActivo()){//si está activo el departamento nuevo
							if(tEmp.getDepartamento() != auxEmp.getDepartamento().getIdDepartamento()){//si el empleado cambia de departamento, 
								em.lock(auxEmp.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);		// bloqueamos el departamento antiguo		
							}
							TypedQuery<Empleado> buscarEmpleadoPorDni = em.createNamedQuery("buscarEmpleadoPorDni", Empleado.class);//buscamos si existe un empleado con el nuevo dni introducido
							buscarEmpleadoPorDni.setParameter("dni", tEmp.getDni());
							
							List<Empleado> empLista = buscarEmpleadoPorDni.getResultList();
							//si no existe nigun empleado con el mismo dni o si exsite, que sea el mismo(el empleado a modificar no ha cambiado el dni)
							try{
								if(empLista.size() == 0 || tEmp.getIdEmpleado() == empLista.get(0).getIdEmpleado()){
									auxEmp.setDepartamento(auxDep);
									auxEmp.setDni(tEmp.getDni());
									auxEmp.setDomicilio(tEmp.getDomicilio());
									auxEmp.setNombre(tEmp.getNombre());
									auxEmp.setSueldo(tEmp.getSueldo());
									
									if(auxEmp instanceof Director){//añadir los atributos dependiendo si es director o agente
										((Director) auxEmp).setPoliticaEmpresarial(((TDirector) tEmp).getPoliticaEmpresarial());
									} else {
										((AgenteInmobiliario) auxEmp).setAnosExperiencia(((TAgenteInmobiliario) tEmp).getAñosExperiencia());
									}
								et.commit();
								resultado = tEmp.getIdEmpleado();//correcto y devolvemos el id
								}else {
									resultado = -6; // Existe empleado con el mismo dni
								}
							}catch(Exception e)
							{
								et.rollback();
								resultado = -1;	//fallo	al dar de alta	
							}
							
						}
						else{
							resultado = -4; 	//El departamento está dado de baja
						}
					}
					else {
						resultado = -3; //No existe el departamento
					}					
				}
				else{
					resultado = -5;//se ha cambiado el tipo de empleado
				}
			}else {
				resultado = -7; //El emplead esta dado de baja
			}
			
		}else {
			resultado = -2; //No existe el empleado
		}
		em.close();
		return resultado;
	}

	@Override
	public TEmpleado mostrarEmpleado(int id) {
		TEmpleado resultado = null;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		//Busca en la de director
		Empleado empAux = em.find(Empleado.class, id);
		if (empAux != null){
			resultado = empAux.toTransfer();//ya sabe si es un director o un agente inmobiliario.
		}
		et.commit();
		em.close();	
		
		return resultado;
	}

	
	@Override
	public ArrayList<TEmpleado> listaEmpleados() {
		ArrayList<TEmpleado> lista = new ArrayList<TEmpleado> ();
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		List<Empleado> l = em.createQuery("SELECT emp FROM Empleado emp", Empleado.class).getResultList();
		
		Empleado empAux;		
		for(int i = 0; i < l.size(); i++){
			empAux = l.get(i);
			//if(empAux.getActivo())
				lista.add(empAux.toTransfer());		
		}

		et.commit();
		em.close();
		return lista;
	}


	

}
