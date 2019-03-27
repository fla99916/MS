package presentacion.vistas.vistaDepartamento;

import presentacion.controlador.Contexto;

public abstract class VistaDepartamento {
	private static VistaDepartamento instancia;
	
	public static VistaDepartamento getInstancia(){
		if(instancia == null){
			instancia = new VistaDepartamentoImp();
		}
		
		return instancia;
	}
	public abstract void update(Contexto contexto);
}
