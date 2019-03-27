package negocio.factoriaSA;

import negocio.cliente.SACliente;
import negocio.compra.SACompra;
import negocio.departamento.SADepartamento;
import negocio.empleado.SAEmpleado;
import negocio.tipoVivienda.SATipoVivienda;

public abstract class FactoriaSA {
	private static FactoriaSA factSA;

	public static synchronized FactoriaSA getInstancia()
	{
		if (factSA == null){
                    factSA = new FactoriaSAImp();
                }
		return factSA;
	}

	//Métodos para crear los diferentes SA
	public abstract SACliente generarSACliente();
	public abstract SATipoVivienda generarSATipoVivienda();
	public abstract SACompra generarSACompras();
	
	public abstract SAEmpleado generarSAEmpleado();
	public abstract SADepartamento generarSADepartamento();
}
