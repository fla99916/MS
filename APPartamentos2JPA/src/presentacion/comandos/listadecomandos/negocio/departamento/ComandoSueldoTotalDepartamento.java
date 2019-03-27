package presentacion.comandos.listadecomandos.negocio.departamento;


import negocio.factoriaSA.FactoriaSA;
import presentacion.comandos.Comando;
import presentacion.comandos.listadecomandos.ListaComandos;
import presentacion.controlador.Contexto;

public class ComandoSueldoTotalDepartamento implements Comando{

	@Override
	public Contexto ejecuta(Object datos) {
		double idE = 0;
		
		try{
			idE=FactoriaSA.getInstancia().generarSADepartamento().sueldoTotalDepartamento((int) datos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Contexto(ListaComandos.MOSTRARSUELDODEPARTAMENTO,idE);
	}

}
