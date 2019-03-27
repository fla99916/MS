package negocio.tipoVivienda;



import java.util.ArrayList;

public interface SATipoVivienda {
	public int altaTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception;
    public int bajaTipoVivienda(int id) throws Exception;
    public int modificarTipoVivienda(TTipoVivienda tTipoVivienda) throws Exception;
    public ArrayList<TTipoVivienda> listaTipoVivienda() throws Exception;
    public TTipoVivienda mostrarTipoVivienda (int id) throws Exception;
    public TTipoVivienda tviviendaMasVendido () throws Exception;
    //public TResultado tviviendaMasVendido () throws Exception;
}
