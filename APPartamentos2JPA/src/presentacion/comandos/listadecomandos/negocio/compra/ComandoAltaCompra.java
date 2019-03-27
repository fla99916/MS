package presentacion.comandos.listadecomandos.negocio.compra;

import negocio.compra.TCompra;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAltaCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		int idE =0;
		
		try{
			idE=FactoriaSA.getInstancia().generarSACompras().altaCompra((TCompra) datos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARALTACOMPRA,idE);
	}

}
