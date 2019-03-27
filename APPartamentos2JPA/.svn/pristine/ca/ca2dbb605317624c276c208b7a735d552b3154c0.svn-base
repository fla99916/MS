package negocio.compra;

import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.compra.DAOCompra;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.cliente.TCliente;


public class SACompraImp implements SACompra {

	@Override
	public int altaCompra(TCompra tCompra) throws Exception {
		int idErr = 0;
		@SuppressWarnings("unused")
		TCompra tComAux=null;
		TCliente cliAux = null;
        Transaction transaccionActual = null; 
        DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
        DAOCliente daoCli = FactoriaDAO.getInstancia().generarDAOCliente();

        try{
	        //El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
	        cliAux = daoCli.read(tCompra.getIdCliente());
	        
	        if(cliAux == null || !cliAux.getActivo()){
	        	idErr = -1; // No existe el cliente en la bd
	        	transaccionActual.rollback();
	        }
	        else{
	        	 idErr = dao.create(tCompra); // añadimos la compra a la bd
	 	         
	 	        if (idErr == 0){ 
	 	            idErr = -2;// error al añadir compra en la base de datos
	 	            transaccionActual.rollback();
	 	        } 
	 	        else{ 
	 	            transaccionActual.commit(); // dado de alta correctamente
	 	        } 
	        }
	              
        }
        finally {
            TransactionManager.getInstance().deleteTransaction();        	
        }
        
        return idErr;
	}

	@Override
	public int bajaCompra(int id) throws Exception {
		int idErr;
		TCompra tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.read(id);
	        if(tComAux != null) {
        		if(tComAux.getActivo()) {
        			tComAux.setActivo(false); // Se desactiva la compra
    	        	idErr = dao.update(tComAux); // Se actualiza la base de datos
    	        	
    	        	if(idErr == 0) {
    	        		idErr = -1; // Error en la base de datos al desactivarlo
    	        		transaccionActual.rollback();
    	        	} 
    	        	else {
    	        		idErr = tComAux.getIdCompra(); //Compra dada de baja correctamente
    	        		transaccionActual.commit();
    	        	}
        		}
        		else {
        			idErr = -2; // La compra ya está desactivada
	        		transaccionActual.rollback();
        		}
	        	
	        } 
	        else {
	        	idErr = -3; // La compra no existe
        		transaccionActual.rollback();
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public int modificarCompra(TCompra tCompra) throws Exception {
		int idErr;
		TCompra tComAux;
		TCliente cliAux = null;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		DAOCliente daoCli = FactoriaDAO.getInstancia().generarDAOCliente();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.read(tCompra.getIdCompra());
	        cliAux = daoCli.read(tCompra.getIdCliente());
	        
	        if(cliAux == null || !cliAux.getActivo()){
	        	idErr = -3; // No existe el cliente en la bd
	        	transaccionActual.rollback();
	        }
	        else{
		        if(tComAux != null) {
	        		if(tComAux.getActivo()) {
	    	        	idErr = dao.update(tCompra); // Se cambian los datos del cliente
	    	        	
	    	        	if(idErr == 0 || !cliAux.getActivo()) {
	    	        		idErr = -1; // no se ha conseguido editar los datos
	    	        		transaccionActual.rollback();
	    	        	} 
	    	        	else {
	    	        		idErr = tComAux.getIdCompra();// se han modificado los datos
	    	        		transaccionActual.commit();
	    	        	}
	        		}
	        		else {
	        			idErr = -2; // La compra estaba desactivado
		        		transaccionActual.rollback();
	        		}
		        } 
		        else {
		        	idErr = -4; // la compra no existe
	        		transaccionActual.rollback();
		        }
	        }
		}
		finally {
			TransactionManager.getInstance().deleteTransaction(); 
		}
		
		return idErr;
	}

	@Override
	public ArrayList<TCompra> listaCompra() throws Exception {
		ArrayList<TCompra> tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.list();
	        
	        // Hay usuarios en la base de datos
	        if(tComAux.size() > 0) {
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
		
		return tComAux;
	}

	@Override
	public TCompra mostrarCompra(int id) throws Exception {
		TCompra tComAux;
		Transaction transaccionActual = null; 
		DAOCompra dao = FactoriaDAO.getInstancia().generarDAOCompra();
		
		try {
			//El TM genera una nueva transaccion asociada a nuestra hebra de ejecucion
	        TransactionManager.getInstance().newTransaction(); 
	        
	        //Obtenemos la transaccion dada nuestra hebra
	        transaccionActual = TransactionManager.getInstance().getTransaction();
	        
	        //Empezamos la transaccion
	        transaccionActual.start();
	        
			// Comprobamos si el usuario introducido existe
	        tComAux = dao.read(id);
	        
	        // Existe el cliente en la base de datos
	        if(tComAux != null) {
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
		
		return tComAux;
	}

}
