package presentacion.comandos.listadecomandos.negocio.cliente;

import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoBajaCliente implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		int idE=0;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSACliente().bajaCliente((int) datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARBAJACLIENTE, idE);
	}

}
