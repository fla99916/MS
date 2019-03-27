package negocio.factoriaSA;

import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.compra.SACompra;
import negocio.compra.SACompraImp;
import negocio.departamento.SADepartamento;
import negocio.departamento.SADepartamentoImp;
import negocio.empleado.SAEmpleado;
import negocio.empleado.SAEmpleadoImp;
import negocio.tipoVivienda.SATipoVivienda;
import negocio.tipoVivienda.SATipoViviendaImp;

public class FactoriaSAImp extends FactoriaSA {

	@Override
	public SACliente generarSACliente() {
		// TODO Auto-generated method stub
		return new SAClienteImp();
	}

	@Override
	public SATipoVivienda generarSATipoVivienda() {
		// TODO Auto-generated method stub
		return new SATipoViviendaImp();
	}

	@Override
	public SACompra generarSACompras() {
		// TODO Auto-generated method stub
		return new SACompraImp();
	}

	@Override
	public SAEmpleado generarSAEmpleado() {
		// TODO Auto-generated method stub
		return new SAEmpleadoImp();
	}

	@Override
	public SADepartamento generarSADepartamento() {
		// TODO Auto-generated method stub
		return new SADepartamentoImp();
	}
}
