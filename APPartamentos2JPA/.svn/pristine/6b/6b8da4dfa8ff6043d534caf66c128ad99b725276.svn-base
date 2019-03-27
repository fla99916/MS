package presentacion.comandos.listadecomandos.negocio.cliente;

import negocio.cliente.TCliente;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoModificarCliente implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		int idE=0;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSACliente().modificarCliente((TCliente) datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARMODIFICARCLIENTE, idE);
	}

}
