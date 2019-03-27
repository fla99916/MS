package integracion.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import integracion.transaccion.Transaction;
import integracion.transaccion.manager.TransactionManager;
import negocio.cliente.TCliente;

public class DAOClienteImp implements DAOCliente{
	@SuppressWarnings("resource")
	
	/**
	 * Creación de un cliente en la base de datos.
	 * @param t Transfer del cliente
	 * @return id del cliente creado, 0 si no se crea
	 * @throws Exception
	 */
	public int create(TCliente t) throws Exception {
		int res = 0; 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
		
			ps = cn.prepareStatement("INSERT INTO cliente (nombre, dni, direccion, ciudad, activo) "
					+ "VALUES (?,?,?,?,?)");
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getDni());
			ps.setString(3, t.getDireccion());
			ps.setString(4, t.getCiudad());
			ps.setBoolean(5, t.getActivo());
			ps.executeUpdate();
			
			ps = cn.prepareStatement("SELECT LAST_INSERT_ID()");
			rs = ps.executeQuery();
			
			if (rs.next()) 
				res = rs.getInt("LAST_INSERT_ID()");
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
	 * Eliminación de un cliente de la base de datos, no se utilizará en la baja
	 * @param id del usuario eliminado
	 * @return 1 si se ha borrado, 0 si no (número de filas borradas)
	 * @throws Exception
	 */
	/*public int delete(int id) throws Exception {
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null; 
		int res = 0; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			ps = cn.prepareStatement("DELETE FROM cliente "
					+ "WHERE idcliente = ?");
			ps.setInt(1, id);
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try
			{
				if (cn != null)
					cn.close();
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {e.printStackTrace();}
		}
		return res; 
	}*/

	/**
	 * Actualiza los datos del cliente que correcponde a la 
	 * id introducida por parámetro
	 * @param t transfer del cliente con los datos a poner en la base de datos
	 * @return 1 si se ha modificado, 0 si no (número de filas modificadas)
	 * @throws Exception
	 */
	public int update(TCliente t) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		int res = 0;
		
		try {
			tr =  TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			ps = cn.prepareStatement("UPDATE cliente "
					+ "SET nombre = ?, dni = ?, direccion = ?, ciudad = ?, activo = ? "
					+ "WHERE idcliente = ?");
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getDni());
			ps.setString(3, t.getDireccion());
			ps.setString(4, t.getCiudad());
			ps.setBoolean(5, t.getActivo());
			ps.setInt(6, t.getId());
			res = ps.executeUpdate();
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
	 * Lee los datos del cliente con el id recibido por parámetro
	 * @param id del cliente consultado
	 * @return transfer con los datos del cliente consultado, null si no existe
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public TCliente read(int id) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCliente tRes = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			
			//Para el DAO de Bilbao
			if (tr == null){
				forUpdate = "";
			}
				 
			
			ps = cn.prepareStatement("SELECT * "
					+ "FROM cliente "
					+ "WHERE idcliente = ?" + forUpdate);
			ps.setInt(1, id);
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

	/**
	 * Lee los datos del cliente con el dni recibido por parámetro
	 * @param dni del cliente consultado
	 * @return transfer con los datos del cliente consultado, null si no existe
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public TCliente readByDNI(String dni) throws Exception {
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCliente tRes = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			//Para el DAO de Bilbao
			if (tr == null){
				forUpdate = "";
			}
			
			ps = cn.prepareStatement("SELECT * "
					+ "FROM cliente "
					+ "WHERE dni = ?" + forUpdate);
			ps.setString(1, dni);
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

	/**
	 * Recoge los datos de todos los clientes activos guardados en la base de datos
	 * @return ArrayList con los transfer de todos los clientes existentes 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public ArrayList<TCliente> list() throws Exception {
		ArrayList<TCliente> tList = new ArrayList<TCliente>();
		Transaction tr = null;
		Connection cn = null;
		Statement st = null; 
		ResultSet rs = null;
		String forUpdate = " FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = tr.getResource();
			
			//Para el DAO de Bilbao
			if (tr == null){
				forUpdate = "";
			} 
			
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * "
					+ "FROM cliente "
					+ "WHERE activo = 1" + forUpdate);
			while(rs.next())
				tList.add(new TCliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getBoolean(6)));
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
