package presentacion.vistas.vistaCliente;

import presentacion.controlador.Contexto;

public abstract class VistaCliente {
	private static VistaCliente instancia;
	
	public static VistaCliente getInstancia() {
			if (instancia == null){
				instancia = new VistaClienteImp();
			}
			return instancia;
	}
	
	public abstract void update(Contexto contexto);

}
