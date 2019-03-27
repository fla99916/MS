package negocio.tipoVivienda;

public class TChalet extends TTipoVivienda{
	private boolean jardin;
	private int plantas;
	
	public TChalet(){
		super();
	}
	
	public TChalet(int id, boolean jardin, int plantas, int cantidad, String direccion, String ciudad, double precio, boolean activo) {
		super(id, cantidad, direccion, ciudad, precio, activo);
		this.jardin = jardin;
		this.plantas = plantas;
	}
	
	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}
	
	public boolean getJardin() {
		return this.jardin;
	}
	
	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}
	
	public int getPlantas() {
		return this.plantas;
	}
	
	public String toString() {
		String s = super.toString();
		s += "CHALET: " + "\n";
		s += "JARDIN: ";
		s += this.jardin ? "SI\n" : "NO\n";
		s += "PLANTAS: " + plantas + "\n";
		s+= "-----------------------------------------"+ "\n";
		return s;
	}
}
