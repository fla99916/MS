package presentacion.comandos.listadecomandos.negocio.cliente;



import negocio.cliente.TCliente;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoConsultarCliente implements Comando {

	@Override
	public Contexto ejecuta(Object datos) {
		TCliente idE = null;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSACliente().mostrarCliente((int)datos);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return new Contexto(ListaComandos.MOSTRARCONSULTARCLIENTE, idE);
	}

}