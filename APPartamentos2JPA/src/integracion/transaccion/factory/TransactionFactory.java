package integracion.transaccion.factory;

import integracion.transaccion.Transaction;

public abstract class TransactionFactory {
	private static TransactionFactory transactionFactory;


	public static synchronized TransactionFactory getInstancia() {
		if(transactionFactory == null)
			transactionFactory = new TransactionFactoryImp();
		return transactionFactory;
	}

	public abstract Transaction createTransaction() throws Exception;
}
