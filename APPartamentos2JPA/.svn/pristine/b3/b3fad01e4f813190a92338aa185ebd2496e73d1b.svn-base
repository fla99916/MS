package presentacion.vistas.vistaEmpleado;

import presentacion.controlador.Contexto;


public abstract class VistaEmpleado {
private static VistaEmpleado instancia;
	
	public static VistaEmpleado getInstancia(){
		
		if(instancia==null){
			instancia=new VistaEmpleadoImp();
		}
		
		return instancia;
	}

	public abstract void update(Contexto contexto);

}
