package presentacion.comandos.listadecomandos.vista.ventanaCompra;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaSA;
import negocio.tipoVivienda.TTipoVivienda;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoActualizarVistaCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		ArrayList<TTipoVivienda> idE = null;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSATipoVivienda().listaTipoVivienda();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.VISTAACTUALIZACOMPRA, idE);
	}

}