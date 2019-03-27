package negocio.departamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import negocio.empleado.Empleado;
import negocio.departamento.Departamento;


public class SADepartamentoImp implements SADepartamento{

	@Override
	public int altaDepartamento(TDepartamento d) {
		int resultado = 0;
		Departamento auxDep;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Departamento> buscarPorNombre = em.createNamedQuery("buscarDepartamentoPorNombre", Departamento.class);
		buscarPorNombre.setParameter("nombre", d.getNombre());
		buscarPorNombre.setLockMode(LockModeType.OPTIMISTIC);
		List<Departamento> listaDep = buscarPorNombre.getResultList(); //lista de departamentos que coincidden con el nombre
		
		//si No se ha encontrado ningún departamento con el mismo nombre
		if (listaDep.size() == 0){			
			auxDep = new Departamento(d);
			em.persist(auxDep);//almacenamos el nuevo dep
			
			try{
				em.getTransaction().commit();
				resultado = auxDep.getIdDepartamento();	//devolvemos el id nuevo generado
			}catch(Exception e){
				em.getTransaction().rollback();
				resultado = -1;	//fallo	al dar de alta	
			}
			
		}
		else {//si hay un departamento con el mismo nombre
			auxDep = listaDep.get(0);
			if(!auxDep.getActivo()){//si esta desactivado...				
				auxDep.setActivo(true);//Lo volvemos a activar
				auxDep.setCategoria(d.getCategoria());
				auxDep.setNombre(d.getNombre());
				try{
					em.getTransaction().commit();
					resultado = auxDep.getIdDepartamento();	//devolvemos el id
				}catch(Exception e)
				{
					em.getTransaction().rollback();
					resultado = -2;   //Fallo al activar el departamento
				}
			}else 
				resultado = -3;		//El departamento ya existe y esta activo			
		}		
		em.close();
		return resultado;
	}
	
	//Al dar de baja un departamento, comprobamos que no haya ningun empleado asociado a el, sino no se puede.Yo probaría primero a compilar el alta y mostrar y luego haría el baja y modificar
	@Override
	public int bajaDepartamento(int id) {
		int resultado;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		Departamento aux = em.find(Departamento.class, id, LockModeType.OPTIMISTIC);
	
		if (aux != null){//si existe el dep
			if (aux.getActivo()){ //si está activo, buscamos si ese dep tiene un empleado asociado	
				TypedQuery<Empleado> buscarEmpleadoActivoAsociadoADepartamento = em.createNamedQuery("buscarEmpleadoActivoAsociadoADepartamento", Empleado.class);
				buscarEmpleadoActivoAsociadoADepartamento.setParameter("activo", true);
				buscarEmpleadoActivoAsociadoADepartamento.setParameter("departamento", aux);				
				buscarEmpleadoActivoAsociadoADepartamento.setLockMode(LockModeType.OPTIMISTIC);
				
				if(buscarEmpleadoActivoAsociadoADepartamento.getResultList().size() == 0){//si no hay ningun empleado asociado a ese dep
					aux.setActivo(false);//le damos de baja
					try{						
						em.getTransaction().commit();//guardamos
						resultado = id;
					}
					catch(Exception e){
						em.getTransaction().rollback();//error en la bbdd
						resultado = -1;
					}					
				}
				else
					resultado = -4;//hay empleados activos asociado a este departamaneto
			}
			else 
				resultado = -3;//existe el departamento pero esta dado de baja
		}
		else 
			resultado = -2;//no existe el departamento
		
		em.close();
		return resultado;
	}

	
	
