package negocio.tipoVivienda;

import java.util.ArrayList;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.query.TipoViviendaMasVendido;
import integracion.tipoVivienda.DAOTipoVivienda;
import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;


public class SATipoViviendaImp implements SATipoVivienda {

	@Override
	public int altaTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception {
		int idErr;
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
        
        try{
	        //El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        // Se busca la vivienda por direccion, para comprobar que no existe ya
	        tVivAux = dao.readByDireccion(tTipoVivienda.getDireccion());
			
	        if (tVivAux == null){
	            idErr = dao.create(tTipoVivienda); // anadimos la vivienda a la bd
	            
	            if (idErr == 0){ 
	                idErr = -1;// error al añadir la vivienda en la base de datos
	                transaccionActual.rollback();
	            }        
	            else{ 
	            	transaccionActual.commit(); // dado de alta correctamente
	            }
	        }            
	        else if (!tVivAux.getActivo()) {
	        	tVivAux.setActivo(true); // lo ponemos a activo, ya existe la vivienda
	            idErr = dao.update(tVivAux); // actualizamos los valores de la vivienda
	            if (idErr == 0){
	            	idErr = -2; //error al poner activo la vivienda dada de baja
	            	transaccionActual.rollback();                   
	            }
	            else {
	            	idErr = tVivAux.getId();
	            	transaccionActual.commit();             
	            }            
	        }         
	        else{
	                idErr = -3; // ya esta dado de alta
	                transaccionActual.rollback();
	        }
        }
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        return idErr;
	}

	@Override
	public int bajaTipoVivienda(int id) throws Exception {
		int idErr;
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si la vivienda introducida existe
	        tVivAux = dao.read(id);
	        if(tVivAux != null) {
        		if(tVivAux.getActivo()) {
        			tVivAux.setActivo(false); // Se desactiva la vivienda
    	        	idErr = dao.update(tVivAux); // Se actualiza la base de datos
    	        	
    	        	if(idErr == 0) {
    	        		idErr = -1; // Error en la base de datos al desactivarlo
    	        		transaccionActual.rollback();
    	        	} 
    	        	else {
    	        		idErr = tVivAux.getId(); // vivienda dada de baja correctamente
    	        		transaccionActual.commit();
    	        	}
        		}
        		else {
        			idErr = -2; // la vivienda ya está desactivado
	        		transaccionActual.rollback();
        		}
	        	
	        } 
	        else {
	        	idErr = -3; // la vivienda no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public int modificarTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception {
		int idErr;
		TTipoVivienda tVivAux, tVivDir;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tVivAux = dao.read(tTipoVivienda.getId());
	        tVivDir = dao.readByDireccion(tTipoVivienda.getDireccion());
	        
	        if(tVivAux != null) {
	        	if(tVivDir == null || tVivAux.getId() == tVivDir.getId()) {
	        		if(tVivAux.getActivo()) {
	    	        	idErr = dao.update(tTipoVivienda); // Se cambian los datos del cliente
	    	        	
	    	        	if(idErr == 0) {
	    	        		idErr = -1; // no se ha conseguido editar los datos
	    	        		transaccionActual.rollback();
	    	        	} 
	    	        	else {
	    	        		idErr = tVivAux.getId();// se han modificado los datos
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
	}

	@Override
	public ArrayList<TTipoVivienda> listaTipoVivienda() throws Exception {
		ArrayList<TTipoVivienda> tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tVivAux = dao.list();
	        
	        // Hay usuarios en la base de datos
	        if(tVivAux.size() > 0) {
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
		
		return tVivAux;
	}

	@Override
	public TTipoVivienda mostrarTipoVivienda(int id) throws Exception {
		TTipoVivienda tVivAux;
        Transaction transaccionActual = null; 
        DAOTipoVivienda dao = FactoriaDAO.getInstancia().generarDAOTipoVivienda();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tVivAux = dao.read(id);
	        
	        // Existe el cliente en la base de datos
	        if(tVivAux != null) {
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
		
		return tVivAux;
	}

	@Override
	public TTipoVivienda tviviendaMasVendido() throws Exception {
		TTipoVivienda resAux=null;
		Transaction transaccionActual=null;
		TipoViviendaMasVendido masVendido =new TipoViviendaMasVendido();
		
		try{
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
			TransactionManager.getInstance().newTransaction();
			
			 //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	     // Comprobamos si el tipo de vivienda introducido existe
	        resAux = (TTipoVivienda) masVendido.execute(null);
	        
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
