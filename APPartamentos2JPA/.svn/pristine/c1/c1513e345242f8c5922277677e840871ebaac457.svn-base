package presentacion.comandos.listadecomandos.negocio.cliente;

import java.util.ArrayList;

import negocio.cliente.TCliente;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarCliente implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		ArrayList<TCliente> idE = null;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSACliente().listaCliente();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARLISTARCLIENTE, idE);
	}

}