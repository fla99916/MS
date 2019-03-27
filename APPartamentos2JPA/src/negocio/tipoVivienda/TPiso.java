package negocio.tipoVivienda;

public class TPiso extends TTipoVivienda{
	private boolean portero;
	private int numAscensores;
	
	public TPiso(){
		super();
	}
	
	public TPiso(int id, boolean portero, int numAscensores, int cantidad, String direccion, String ciudad, double precio, boolean activo) {
		super(id, cantidad, direccion, ciudad, precio, activo);
		this.portero = portero;
		this.numAscensores = numAscensores;
	}
	
	public void setPortero(boolean portero) {
		this.portero = portero;
	}
	
	public boolean getPortero() {
		return this.portero;
	}
	
	public void setNumAscensores(int numAscensores) {
		this.numAscensores = numAscensores;
	}
	
	public int getNumAscensores() {
		return this.numAscensores;
	}
	
	public String toString() {
		String s = super.toString();
		s += "PISO: " + "\n";
		s += "PORTERO: ";
		s += this.portero ? "SI\n" : "NO\n";
		s += "ASCENSORES: " + numAscensores + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
