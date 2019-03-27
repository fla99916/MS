package negocio.cliente;



import java.util.ArrayList;

public interface SACliente {
	public int altaCliente(TCliente tCliente) throws Exception;
    public int bajaCliente(int id) throws Exception;
    public int modificarCliente(TCliente tCliente) throws Exception;
    public ArrayList<TCliente> listaCliente() throws Exception;
    public TCliente mostrarCliente (int id) throws Exception;
	public TCliente maximoClienteComprador() throws Exception;
	//public TResultado maximoClienteComprador() throws Exception;
}
