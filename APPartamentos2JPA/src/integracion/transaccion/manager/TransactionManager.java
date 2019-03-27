package integracion.transaccion.manager;

import integracion.transaccion.Transaction;

public abstract class TransactionManager {
	private static TransactionManager transactionManager;


	public synchronized static TransactionManager getInstance() {
		if(transactionManager == null)
			transactionManager = new TransactionManagerImp();
		return transactionManager;
	}

	public abstract Transaction newTransaction() throws Exception;

	
	public abstract Transaction getTransaction();

	
	public abstract boolean deleteTransaction();
}
