package integracion.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.cliente.TCliente;

public class MaximoComprador implements Query {

	@SuppressWarnings("unused")
	@Override
	/**
	 * Query que recoge los datos del usuario con más compras realizadas.
	 * Si hay varios clientes con la misma cantidad de compras, 
	 * prioriza el cliente más antiguo (con la ID más baja).
	 * @return transfer con los datos del cliente consultado.
	 * @throws Exception
	 */
	public Object execute(Object data) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCliente tRes = null;
		String forUpdate = "FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if (tr == null)
				forUpdate = ""; 
			
			ps = cn.prepareStatement("SELECT idCliente, cliente.nombre, cliente.dni, cliente.direccion, cliente.ciudad, cliente.activo "
					+ "FROM cliente "
					+ "NATURAL JOIN compra "
					+ "WHERE cliente.activo = 1 AND compra.activo = 1 "
					+ "GROUP BY idCliente "
					+ "ORDER BY COUNT(*) DESC, idCliente ASC "
					+ "LIMIT 1 " + forUpdate);
			rs = ps.executeQuery();
			if(rs.next())
				tRes = new TCliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getBoolean(6));
			
		} catch (SQLException e) {
			new Exception();
		} 
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {
				new Exception();
			}
		}
		return tRes;
		
	}
	
}
