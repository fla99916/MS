package integracion.transaccion.factory;

import integracion.transaccion.Transaction;
import integracion.transaccion.TransactionImp;

public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction createTransaction() throws Exception {
		return new TransactionImp();
	}

}
