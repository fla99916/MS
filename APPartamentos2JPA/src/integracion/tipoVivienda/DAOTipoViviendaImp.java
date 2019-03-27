package integracion.tipoVivienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.tipoVivienda.TTipoVivienda;
import negocio.tipoVivienda.TPiso;
import negocio.tipoVivienda.TChalet;

public class DAOTipoViviendaImp implements DAOTipoVivienda {
	@SuppressWarnings("resource")
	
	/**
	 * Creación de un tipovivienda en la base de datos.
	 * @param t Transfer del tipovivienda
	 * @return id del tipovivienda creado, 0 si no se crea
	 * @throws Exception
	 */
	@Override
	public int create(TTipoVivienda t) throws Exception {
		int res = 0; 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
		
			ps = cn.prepareStatement("INSERT INTO tipovivienda (cantidad, direccion, ciudad, precio, activo) "
					+ "VALUES (?,?,?,?,?)");
			ps.setInt(1, t.getCantidad());
			ps.setString(2, t.getDireccion());
			ps.setString(3, t.getCiudad());
			ps.setDouble(4, t.getPrecio());
			ps.setBoolean(5, t.getActivo());
			ps.executeUpdate();
			
			ps = cn.prepareStatement("SELECT LAST_INSERT_ID()");
			rs = ps.executeQuery();
			
			if (rs.next()) 
				res = rs.getInt("LAST_INSERT_ID()");
			
			if(t instanceof TPiso){
				ps = cn.prepareStatement("INSERT INTO piso (idTipoVivienda, portero, numAscensores) "
						+ "VALUES (?,?,?)");
				ps.setInt(1, res);
				ps.setBoolean(2, ((TPiso) t).getPortero());
				ps.setInt(3, ((TPiso) t).getNumAscensores());
				ps.executeUpdate();
				
			}else if(t instanceof TChalet){
				ps = cn.prepareStatement("INSERT INTO chalet (idTipoVivienda, jardin, plantas) "
						+ "VALUES (?,?,?)");
				ps.setInt(1, res);
				ps.setBoolean(2, ((TChalet) t).getJardin());
				ps.setInt(3, ((TChalet) t).getPlantas());
				ps.executeUpdate();
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
	 * Actualiza los datos del tipovivienda que corresponde a la 
	 * id introducida por parámetro
	 * @param t transfer de tipovivienda con los datos a poner en la base de datos
	 * @return 1 si se ha modificado, 0 si no (número de filas modificadas)
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	@Override
	public int update(TTipoVivienda t) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		int res = 0;
		
		try {
			tr =  TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			ps = cn.prepareStatement("UPDATE tipovivienda "
					+ "SET cantidad = ?, direccion = ?, ciudad = ?, precio = ?, activo = ? "
					+ "WHERE idTipoVivienda = ?");
			ps.setInt(1, t.getCantidad());
			ps.setString(2, t.getDireccion());
			ps.setString(3, t.getCiudad());
			ps.setDouble(4, t.getPrecio());
			ps.setBoolean(5, t.getActivo());
			ps.setInt(6, t.getId());
			res = ps.executeUpdate();
			if(res != 0){
				res = t.getId();
				
				
				if(t instanceof TPiso){
					ps = cn.prepareStatement("SELECT * "
							+ "FROM piso "
							+ "NATURAL JOIN tipovivienda "
							+ "WHERE idTipoVivienda = ? FOR UPDATE");
					ps.setInt(1, t.getId());
					rs = ps.executeQuery();
					
					if(rs.next()){
						ps = cn.prepareStatement("UPDATE piso "
								+ "SET portero = ?, numAscensores = ? "
								+ "WHERE idTipoVivienda = ?");
						ps.setBoolean(1, ((TPiso) t).getPortero());
						ps.setInt(2, ((TPiso) t).getNumAscensores());
						ps.setInt(3, ((TPiso) t).getId());
						ps.executeUpdate();
					} else {
						ps = cn.prepareStatement("INSERT INTO piso (idTipoVivienda, portero, numAscensores) "
								+ "VALUES (?,?,?)");
						ps.setInt(1, res);
						ps.setBoolean(2, ((TPiso) t).getPortero());
						ps.setInt(3, ((TPiso) t).getNumAscensores());
						ps.executeUpdate();
						
						ps = cn.prepareStatement("DELETE FROM chalet  "
								+ "WHERE idTipoVivienda = ?");
						ps.setInt(1, t.getId());
						ps.executeUpdate();
					}
				}else if(t instanceof TChalet){
					ps = cn.prepareStatement("SELECT * "
							+ "FROM chalet "
							+ "NATURAL JOIN tipovivienda "
							+ "WHERE idTipoVivienda = ? FOR UPDATE");
					ps.setInt(1, t.getId());
					rs = ps.executeQuery();
					
					if(rs.next()){
						ps = cn.prepareStatement("UPDATE chalet "
								+ "SET jardin = ?, plantas = ? "
								+ "WHERE idTipoVivienda = ?");
						ps.setBoolean(1, ((TChalet) t).getJardin());
						ps.setInt(2, ((TChalet) t).getPlantas());
						ps.setInt(3, ((TChalet) t).getId());
						ps.executeUpdate();
					} else {
						ps = cn.prepareStatement("INSERT INTO chalet (idTipoVivienda, jardin, plantas) "
								+ "VALUES (?,?,?)");
						ps.setInt(1, ((TChalet) t).getId());
						ps.setBoolean(2, ((TChalet) t).getJardin());
						ps.setInt(3, ((TChalet) t).getPlantas());
						ps.executeUpdate();
						
						ps = cn.prepareStatement("DELETE FROM piso  "
								+ "WHERE idTipoVivienda = ?");
						ps.setInt(1, t.getId());
						ps.executeUpdate();
					}
				}
			}
	
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try
			{
				if (rs != null)
					rs.close();
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
	 * Lee los datos de tipovivienda con el id recibido por parámetro
	 * @param id de la tipovivienda consultada
	 * @return transfer con los datos de la tipovivienda consultado, null si no existe
	 * @throws Exception
	 */
	@SuppressWarnings({ "resource", "unused" })
	@Override
	public TTipoVivienda read(int id) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TTipoVivienda tRes = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			//Para el DAO de Bilbao
			if (tr == null){
				forUpdate = "";
			}
			
			ps = cn.prepareStatement("SELECT idTipoVivienda, chalet.jardin, chalet.plantas, tipovivienda.cantidad, "
					+ "tipovivienda.direccion, tipovivienda.ciudad, tipovivienda.precio, tipovivienda.activo "
					+ "FROM chalet "
					+ "NATURAL JOIN tipovivienda "
					+ "WHERE idTipoVivienda = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				tRes = new TChalet(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getBoolean(8));
			}else{
				ps = cn.prepareStatement("SELECT idTipoVivienda, piso.portero, piso.numAscensores, tipovivienda.cantidad, "
						+ "tipovivienda.direccion, tipovivienda.ciudad, tipovivienda.precio, tipovivienda.activo "
						+ "FROM piso "
						+ "NATURAL JOIN tipovivienda "
						+ "WHERE idTipoVivienda = ?" + forUpdate);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					tRes = new TPiso(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), 
							rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getBoolean(8));
				
				}
			}
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
	 * Lee los datos de tipovivienda con la direccion que recibe por parametrosro
	 * @param direccion del tipovivienda consultado
	 * @return transfer con los datos del tipovivienda consultado, null si no existe
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@Override
	public TTipoVivienda readByDireccion(String direccion) throws Exception {
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TTipoVivienda tViv = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if (tr == null)
				forUpdate = ""; 
			
			ps = cn.prepareStatement("SELECT * "
					+ "FROM tipovivienda "
					+ "WHERE direccion = ?" + forUpdate);
			ps.setString(1, direccion);
			rs = ps.executeQuery();
			
			if(rs.next())
				//TTipoVivienda(int id, int cantidad, String direccion, String ciudad, double precio, boolean activo)
				tViv = new TTipoVivienda(rs.getInt(1), rs.getInt(4), rs.getString(2),
						rs.getString(3), rs.getDouble(5), rs.getBoolean(6));
			
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
		return tViv;
	}

	/**
	 * Recoge los datos de todas las tipoviviendas activos guardados en la base de datos
	 * @return ArrayList con los transfer de todos los tiposvivienda con sus tipo especificado
	 * {Chalet, Piso}
	 * @throws Exception
	 */
	@SuppressWarnings({ "resource", "unused" })
	@Override
	public ArrayList<TTipoVivienda> list() throws Exception {
		ArrayList<TTipoVivienda> tList = new ArrayList<TTipoVivienda>();
		Transaction tr = null;
		Connection cn = null;
		Statement st = null; 
		ResultSet rs = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			if (tr == null)
				forUpdate = ""; 
			
			st = cn.createStatement();
			rs = st.executeQuery("SELECT idTipoVivienda, chalet.jardin, chalet.plantas, tipovivienda.cantidad, "
					+ "tipovivienda.direccion, tipovivienda.ciudad, tipovivienda.precio, tipovivienda.activo "
					+ "FROM chalet "
					+ "NATURAL JOIN tipovivienda "
					+ "WHERE tipovivienda.activo = 1" + forUpdate);
			
			while(rs.next())
				tList.add(new TChalet(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getBoolean(8)));
			
			rs = st.executeQuery("SELECT idTipoVivienda, piso.portero, piso.numAscensores, tipovivienda.cantidad, "
					+ "tipovivienda.direccion, tipovivienda.ciudad, tipovivienda.precio, tipovivienda.activo "
					+ "FROM piso "
					+ "NATURAL JOIN tipovivienda "
					+ "WHERE tipovivienda.activo = 1" + forUpdate);
			
			while(rs.next())
				tList.add(new TPiso(rs.getInt(1), rs.getBoolean(2), rs.getInt(3), rs.getInt(4), 
						rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getBoolean(8)));
			
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
				if(st != null)
					st.close();
			} 
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return tList;
	}
}
