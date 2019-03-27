package presentacion.vistas.vistaTipoVivienda;

import presentacion.controlador.Contexto;

public abstract class VistaTipoVivienda {
private static VistaTipoVivienda instancia;
	
	public static VistaTipoVivienda getInstancia() {
			if (instancia == null){
				instancia = new VistaTipoViviendaImp();
			}
			return instancia;
	}
	
	public abstract void update(Contexto contexto);
}
