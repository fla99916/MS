package presentacion.controlador;

import presentacion.comandos.Comando;
import presentacion.comandos.FactoriaComandos;
import presentacion.despachador.Despachador;

public class ControladorImp extends Controlador {
	
	

	@Override
	public void run(int evento, Object datos) {
		// TODO Auto-generated method stub
		
		//Obtenemos la instancia de nuestra factoría de comandos
		FactoriaComandos factoriaComandos = FactoriaComandos.getInstancia();
		
		//Nuestra factoría de comandos genera un comando dado un evento
		Comando comando = factoriaComandos.getComando(evento);
		
		//El comando nos devuelve un objeto contexto para encapsular la información
		Contexto contexto = comando.ejecuta(datos);
		
		//Obtenemos la instancia de nuestro despachador
		Despachador despachador = Despachador.getInstancia();
		
		//El despachador ejecuta la información
		despachador.run(contexto);
	}

}
