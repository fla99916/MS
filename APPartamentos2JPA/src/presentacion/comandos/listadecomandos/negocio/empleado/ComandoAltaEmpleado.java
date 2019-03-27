package presentacion.comandos.listadecomandos.negocio.empleado;

//import negocio.empleado.SAEmpleado;
import negocio.empleado.TEmpleado;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAltaEmpleado implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		int idE = 0;
		try {
			//Llamamos a la factoría del servicio de aplicación
			idE = FactoriaSA.getInstancia().generarSAEmpleado().altaEmpleado((TEmpleado) datos);
			//FactoriaSA factSA = FactoriaSA.getInstancia();
			//SAEmpleado sae = factSA.generarSAEmpleado();
			//idE = sae.altaEmpleado((TEmpleado) datos);
			
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARALTAEMPLEADO, idE);
	}

}
