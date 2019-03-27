package presentacion.comandos.listadecomandos.negocio.departamento;

import negocio.departamento.TDepartamento;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoAltaDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		int idE =0;
		
		try{
			idE=FactoriaSA.getInstancia().generarSADepartamento().altaDepartamento((TDepartamento) datos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARALTADEPARTAMENTO,idE);
	}

}
