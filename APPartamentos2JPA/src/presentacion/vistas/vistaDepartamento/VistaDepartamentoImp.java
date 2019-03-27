package presentacion.vistas.vistaDepartamento;

import java.util.ArrayList;

import negocio.departamento.TDepartamento;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaDepartamentoImp extends VistaDepartamento{
	private DepartamentoGUI vistaDepartamento;

	public VistaDepartamentoImp(){
		vistaDepartamento = new DepartamentoGUI();
	}
	
	@Override
	public void update(Contexto contexto) {
		int id;
		String mensaje;
		TDepartamento tDepartamento;
		
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUDEPARTAMENTO:
			vistaDepartamento.setVisible(true);
			vistaDepartamento.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTADEPARTAMENTO:
			vistaDepartamento.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTADEPARTAMENTO:
			mensaje = "";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de alta el departamento ";
				break;
			case -2:
				mensaje += "Error: Fallo al activar un departamento dado de baja";
				break;
			case -3:
				mensaje += "Error: Existe departamento con el mismo nombre";
				break;
			default:
				mensaje += "Éxito al dar de alta el departamento ID: " + Integer.toString(id);
				break;	
			}
		
			if(id >= 1)
				vistaDepartamento.mensaje(mensaje, "Exito");
			else
				vistaDepartamento.mensaje(mensaje, "Error");
			vistaDepartamento.setIdField((int)contexto.getDatos());
		break;
		case ListaComandos.MOSTRARBAJADEPARTAMENTO:
			mensaje = "";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al dar de baja el departamento ";
				break;
			case -2:
				mensaje += "Error: El departamento no existe";
				break;
			case -3:
				mensaje += "Error: El departamento especificado ya estaba dado de baja";
				break;
			case -4:
				mensaje += "Error: El departamento tiene empleados activos ";
				break;
			default:
				mensaje += "Éxito al dar de baja el departamento ID: " + Integer.toString(id);
				break;	
			}
		
			if(id >= 1)
				vistaDepartamento.mensaje(mensaje, "Exito");
			else
				vistaDepartamento.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARMODIFICARDEPARTAMENTO:
			mensaje ="";
			id = (int)contexto.getDatos();
			
			switch(id){
			case -1:
				mensaje += "Error: Fallo al modificar el departamento";
				break;
			case -2:
				mensaje += "Error: El departamento no existe";
				break;
			case -3:
				mensaje += "Error: El departamento especificado esta dado de baja";
				break;
			case -4:
				mensaje += "Error: El nombre del departamentoe está en uso";
				break;
			case -5:
				mensaje += "Error: Has intentado cambiar un director a agente inmobiliario o viceversa";
				break;
			default:
				mensaje += "Éxito al modificar el departamento ID: " + Integer.toString(id);
				break;	
			}
			
			if(id >= 1)
				vistaDepartamento.mensaje(mensaje, "Exito");
			else
				vistaDepartamento.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARCONSULTARDEPARTAMENTO:
			mensaje ="";
			tDepartamento = (TDepartamento)contexto.getDatos();
			
			if (tDepartamento == null) {
				mensaje += "Error: El departamento no existe";
			}
			else {
				mensaje += "Éxito al mostrar el departamento ID: " + Integer.toString(tDepartamento.getIdDepartamento());
				
				
			}
			
			if(tDepartamento != null) {
				vistaDepartamento.mensaje(mensaje, "Exito");
				vistaDepartamento.setDepartamento(tDepartamento);
			} else
				vistaDepartamento.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARLISTARDEPARTAMENTO:
			mensaje ="";
			ArrayList<TDepartamento> listaDepartamentos = (ArrayList<TDepartamento>)contexto.getDatos();
			
			switch(listaDepartamentos.size()){
			case 0:
				mensaje += "Error: Base de datos vacía";
				break;
			default:
				mensaje += "Éxito al mostrar los " + listaDepartamentos.size() + " departamento(s) de la base de datos";
				break;	
			}
			
			if(listaDepartamentos.size() > 0) {
				vistaDepartamento.mensaje(mensaje, "Exito");
				vistaDepartamento.setDepartamentos(listaDepartamentos);
			} else
				vistaDepartamento.mensaje(mensaje, "Error");
		break;
		case ListaComandos.MOSTRARSUELDODEPARTAMENTO:
			mensaje = "";
			double sueldoTotal = -3;
			sueldoTotal = (double)contexto.getDatos();
			if(sueldoTotal <= 0){
				if(sueldoTotal == -1){
					mensaje += "Error: No hay departamento indicado en la base de datos";
				}
				else if(sueldoTotal == -2){
					mensaje += "Departamento inactivo";
				}
				else if(sueldoTotal == -3){
					mensaje += "El departamento no tiene ningún empleado";
				}
				else{
					mensaje += "error";
				}				
				vistaDepartamento.mensaje(mensaje, "Error");
			}
			else{
				mensaje += "Éxito en calcular el sueldo";
				vistaDepartamento.mensaje(mensaje, "Exito");
				vistaDepartamento.setSueldoDepartamento(sueldoTotal);
			}
		break;
		}
		
	}
}
	

