package presentacion.comandos.listadecomandos.negocio.TipoVivienda;

import negocio.factoriaSA.FactoriaSA;
import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAltaTipoVivienda implements Comando  {

	@Override
	public Contexto ejecuta(Object datos) {
		int idE = 0;
		try {
			//Llamamos a la factoría del servicio de aplicación
			idE = FactoriaSA.getInstancia().generarSATipoVivienda().altaTipoVivienda((TTipoVivienda) datos);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARALTATIPOVIVIENDA, idE);
	}

}
