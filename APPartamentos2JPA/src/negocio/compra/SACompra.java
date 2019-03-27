package negocio.compra;

import java.util.ArrayList;

import negocio.compra.TCompra;

public interface SACompra {
	public int altaCompra(TCompra tCompra) throws Exception;
    public int bajaCompra(int id) throws Exception;
    public int modificarCompra(TCompra tCompra) throws Exception;
    public ArrayList<TCompra> listaCompra() throws Exception;
    public TCompra mostrarCompra (int id) throws Exception;
}
