package presentacion.comandos.listadecomandos.negocio.empleado;

import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoBajaEmpleado implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
int idE=0;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSAEmpleado().bajaEmpleado((int) datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARBAJAEMPLEADO, idE);
	}
}
