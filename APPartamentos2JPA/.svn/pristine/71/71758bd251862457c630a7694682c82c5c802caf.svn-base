package presentacion.comandos.listadecomandos.negocio.departamento;

import negocio.departamento.TDepartamento;
import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoMostrarDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		TDepartamento idE = null;
		
		try{
			idE=FactoriaSA.getInstancia().generarSADepartamento().mostrarDepartamento((int)datos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARCONSULTARDEPARTAMENTO,idE);
	}

}
