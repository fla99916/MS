package negocio.cliente;

import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.query.MaximoComprador;
import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;

public class SAClienteImp implements SACliente{

	/**
	 * Gestiona el alta de un cliente y los posibles errores en su creación
	 * @param tCliente transfer del cliente a introducir
	 * @return número del id del cliente creado o código de error
	 * @throws Exception
	 */
	public int altaCliente(TCliente tCliente) throws Exception {
		int idErr = 0;
		TCliente tCliAux;
        Transaction transaccionActual = null; 
        DAOCliente dao = FactoriaDAO.getInstancia().generarDAOCliente();
        
        try{
	        //El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        // Se busca el usuario por DNI, para comprobar que no existe ya
	        tCliAux = dao.readByDNI(tCliente.getDni());
			
	        if (tCliAux == null){
	            idErr = dao.create(tCliente); // anadimos el cliente a la bd
	            
	            if (idErr == 0){ 
	                idErr = -1;// error al añadir cliente en la base de datos
	                transaccionActual.rollback();
	            }        
	            else{ 
	            	transaccionActual.commit(); // dado de alta correctamente
	            }
	        }            
	        else if (!tCliAux.getActivo()) {
	        	tCliAux.setActivo(true); // lo ponemos a activo, ya existe el cliente
	            idErr = dao.update(tCliAux); // actualizamos los valores del cliente
	            if (idErr == 0){
	            	idErr = -2; //error al poner activo un cliente dado de baja
	            	transaccionActual.rollback();                   
	            }
	            else {
	            	idErr = tCliAux.getId();
	            	transaccionActual.commit();             
	            }            
	        }         
	        else if (tCliAux.getActivo()){
	                idErr = -3; // ya esta dado de alta
	                transaccionActual.rollback();
	        }
        }
        
        
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        
        return idErr;
	}

	/**
	 * Gestiona la baja de un cliente y los posibles errores en su desactivación
	 * @param id del usuario que se va a dar de baja lógica en la base de datos
	 * @return número del id del usuario desactivado o código de error
	 * @throws Exception
	 */
	public int bajaCliente(int id) throws Exception {
		int idErr;
		TCliente tCliAux;
		Transaction transaccionActual = null; 
		DAOCliente dao = FactoriaDAO.getInstancia().generarDAOCliente();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tCliAux = dao.read(id);
	        if(tCliAux != null) {
        		if(tCliAux.getActivo()) {
        			tCliAux.setActivo(false); // Se desactiva el usuario
    	        	idErr = dao.update(tCliAux); // Se actualiza la base de datos
    	        	
    	        	if(idErr == 0) {
    	        		idErr = -1; // Error en la base de datos al desactivarlo
    	        		transaccionActual.rollback();
    	        	} 
    	        	else {
    	        		idErr = tCliAux.getId(); //Cliente dado de baja correctamente
    	        		transaccionActual.commit();
    	        	}
        		}
        		else {
        			idErr = -2; // el cliente ya está desactivado
	        		transaccionActual.rollback();
        		}
	        	
	        } 
	        else {
	        	idErr = -3; // el cliente no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}


    /**
     * Gestiona la modificación de un cliente y los posibles errores en su edición
     * @param tCliente transfer con los datos de cliente a introducir
     * @return número del id del usuario modificado o código de error
     * @throws Exception
     */

	public int modificarCliente(TCliente tCliente) throws Exception {
		int idErr;
		TCliente tCliAux, tCliDni;
		Transaction transaccionActual = null; 
		DAOCliente dao = FactoriaDAO.getInstancia().generarDAOCliente();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        tCliAux = dao.read(tCliente.getId());
	        tCliDni = dao.readByDNI(tCliente.getDni());
	        
	        if((tCliDni != null && tCliDni.getId() == tCliAux.getId()) || tCliDni == null){
		        if(tCliAux != null){
		        	if(tCliAux.getActivo()){
		        		idErr = dao.update(tCliente); // Se cambian los datos del cliente
	    	        	
	    	        	if(idErr == 0) {
	    	        		idErr = -1; // no se ha conseguido editar los datos
	    	        		transaccionActual.rollback();
	    	        	} 
	    	        	else {
	    	        		idErr = tCliAux.getId();// se han modificado los datos
	    	        		transaccionActual.commit();
	    	        	}
		        	}
		        	else{
		        		idErr = -2; // el cliente estaba desactivado
		        		transaccionActual.rollback();
		        	}
		        }
		        else{
		        	idErr = -4; // el cliente no existe
	        		transaccionActual.rollback();
		        }
	        }
	        else {
	        	idErr = -5; // Dni en uso
	        	transaccionActual.rollback();
	        }
		}
	        
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		
		
		return idErr;
	        
	        
	        
			/*
	        tCliAux = dao.read(tCliente.getId());
	        tCliDni = dao.readByDNI(tCliente.getDni());
	        
	        if(tCliAux != null) {
	        	
	        	if(tCliDni == null || tCliAux.getId() == tCliDni.getId()) {
	        		if(tCliAux.getActivo()) {
	    	        	idErr = dao.update(tCliente); // Se cambian los datos del cliente
	    	        	
	    	        	if(idErr == 0) {
	    	        		idErr = -1; // no se ha conseguido editar los datos
	    	        		transaccionActual.rollback();
	    	        	} 
	    	        	else {
	    	        		idErr = tCliAux.getId();// se han modificado los datos
	    	        		transaccionActual.commit();
	    	        	}
	        		}
	        		else {
	        			idErr = -2; // el cliente estaba desactivado
		        		transaccionActual.rollback();
	        		}
        		}
        		else {
        			idErr = -3; // el dni a modificar estaba en uso
            		transaccionActual.rollback();
        		}
	        } 
	        else {
	        	idErr = -4; // el cliente no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		
		
		return idErr;
		*/
	}

	@Override
	public ArrayList<TCliente> listaCliente() throws Exception {
		ArrayList<TCliente> tCliAux;
		Transaction transaccionActual = null; 
		DAOCliente dao = FactoriaDAO.getInstancia().generarDAOCliente();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
			// Comprobamos si el usuario introducido existe
	        tCliAux = dao.list();
	        
	        // Hay usuarios en la base de datos
	        if(tCliAux.size() > 0) {
        		transaccionActual.commit();
	        } 
	        // No hay usuarios en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tCliAux;
	}

	@Override
	public TCliente mostrarCliente(int id) throws Exception {
		TCliente tCliAux;
		Transaction transaccionActual = null; 
		DAOCliente dao = FactoriaDAO.getInstancia().generarDAOCliente();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tCliAux = dao.read(id);
	        
	        // Existe el cliente en la base de datos
	        if(tCliAux != null) {
        		transaccionActual.commit();
	        } 
	        // No existe el cliente en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return tCliAux;
	}

	@Override
	public TCliente maximoClienteComprador() throws Exception {
		TCliente resAux=null;
		Transaction transaccionActual = null;
		MaximoComprador maxComprador = new MaximoComprador();
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        resAux = (TCliente) maxComprador.execute(null);
	        
	        // Existe el cliente en la base de datos
	        if(resAux != null) {
        		transaccionActual.commit();
	        } 
	        // No existe el cliente en la base de datos
	        else {
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return resAux;
		
	}

}
