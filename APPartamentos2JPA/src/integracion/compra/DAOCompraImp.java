package integracion.compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.compra.TCompra;
import negocio.compra.TLineaCompra;


public class DAOCompraImp implements DAOCompra {

	/**
	 * Creación de una compra  en la base de datos.
	 * @param t Transfer de la compra
	 * @return id de la compra
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	@Override
	public int create(TCompra t) throws Exception {
		int res = 0; 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
		
			ps = cn.prepareStatement("SELECT * "
					+ "FROM compra "
					+ "WHERE idCompra = ?");
			ps.setInt(1, t.getIdCompra());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				TCompra tEncontrado = new TCompra (rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getBoolean(4));
				if(tEncontrado.getActivo()) {
					
				}
				else {
					ps = cn.prepareStatement("UPDATE compra "
							+ "SET activo = true"
							+ "WHERE idCompra = ?");
					ps.setInt(1, t.getIdCompra());
					rs = ps.executeQuery();
				}
			}
			else {
				ps = cn.prepareStatement("INSERT INTO compra (idCliente, fecha, activo) "
						+ "VALUES (?,?,?)");
				ps.setInt(1, t.getIdCliente());
				ps.setDate(2, t.getFecha());
				ps.setBoolean(3, t.getActivo());
				ps.executeUpdate();
				
				ps = cn.prepareStatement("SELECT LAST_INSERT_ID()");
				rs = ps.executeQuery();
				
				if (rs.next()) 
					res = rs.getInt("LAST_INSERT_ID()");
				
				for(TLineaCompra lc : t.getLineaCompra().values()) {
					ps = cn.prepareStatement("INSERT INTO lineacompra (idCompra, idTipoVivienda, cantidadComprada, precioTotal) "
							+ "VALUES (?,?,?,?)");
					ps.setInt(1, res);
					ps.setInt(2, lc.getId());
					ps.setInt(3, lc.getCantidadComprada());
					ps.setDouble(4, lc.getPrecioTotal());
					ps.executeUpdate();
				}
				
				for(TLineaCompra lc : t.getLineaCompra().values()) {
					ps = cn.prepareStatement("UPDATE tipovivienda "
							+ "SET cantidad = cantidad - ? "
							+ "WHERE idTipoVivienda = ?");
					ps.setInt(1, lc.getCantidadComprada());
					ps.setInt(2, lc.getId());
					ps.executeUpdate();
					
					int temp;
					ps = cn.prepareStatement("SELECT cantidad FROM tipovivienda "
							+ "WHERE idTipoVivienda = ? FOR UPDATE");
					ps.setInt(1, lc.getId());
					rs = ps.executeQuery();
					if (rs.next()) {
						temp = rs.getInt(1);
						if(temp < 0)
							return -1;
					}
				}
			}
		} catch (SQLException e) {
			throw e; 
		}
		finally{
			try 
			{
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close(); 
			} 
			catch (SQLException e) {
				throw new Exception(); 
			}
		}
		return res;
	}

	/**
	 * Actualiza los datos de una compra (incluyendo la line de compra)
	 * @param t transfer de la compra con los datos a poner en la base de datos
	 * @return 1 si se ha modificado, 0 si no (número de filas modificadas)
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	@Override
	public int update(TCompra t) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		int res = 0;
		
		try {
			tr =  TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			ps = cn.prepareStatement("UPDATE compra "
					+ "SET idCliente = ?, fecha = ?, activo = ? "
					+ "WHERE idCompra = ?");
			ps.setInt(1, t.getIdCliente());
			ps.setDate(2, t.getFecha());
			ps.setBoolean(3, t.getActivo());
			ps.setInt(4, t.getIdCompra());
			res = ps.executeUpdate();
			
			ArrayList<Integer> lista = new ArrayList<Integer>();
			ps = cn.prepareStatement("SELECT idTipoVivienda "
					+ "FROM lineacompra "
					+ "WHERE idCompra = ? FOR UPDATE");
			ps.setInt(1, t.getIdCompra());
			rs = ps.executeQuery();
			while(rs.next()) {
				lista.add(rs.getInt(1));
			}
			
			for(TLineaCompra lc : t.getLineaCompra().values()) {
				ps = cn.prepareStatement("SELECT * "
						+ "FROM lineacompra "
						+ "WHERE idCompra = ? AND idTipoVivienda = ? FOR UPDATE");
				ps.setInt(1, t.getIdCompra());
				ps.setInt(2, lc.getId());

				rs = ps.executeQuery();
				if(rs.next()) {
					TLineaCompra temp;
					temp = new TLineaCompra(rs.getInt(2), rs.getInt(3), rs.getDouble(4));
					lista.remove((Object) temp.getId());
					if(temp.getCantidadComprada() > lc.getCantidadComprada()) {
						int dif = temp.getCantidadComprada() - lc.getCantidadComprada();
						ps = cn.prepareStatement("UPDATE tipovivienda "
								+ " SET cantidad = cantidad + ? "
								+ " WHERE idTipoVivienda = ?");
						ps.setInt(1, dif);
						ps.setInt(2, lc.getId());

						ps.executeUpdate();
						
						ps = cn.prepareStatement("UPDATE lineacompra "
								+ "SET cantidadComprada = ?,  precioTotal = ? "
								+ "WHERE idTipoVivienda = ? AND idCompra = ?");
						ps.setInt(1, lc.getCantidadComprada());
						ps.setDouble(2, lc.getPrecioTotal());
						ps.setInt(3, lc.getId());
						ps.setInt(4, t.getIdCompra());

						ps.executeUpdate();
					} else if (temp.getCantidadComprada() < lc.getCantidadComprada()) {
						int dif = lc.getCantidadComprada() - temp.getCantidadComprada();
						ps = cn.prepareStatement("UPDATE tipovivienda "
								+ " SET cantidad = cantidad - ? "
								+ " WHERE idTipoVivienda = ?");
						ps.setInt(1, dif);
						ps.setInt(2, lc.getId());

						ps.executeUpdate();
						
						ps = cn.prepareStatement("UPDATE lineacompra "
								+ "SET cantidadComprada = ?,  precioTotal = ? "
								+ "WHERE idTipoVivienda = ? AND idCompra = ?");
						ps.setInt(1, lc.getCantidadComprada());
						ps.setDouble(2, lc.getPrecioTotal());
						ps.setInt(3, lc.getId());
						ps.setInt(4, t.getIdCompra());

						ps.executeUpdate();
					}
				} else {
					ps = cn.prepareStatement("UPDATE tipovivienda "
							+ " SET cantidad = cantidad - ? "
							+ " WHERE idTipoVivienda = ?");
					ps.setInt(1, lc.getCantidadComprada());
					ps.setInt(2, lc.getId());

					ps.executeUpdate();
					
					ps = cn.prepareStatement("INSERT INTO lineacompra (idCompra, idTipoVivienda, cantidadComprada, precioTotal) "
							+ "VALUES (?,?,?,?)");
					ps.setInt(1, t.getIdCompra());
					ps.setInt(2, lc.getId());
					ps.setInt(3, lc.getCantidadComprada());
					ps.setDouble(4, lc.getPrecioTotal());

					ps.executeUpdate();
				}
			}
			
			for(Integer val: lista) {
				TLineaCompra temp = null;
				ps = cn.prepareStatement("SELECT * "
						+ "FROM lineacompra "
						+ "WHERE idCompra = ? FOR UPDATE");
				ps.setInt(1, t.getIdCompra());
				rs = ps.executeQuery();
				
				if(rs.next()) {
					temp = new TLineaCompra(rs.getInt(2), rs.getInt(3), rs.getDouble(4));
				}
				
				ps = cn.prepareStatement("UPDATE tipovivienda "
						+ "SET cantidad = cantidad + ? "
						+ "WHERE idTipoVivienda = ? ");
				ps.setInt(1, temp.getCantidadComprada());
				ps.setInt(2, temp.getId());
				res = ps.executeUpdate();
				
				ps = cn.prepareStatement("DELETE FROM lineacompra "
						+ "WHERE idTipoVivienda = ? AND idCompra = ?");
				ps.setInt(1, val);
				ps.setInt(2, t.getIdCompra());				
				
				ps.executeUpdate();
			}
			
			//Añadir flag para el modificar, este update solo funciona para baja
			
			/*for(TLineaCompra lc : t.getLineaCompra().values()) {
				ps = cn.prepareStatement("INSERT INTO lineacompra (idCompra, idTipoVivienda, cantidadComprada, precioTotal) "
						+ "VALUES (?,?,?,?)");
				ps.setInt(1, res);
				ps.setInt(2, lc.getId());
				ps.setInt(2, lc.getCantidadComprada());
				ps.setDouble(3, lc.getPrecioTotal());
				ps.executeUpdate();
			}*/
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try
			{
				if(ps != null)
					ps.close();
			}
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return res;
	}

	/**
	 * Lee los datos de una compra  con el id recibido por parámetro
	 * @param id dela compra a consultar
	 * @return transfer con los datos den la compra a consultar
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "resource" })
	@Override
	public TCompra read(int id) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCompra tRes = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if (tr == null)
				forUpdate = ""; 
			
			HashMap<Integer, TLineaCompra> tList = new HashMap<>();
			ps = cn.prepareStatement("SELECT * "
					+ "FROM lineacompra "
					+ "WHERE idCompra = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
				tList.put((Integer) rs.getInt(2), new TLineaCompra(rs.getInt(2),
						rs.getInt(3), rs.getDouble(4)));
			
			ps = cn.prepareStatement("SELECT * "
					+ "FROM compra "
					+ "WHERE idCompra = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
				tRes = new TCompra(rs.getInt(1), rs.getInt(2), rs.getDate(3),
						rs.getBoolean(4), tList);
			
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

	/**
	 * Recoge los datos de todos las compras activos guardadas en la base de datos
	 * @return ArrayList con los transfer de todos las compras
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Override
	public ArrayList<TCompra> list() throws Exception {
		ArrayList<TCompra> tList = new ArrayList<>();
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String forUpdate = " FOR UPDATE"; 
		int i = 0;
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if (tr == null)
				forUpdate = ""; 
			
			ps = cn.prepareStatement("SELECT * "
					+ "FROM compra "
					+ "WHERE activo = 1" + forUpdate);
			rs = ps.executeQuery();
			
			while(rs.next())
				tList.add(new TCompra(rs.getInt(1), rs.getInt(2), rs.getDate(3),
						rs.getBoolean(4)));
			
			for(TCompra t: tList) {
				HashMap<Integer, TLineaCompra> tLC = new HashMap<>();
				ps = cn.prepareStatement("SELECT * "
						+ "FROM lineacompra "
						+ "WHERE idCompra = ?" + forUpdate);
				ps.setInt(1, t.getIdCompra());
				rs = ps.executeQuery();
				while(rs.next()){
					tLC.put(/*(Integer) rs.getInt(1)*/i, new TLineaCompra(rs.getInt(2),rs.getInt(3), rs.getDouble(4)));
					++i;
				}
				i = 0;	
				t.setLineaCompra(tLC);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
		finally 
		{
			try 
			{
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
			} 
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return tList;
	}

}