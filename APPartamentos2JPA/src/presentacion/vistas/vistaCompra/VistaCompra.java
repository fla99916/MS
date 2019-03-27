package presentacion.vistas.vistaCompra;

import presentacion.controlador.Contexto;

public abstract class VistaCompra {
	private static VistaCompra instancia;
	
	public static VistaCompra getInstancia(){
		
		if(instancia==null){
			instancia=new VistaCompraImp();
		}
		
		return instancia;
	}

	public abstract void update(Contexto contexto);
}
