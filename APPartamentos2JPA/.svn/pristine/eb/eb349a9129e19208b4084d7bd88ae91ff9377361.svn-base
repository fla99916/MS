package integracion.factoriaDAO;

import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.compra.DAOCompra;
import integracion.compra.DAOCompraImp;
import integracion.tipoVivienda.DAOTipoVivienda;
import integracion.tipoVivienda.DAOTipoViviendaImp;

public class FactoriaDAOImp extends FactoriaDAO {

	@Override
	public DAOCliente generarDAOCliente() {
		return new DAOClienteImp();
	}

	@Override
	public DAOTipoVivienda generarDAOTipoVivienda() {
		return new DAOTipoViviendaImp();
	}

	@Override
	public DAOCompra generarDAOCompra() {
		return new DAOCompraImp();
	}
}
