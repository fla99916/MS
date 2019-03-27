package presentacion.controlador;

public class Contexto {

	private int evento;
	private Object datos;
	
	public Contexto(int e, Object d) {
		this.evento = e;
		this.datos = d;
	}

	public int getEvento() {
		return this.evento;
	}

	public Object getDatos() {
		return this.datos;
	}
}
