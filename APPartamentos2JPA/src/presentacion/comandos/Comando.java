package presentacion.comandos;

import presentacion.controlador.Contexto;

public interface Comando {
	public abstract Contexto ejecuta(Object datos);
}
