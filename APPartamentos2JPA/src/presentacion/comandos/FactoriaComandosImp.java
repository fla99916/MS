package presentacion.comandos;

import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoAltaTipoVivienda;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoBajaTipoVivienda;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoConsultarTipoVivienda;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoListarTipoVivienda;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoModificarTipoVivienda;
import presentacion.comandos.listadecomandos.negocio.TipoVivienda.ComandoTipoViviendaMasVendido;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoAltaCliente;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoBajaCliente;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoConsultarCliente;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoListarCliente;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoMaxCompradoCliente;
import presentacion.comandos.listadecomandos.negocio.cliente.ComandoModificarCliente;
import presentacion.comandos.listadecomandos.negocio.compra.ComandoAltaCompra;
import presentacion.comandos.listadecomandos.negocio.compra.ComandoBajaCompra;
import presentacion.comandos.listadecomandos.negocio.compra.ComandoConsultarCompra;
import presentacion.comandos.listadecomandos.negocio.compra.ComandoListarCompra;
import presentacion.comandos.listadecomandos.negocio.compra.ComandoModificarCompra;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoAltaDepartamento;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoBajaDepartamento;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoListarDepartamento;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoModificarDepartamento;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoMostrarDepartamento;
import presentacion.comandos.listadecomandos.negocio.departamento.ComandoSueldoTotalDepartamento;
import presentacion.comandos.listadecomandos.negocio.empleado.ComandoAltaEmpleado;
import presentacion.comandos.listadecomandos.negocio.empleado.ComandoBajaEmpleado;
import presentacion.comandos.listadecomandos.negocio.empleado.ComandoListarEmpleado;
import presentacion.comandos.listadecomandos.negocio.empleado.ComandoModificarEmpleado;
import presentacion.comandos.listadecomandos.negocio.empleado.ComandoMostrarEmpleado;
import presentacion.comandos.listadecomandos.vista.ventanaCliente.ComandoAbrirVistaCliente;
import presentacion.comandos.listadecomandos.vista.ventanaCliente.ComandoCerrarVistaCliente;
import presentacion.comandos.listadecomandos.vista.ventanaCompra.ComandoAbrirVistaCompra;
import presentacion.comandos.listadecomandos.vista.ventanaCompra.ComandoActualizarVistaCompra;
import presentacion.comandos.listadecomandos.vista.ventanaCompra.ComandoCerrarVistaCompra;
import presentacion.comandos.listadecomandos.vista.ventanaDepartamento.ComandoAbrirVistaDepartamento;
import presentacion.comandos.listadecomandos.vista.ventanaDepartamento.ComandoCerrarVistaDepartamento;
import presentacion.comandos.listadecomandos.vista.ventanaEmpleado.ComandoAbrirVistaEmpleado;
import presentacion.comandos.listadecomandos.vista.ventanaEmpleado.ComandoCerrarVistaEmpleado;
import presentacion.comandos.listadecomandos.vista.ventanaPrincipal.*;
import presentacion.comandos.listadecomandos.vista.ventanaTipoVivienda.ComandoAbrirVistaTipoVivienda;
import presentacion.comandos.listadecomandos.vista.ventanaTipoVivienda.ComandoCerrarVistaTipoVivienda;
public class FactoriaComandosImp extends FactoriaComandos {

