package presentacion.despachador;

import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCliente.VistaCliente;
import presentacion.vistas.vistaCompra.VistaCompra;
import presentacion.vistas.vistaDepartamento.VistaDepartamento;
import presentacion.vistas.vistaEmpleado.VistaEmpleado;
import presentacion.vistas.vistaPrincipal.VistaPrincipal;
import presentacion.vistas.vistaTipoVivienda.VistaTipoVivienda;

public class DespachadorImp extends Despachador {
	@Override
	public void run(Contexto contexto) {
		// TODO Auto-generated method stub
		switch (contexto.getEvento()) 
		{
			// Vista Principal
			case ListaComandos.VISTAMENUPRINCIPAL:
			case ListaComandos.CERRARVISTAPRINCIPAL:
				VistaPrincipal.getInstancia().update(contexto);
			break;
			
			//Vista Clientes
			case ListaComandos.VISTAMENUCLIENTE:
			case ListaComandos.CERRARVISTACLIENTE:
				VistaCliente.getInstancia().update(contexto);
			break;
			
			//Clientes
			case ListaComandos.MOSTRARALTACLIENTE:
			case ListaComandos.MOSTRARBAJACLIENTE:
			case ListaComandos.MOSTRARMODIFICARCLIENTE:
			case ListaComandos.MOSTRARCONSULTARCLIENTE:
			case ListaComandos.MOSTRARLISTARCLIENTE:
			case ListaComandos.MOSTRARMAXCOMPRADOCLIENTE:
				VistaCliente.getInstancia().update(contexto);
				
			//Vista TipoVivienda
			case ListaComandos.VISTAMENUTIPOVIVIENDA:
			case ListaComandos.CERRARVISTATIPOVIVIENDA:
				VistaTipoVivienda.getInstancia().update(contexto);
			break;	
			
			//Tipo Vivienda
			case ListaComandos.MOSTRARALTATIPOVIVIENDA:
			case ListaComandos.MOSTRARBAJATIPOVIVIENDA:
			case ListaComandos.MOSTRARMODIFICARTIPOVIVIENDA:
			case ListaComandos.MOSTRARCONSULTARTIPOVIVIENDA:
			case ListaComandos.MOSTRARLISTARTIPOVIVIENDA:
			case ListaComandos.MOSTRARTIPOVIVIENDAMASVENDIDO:
				VistaTipoVivienda.getInstancia().update(contexto);
			break;
				
			//Vista Compra
			case ListaComandos.VISTAMENUCOMPRA:
			case ListaComandos.CERRARVISTACOMPRA:
			case ListaComandos.VISTAACTUALIZACOMPRA:
				VistaCompra.getInstancia().update(contexto);
			break;
			
			//Compra
			case ListaComandos.MOSTRARALTACOMPRA:
			case ListaComandos.MOSTRARBAJACOMPRA:
			case ListaComandos.MOSTRARMODIFICARCOMPRA:
			case ListaComandos.MOSTRARCONSULTARCOMPRA:
			case ListaComandos.MOSTRARLISTARCOMPRA:
				VistaCompra.getInstancia().update(contexto);
			break;
			
			//JPA
			
			
			//Vista Empleado
			case ListaComandos.VISTAMENUEMPLEADO:
			case ListaComandos.CERRARVISTAEMPLEADO:
			case ListaComandos.MOSTRARALTAEMPLEADO:
			case ListaComandos.MOSTRARBAJAEMPLEADO:
			case ListaComandos.MOSTRARMODIFICAREMPLEADO:
			case ListaComandos.MOSTRARCONSULTAREMPLEADO:
			case ListaComandos.MOSTRARLISTAREMPLEADO:
				VistaEmpleado.getInstancia().update(contexto);
			break;
			
			//Departamento
			case ListaComandos.MOSTRARALTADEPARTAMENTO:
			case ListaComandos.MOSTRARBAJADEPARTAMENTO:
			case ListaComandos.MOSTRARMODIFICARDEPARTAMENTO:
			case ListaComandos.MOSTRARCONSULTARDEPARTAMENTO:
			case ListaComandos.MOSTRARLISTARDEPARTAMENTO:
			case ListaComandos.MOSTRARSUELDODEPARTAMENTO:
			
			//Vista Departamento
			case ListaComandos.VISTAMENUDEPARTAMENTO:
			case ListaComandos.CERRARVISTADEPARTAMENTO:
				VistaDepartamento.getInstancia().update(contexto);
			break;
		}
	}
}
