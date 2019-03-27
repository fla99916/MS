package presentacion.despachador;

import presentacion.controlador.Contexto;

public abstract class Despachador {
	private static Despachador despachador;

	public static Despachador getInstancia() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (despachador == null)
			despachador = new DespachadorImp();
		return despachador;
	}

	public abstract void run(Contexto contexto);
}
