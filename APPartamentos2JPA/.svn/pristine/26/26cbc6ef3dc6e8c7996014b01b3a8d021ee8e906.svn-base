package presentacion.vistas.vistaPrincipal;

import presentacion.controlador.Contexto;

public abstract class VistaPrincipal {
	
	private static VistaPrincipal instancia;
	
	public static VistaPrincipal getInstancia() {
			if (instancia == null){
				instancia = new VistaPrincipalImp();
			}
			return instancia;
	}
	
	public abstract void update(Contexto contexto);

}