	@Override
	public Comando getComando(int evento) {
		Comando comando = null;
		switch (evento){
		//VISTAS
		case ListaComandos.VISTAMENUPRINCIPAL:
			comando = new ComandoAbrirVistaPrincipal();
		break;
		case ListaComandos.CERRARVISTAPRINCIPAL:
			comando = new ComandoCerrarVistaPrincipal();
		break;
		case ListaComandos.VISTAMENUCLIENTE:
			comando = new ComandoAbrirVistaCliente();
		break;
		case ListaComandos.CERRARVISTACLIENTE:
			comando = new ComandoCerrarVistaCliente();
		break;	
		case ListaComandos.VISTAMENUTIPOVIVIENDA:
			comando = new ComandoAbrirVistaTipoVivienda();
		break;
		case ListaComandos.CERRARVISTATIPOVIVIENDA:
			comando = new ComandoCerrarVistaTipoVivienda();
		break;
		case ListaComandos.VISTAMENUCOMPRA:
			comando = new ComandoAbrirVistaCompra();
		break;
		case ListaComandos.CERRARVISTACOMPRA:
			comando = new ComandoCerrarVistaCompra();
		break;
		case ListaComandos.VISTAACTUALIZACOMPRA:
			comando = new ComandoActualizarVistaCompra();
		break;

			
		//CLIENTE
		case ListaComandos.ALTACLIENTE:
			comando = new ComandoAltaCliente();
		break;
		case ListaComandos.BAJACLIENTE:
			comando = new ComandoBajaCliente();
		break;
		case ListaComandos.MODIFICARCLIENTE:
			comando = new ComandoModificarCliente();
		break;
		case ListaComandos.CONSULTARCLIENTE:
			comando = new ComandoConsultarCliente();
		break;
		case ListaComandos.LISTARCLIENTE:
			comando = new ComandoListarCliente();
		break;
		case ListaComandos.MAXCOMPRADOCLIENTE:
			comando = new ComandoMaxCompradoCliente();
		break;
		
		//TIPO VIVIENDA
		case ListaComandos.ALTATIPOVIVIENDA:
			comando = new ComandoAltaTipoVivienda();
		break;
		case ListaComandos.BAJATIPOVIVIENDA:
			comando = new ComandoBajaTipoVivienda();
		break;
		case ListaComandos.MODIFICARTIPOVIVIENDA:
			comando = new ComandoModificarTipoVivienda();
		break;
		case ListaComandos.CONSULTARTIPOVIVIENDA:
			comando = new ComandoConsultarTipoVivienda();
		break;
		case ListaComandos.LISTARTIPOVIVIENDA:
			comando = new ComandoListarTipoVivienda();
		break;
		case ListaComandos.TIPOVIVIENDAMASVENDIDO:
			comando = new ComandoTipoViviendaMasVendido();
		break;
		
		
		//COMPRA
		case ListaComandos.ALTACOMPRA:
			comando=new ComandoAltaCompra();
		break;
		case ListaComandos.BAJACOMPRA:
			comando=new ComandoBajaCompra();
		break;
		case ListaComandos.MODIFICARCOMPRA:
			comando= new ComandoModificarCompra(); 
		break;
		case ListaComandos.CONSULTARCOMPRA:
			comando=new ComandoConsultarCompra();
		break;	
		case ListaComandos.LISTARCOMPRA:
			comando= new ComandoListarCompra();
		break;
		
		//VISTAS DE JPA
		case ListaComandos.VISTAMENUEMPLEADO:
			comando = new ComandoAbrirVistaEmpleado();
		break;
		case ListaComandos.CERRARVISTAEMPLEADO:
			comando = new ComandoCerrarVistaEmpleado();
		break;
		case ListaComandos.VISTAMENUDEPARTAMENTO:
			comando = new ComandoAbrirVistaDepartamento();
		break;
		case ListaComandos.CERRARVISTADEPARTAMENTO:
			comando = new ComandoCerrarVistaDepartamento();
		break;
		
		//EMPLEADO
		case ListaComandos.ALTAEMPLEADO:
			comando = new ComandoAltaEmpleado();
		break;
		case ListaComandos.BAJAEMPLEADO:
			comando=new ComandoBajaEmpleado();
		break;
		case ListaComandos.MODIFICAREMPLEADO:
			comando= new ComandoModificarEmpleado(); 
		break;
		case ListaComandos.CONSULTAREMPLEADO:
			comando=new ComandoMostrarEmpleado();
		break;	
		case ListaComandos.LISTAREMPLEADO:
			comando= new ComandoListarEmpleado();
		break;
		
		
		//DEPARTAMENTO
		case ListaComandos.ALTADEPARTAMENTO:
			comando = new ComandoAltaDepartamento();
		break;
		case ListaComandos.BAJADEPARTAMENTO:
			comando=new ComandoBajaDepartamento();
		break;
		case ListaComandos.MODIFICARDEPARTAMENTO:
			comando= new ComandoModificarDepartamento(); 
		break;
		case ListaComandos.CONSULTARDEPARTAMENTO:
			comando=new ComandoMostrarDepartamento();
		break;	
		case ListaComandos.LISTARDEPARTAMENTO:
			comando= new ComandoListarDepartamento();
		break;
		case ListaComandos.SUELDODEPARTAMENTO:
			comando= new ComandoSueldoTotalDepartamento();
		break;
			
	}
		return comando;
	}

}
