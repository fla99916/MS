package presentacion.comandos.listadecomandos.negocio.empleado;

import negocio.empleado.TEmpleado;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoModificarEmpleado implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		int idE=0;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSAEmpleado().modificarEmpleado((TEmpleado) datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARMODIFICAREMPLEADO, idE);
	}

}
