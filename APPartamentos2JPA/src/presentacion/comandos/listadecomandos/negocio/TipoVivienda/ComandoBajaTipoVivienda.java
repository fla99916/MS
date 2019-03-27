package presentacion.comandos.listadecomandos.negocio.TipoVivienda;

import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoBajaTipoVivienda implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		int idE = 0;
		try {
			//Llamamos a la factoría del servicio de aplicación
			//El dao se encarga de distinguir si es piso o chalet.
			idE = FactoriaSA.getInstancia().generarSATipoVivienda().bajaTipoVivienda((int)datos);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARBAJATIPOVIVIENDA, idE);
	}

}
