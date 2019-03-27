package presentacion.comandos.listadecomandos.negocio.TipoVivienda;

import negocio.factoriaSA.FactoriaSA;
import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoTipoViviendaMasVendido implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		TTipoVivienda idE = null;
		try {
			//Llamamos a la factoría del servicio de aplicación

			//El dao se encarga de distinguir si es piso o chalet.
			idE = FactoriaSA.getInstancia().generarSATipoVivienda().tviviendaMasVendido();

		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return new Contexto (ListaComandos.MOSTRARTIPOVIVIENDAMASVENDIDO, idE);
	}

}
