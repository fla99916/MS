package integracion.factoriaDAO;

import integracion.cliente.DAOCliente;
import integracion.compra.DAOCompra;
import integracion.tipoVivienda.DAOTipoVivienda;

public abstract class FactoriaDAO {
	private static FactoriaDAO factDAO;


	public synchronized static FactoriaDAO getInstancia() {
		if(FactoriaDAO.factDAO == null)
			return new FactoriaDAOImp(); 
		else
			return FactoriaDAO.factDAO;
	}

	public abstract DAOCliente generarDAOCliente();
	
	public abstract DAOTipoVivienda generarDAOTipoVivienda();

	public abstract DAOCompra generarDAOCompra();

}

