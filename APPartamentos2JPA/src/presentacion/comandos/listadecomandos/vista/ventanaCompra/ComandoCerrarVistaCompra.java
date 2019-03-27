package presentacion.comandos.listadecomandos.vista.ventanaCompra;

import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoCerrarVistaCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		return new Contexto(ListaComandos.CERRARVISTACOMPRA, datos);
	}

}
