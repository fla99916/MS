package presentacion.vistas.vistaEmpleado;


import java.util.ArrayList;


import negocio.empleado.TEmpleado;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class VistaEmpleadoImp extends VistaEmpleado {
	
private EmpleadoGUI vista;
	
	public VistaEmpleadoImp(){
		vista = new EmpleadoGUI();
	}

	@Override
	public void update(Contexto contexto) {
	int res;
	String msg = "";
	boolean exito;
		switch(contexto.getEvento()) {
		case ListaComandos.VISTAMENUEMPLEADO:
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
		break;
		case ListaComandos.CERRARVISTAEMPLEADO:
			vista.setVisible(false);
		break;
		case ListaComandos.MOSTRARALTAEMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			
			switch(res){
				case -1:
					exito = false;
					msg += "Error: Fallo al dar de alta el empleado ";
					break;
				case -2:
					exito = false;
					msg += "Error: Fallo al activar un empleado dado de baja";
					break;
				case -3:
					exito = false;
					msg +=  "Error: No existe el departamento indicado";
					break;
				case -4:
					exito = false;
					msg += "Error: Existe empleado con el mismo DNI";
					break;
				case -5:
					exito = false;
					msg += "Error: El departamento está dado de baja";
					break;
				case -6:
					exito = false;
					msg +="Error:  No se puede reactivar con tipo distinto";
					break;
				default:
					exito = true;
					msg += "Éxito al dar de alta el empleado ID: " + Integer.toString(res);
					break;
			}
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARBAJAEMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			
			switch(res){
			case -1:
				exito = false;
				msg += "Error: Fallo al dar de baja el empleado ";
				break;
			case -2:
				exito = false;
				msg += "No existe el empleado.";
				break;
			case -3:
				exito = false;
				msg +=  "El empleado ya esta dado de baja";
				break;
			default:
				exito = true;
				msg += "Éxito al dar de baja el empleado ID: " + Integer.toString(res);
				break;
			}
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARMODIFICAREMPLEADO:
			res = (int) contexto.getDatos();
			msg = "";
			
			switch(res){
				case -1:
					exito = false;
					msg += "Error: Fallo al modificar el empleado ";
					break;
				case -2:
					exito = false;
					msg += "Error: No existe el empleado";
					break;
				case -3:
					exito = false;
					msg +=  "Error: No existe el departamento indicado";
					break;
				case -4:
					exito = false;
					msg += "Error: El departamento está dado de baja";
					break;
				case -5:
					exito = false;
					msg += "Error: El empleado no corresponde el tipo que has elegido";
					break;
				case -6:
					exito = false;
					msg += "Error: Existe empleado con el mismo DNI";
					break;
				case -7:
					exito = false;
					msg += "Error: El empleado está dado de baja";
					break;
				default:
					exito = true;
					msg += "Éxito al modificar el empleado ID: " + Integer.toString(res);
					break;
			}
			
			
			vista.mensaje(msg, exito);
		break;
		case ListaComandos.MOSTRARCONSULTAREMPLEADO:
			TEmpleado emp = (TEmpleado) contexto.getDatos();
			msg = "";
			if(emp == null){
				msg = "El empleado no existe.";
			}else{
				msg = "Exito al consultar el empleado con ID: " + emp.getIdEmpleado() + ".";
			}
			
			vista.mostrarEmpleado(msg, emp);
		break;
		
		case ListaComandos.MOSTRARLISTAREMPLEADO:

			ArrayList<TEmpleado> listaEmpleados = (ArrayList<TEmpleado>)contexto.getDatos();
			
			if(listaEmpleados == null){
				msg += "Error: Base de datos vacía";
				exito = false;
			}
			else{
				msg += "Éxito al mostrar los " + listaEmpleados.size() + " empleado(s)";
				exito = true;
			}	
			
			if(listaEmpleados != null) {
				vista.setListField(listaEmpleados);
			} 
			
			vista.mensaje(msg, exito);
			
		break;
			
		}
		
	
		
		
	}

}
