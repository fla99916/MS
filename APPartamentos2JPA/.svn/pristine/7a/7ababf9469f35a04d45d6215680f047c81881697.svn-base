package presentacion.comandos.listadecomandos.negocio.departamento;

import java.util.ArrayList;
import negocio.departamento.TDepartamento;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoListarDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		ArrayList<TDepartamento> idE = null;
		
		try{
			//Llamamos a la factoría del servicio de aplicación
			idE= FactoriaSA.getInstancia().generarSADepartamento().listaDepartamento();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARLISTARDEPARTAMENTO, idE);
	}

}
