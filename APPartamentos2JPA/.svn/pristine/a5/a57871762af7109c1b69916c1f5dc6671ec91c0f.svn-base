package presentacion.comandos.listadecomandos.negocio.compra;


import negocio.compra.TCompra;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoModificarCompra implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		int idE=0;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSACompras().modificarCompra((TCompra) datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARMODIFICARCOMPRA, idE);
	}

}
