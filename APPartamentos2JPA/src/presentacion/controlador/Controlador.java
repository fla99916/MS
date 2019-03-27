package presentacion.controlador;

public abstract class Controlador {
	private static Controlador controller;

	public static Controlador getInstance() {
		{
			if (controller == null)
				controller = new ControladorImp();
			return controller;
		}
	}

	public abstract void run(int evento, Object datos);
}
