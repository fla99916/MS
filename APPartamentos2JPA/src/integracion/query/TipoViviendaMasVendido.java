package integracion.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.tipoVivienda.TTipoVivienda;

public class TipoViviendaMasVendido implements Query {

	/**
	 * Query que recoge los datos del tipovivienda activos
	 * que se ha comprado mas. Si hay mas de un tipovivienda
	 * con la misma cantidad, prioriza el tipovivienda mas antiguo
	 * (idtipovivienda mas bajo).
	 * @return transfer con los datos del tipovivienda consultado.
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Override
	public Object execute(Object data) throws Exception {
		// TODO Auto-generated method stub
		
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		TTipoVivienda tTVivienda = null; 
		String forUpdate = " FOR UPDATE";
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if(tr==null)
				forUpdate="";
			
			ps = cn.prepareStatement("SELECT tipovivienda.*,COUNT(*)"+
									" FROM lineacompra"+
									" NATURAL JOIN tipovivienda"+
									" NATURAL JOIN compra "+
									" WHERE compra.activo=1 AND tipovivienda.activo=1"+
									" GROUP BY idTipoVivienda"+
									" ORDER BY COUNT(*)"+
									" DESC LIMIT 1" + forUpdate);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//public TTipoVivienda(int id, int cantidad, String direccion, String ciudad, double precio, boolean activo)
				tTVivienda = new TTipoVivienda(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getString(3), rs.getDouble(5), rs.getBoolean(6));
				
			}
		}catch(SQLException e){
			new Exception();
		}
		finally {
			try{
				if(ps != null)
					ps.close();
				if(rs != null)
					rs.close();
			}catch(SQLException e){
				new Exception();
			}
		}
		return tTVivienda;
		
	
	}

}
