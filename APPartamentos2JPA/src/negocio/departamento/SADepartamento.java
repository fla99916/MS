package negocio.departamento;

import java.util.ArrayList;

public interface SADepartamento {
	public int altaDepartamento(TDepartamento datos);
	public int bajaDepartamento(int id);
	public int modificarDepartamento(TDepartamento d);
	public TDepartamento mostrarDepartamento(int id);
	public ArrayList<TDepartamento> listaDepartamento();
	public double sueldoTotalDepartamento (int id);
}
