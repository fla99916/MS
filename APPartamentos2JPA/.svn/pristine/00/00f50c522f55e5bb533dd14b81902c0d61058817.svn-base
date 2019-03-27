package presentacion.vistas.vistaCliente;

import java.util.ArrayList;


import negocio.cliente.TCliente;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;


public class VistaClienteImp extends VistaCliente {
	private ClienteGUI vista;
	
	public VistaClienteImp(){
		vista = new ClienteGUI();
	}
	

	@Override
	public void update(Contexto contexto) {
		int id;
		String mensaje;
		TCliente tCliente;
		
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUCLIENTE:
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTACLIENTE:
			vista.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTACLIENTE:
			mensaje ="";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de alta el cliente ";
				break;
			case -2:
				mensaje += "Error: Fallo al activar un cliente dado de baja";
				break;
			case -3:
				mensaje += "Error: El cliente ya está dado de alta";
				break;
			default:
				mensaje += "Éxito al dar de alta el cliente ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
			vista.setIdField( (int)contexto.getDatos());
		break;
		case ListaComandos.MOSTRARBAJACLIENTE:
			mensaje ="";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de baja el cliente";
				break;
			case -2:
				mensaje += "Error: El cliente especificado ya estaba dado de baja";
				break;
			case -3:
				mensaje += "Error: El cliente no existe";
				break;
			default:
				mensaje += "Éxito al dar de baja el cliente ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARMODIFICARCLIENTE:
			mensaje ="";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al modificar el cliente";
				break;
			case -2:
				mensaje += "Error: El cliente especificado esta dado de baja";
				break;
			case -3:
				mensaje += "Error: El dni del cliente está en uso";
				break;
			case -4:
				mensaje += "Error: El cliente no existe";
				break;
			case -5:
				mensaje += "Error: El DNI está en uso";
				break;
			default:
				mensaje += "Éxito al modificar el cliente ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vista.mensaje(mensaje, "Exito");
			else
				vista.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARCONSULTARCLIENTE:
			mensaje ="";
			tCliente = (TCliente)contexto.getDatos();
			
			if (tCliente == null) {
				mensaje += "Error: El cliente no existe";
			}
			else {
				mensaje += "Éxito al mostrar el cliente ID: " + Integer.toString(tCliente.getId());
				
				
			}
			
			if(tCliente != null) {
				vista.mensaje(mensaje, "Exito");
				//vista.setDataFields(tCliente);
				vista.setClienttField(tCliente, "CLIENTE: \n");
			} else
				vista.mensaje(mensaje, "Error");
			break;
		case ListaComandos.MOSTRARLISTARCLIENTE:
			mensaje ="";
			@SuppressWarnings("unchecked")
			ArrayList<TCliente> listaClientes = (ArrayList<TCliente>)contexto.getDatos();
			
			switch(listaClientes.size()){
			case 0:
				mensaje += "Error: Base de datos vacía";
				break;
			default:
				mensaje += "Éxito al mostrar los " + listaClientes.size() + " cliente(s) de la base de datos";
				break;	
			}
			
			if(listaClientes.size() > 0) {
				vista.mensaje(mensaje, "Exito");
				vista.setListField(listaClientes);
			} else
				vista.mensaje(mensaje, "Error");
			break;
		case ListaComandos.MOSTRARMAXCOMPRADOCLIENTE:
			mensaje ="";
			tCliente = (TCliente)contexto.getDatos();
			
			if (tCliente == null) {
				mensaje += "Error: No hay clientes o compras en la base de datos";
			}
			else {
				mensaje += "Éxito al mostrar el cliente con más compras. ID: "+ Integer.toString(tCliente.getId());
			}
			
			if(tCliente != null) {
				vista.mensaje(mensaje, "Exito");
				
				//vista.setDataFields(tCliente);
				vista.setClienttField(tCliente, "MÁXIMO COMPRADOR: \n");
			} else
				vista.mensaje(mensaje, "Error");
			
			break;
		}
	}

}
