package presentacion.comandos.listadecomandos.negocio.empleado;

import negocio.empleado.TEmpleado;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoMostrarEmpleado implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		TEmpleado idE = null;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSAEmpleado().mostrarEmpleado((int)datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARCONSULTAREMPLEADO, idE);
	}

}
