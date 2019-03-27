package presentacion.comandos.listadecomandos.vista.ventanaCliente;

import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAbrirVistaCliente implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		// TODO Auto-generated method stub
		return new Contexto(ListaComandos.VISTAMENUCLIENTE, datos);
	}
}
