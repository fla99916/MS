package integracion.transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TransactionImp implements Transaction{
	private Connection connection;

	@Override
	public void start() throws Exception {		
		try{

			connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost/apartamentos","root", "");
			connection.setAutoCommit(false);
			System.out.print("Database is connected !");
		}
		catch(SQLException e){
			System.out.print("Do not connect to DB - Error: \n"+e);
		}
		
	}

	/*private Properties cargaProperties() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void commit() throws Exception {
		try {
			this.connection.commit();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rollback() throws Exception {
		try {
			this.connection.rollback();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getResource() {
		return connection;
	}

}