	@Override
	public int modificarDepartamento(TDepartamento d) {
		int resultado;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		Departamento aux = em.find(Departamento.class, d.getIdDepartamento());
		
		if (aux != null){//si existe el dep
			
			if (aux.getActivo()){//si esta activo el dep, buscamos si existe un dep con el mismo nombre(el nuevo nombre modificado)				
				TypedQuery<Departamento> buscarDepartamentoPorNombre = em.createNamedQuery("buscarDepartamentoPorNombre", Departamento.class);
				buscarDepartamentoPorNombre.setParameter("nombre", d.getNombre());
				buscarDepartamentoPorNombre.setLockMode(LockModeType.OPTIMISTIC);
				
				//Entramos si no hay ningun departamento con el mismo nombre, o si el usuario no ha modificado el nombre del dep(ha modificado otros valores)
				List<Departamento> listaDep = buscarDepartamentoPorNombre.getResultList();
				if (listaDep.size() == 0 || (aux.getIdDepartamento() == listaDep.get(0).getIdDepartamento())) {
					aux.setNombre(d.getNombre());	//ponemos los valores nuevos
					aux.setCategoria(d.getCategoria());
					
					try	{
						em.getTransaction().commit();//guardamos
						resultado = d.getIdDepartamento();
					}
					catch(Exception e){
						em.getTransaction().rollback();//error
						resultado = -1;
					}
				}
				else
					resultado = -4;// el nombre del departamento nuevo escogido ya existe y no es el mismo
			}
			else 
				resultado = -3;//existe el departamento pero esta inactivo
		}
		else 
			resultado = -2;//no existe el departamento
		
		em.close();
		return resultado;
	}

	@Override
	public TDepartamento mostrarDepartamento(int id) {
		TDepartamento resultado = null;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		Departamento aux = em.find(Departamento.class, id);//buscamos por si id
		em.getTransaction().commit();
		em.close();
		
		if (aux != null){//si existe lo devolvemos
			resultado = aux.ToTransfer();			
		} 
		return resultado;
	}

	//falta depurar
	@Override
	public ArrayList<TDepartamento> listaDepartamento() {
		ArrayList<TDepartamento> listaTDep = new ArrayList<TDepartamento> ();
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Departamento> listarDepartamentos = em.createNamedQuery("listarDepartamentos", Departamento.class);//buscamos la lista
		List<Departamento> listaEDep = listarDepartamentos.getResultList();		
		
		for(int i = 0; i < listaEDep.size(); i++){
			//if(listaEDep.get(i).getActivo())
				listaTDep.add(listaEDep.get(i).ToTransfer());// de entidad a transfer
		}

		em.getTransaction().commit();
		em.close();
		return listaTDep;
	}

	@Override
	public double sueldoTotalDepartamento(int id) {
		double resultado = 0;
		EntityManager em = Persistence.createEntityManagerFactory("APPartamentos").createEntityManager();
		em.getTransaction().begin();
		Departamento aux = em.find(Departamento.class, id, LockModeType.OPTIMISTIC);//buscamos si existe el departamento
		
		if (aux != null){//si existe el dep
			if(aux.getActivo())	{//si esta activo el dep
				TypedQuery<Empleado> buscarEmpActivoDep = em.createNamedQuery("buscarEmpleadoActivoAsociadoADepartamento", Empleado.class);//busca los empleados activos asociados al departamento
				buscarEmpActivoDep.setParameter("departamento", aux);
				buscarEmpActivoDep.setParameter("activo", true);
				buscarEmpActivoDep.setLockMode(LockModeType.OPTIMISTIC);
				
				List<Empleado> l = buscarEmpActivoDep.getResultList();//recogemos la lista de empleados
				if(l.size() > 0){
					for(int i=0; i<l.size(); i++){//recorremos la lista para recoger los sueldos de cada empleado
						Empleado auxEmpleado = l.get(i);
						resultado += auxEmpleado.obtenerSueldo();
					}
					em.getTransaction().commit();
				}
				else 
					resultado = -3; // el departamento no tiene empleado
				
			}
			else
				resultado = -2;//esta inactivo el dep
		}
		else
			resultado = -1;//no existe el dep
		
		em.close();
		return resultado;
	}

}
