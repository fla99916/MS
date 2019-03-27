package integracion.transaccion.manager;

import integracion.transaccion.Transaction;
import integracion.transaccion.factory.TransactionFactory;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager {

	private ConcurrentHashMap<Thread, Transaction> concurrentHM;
	
	public TransactionManagerImp(){
		this.concurrentHM = new ConcurrentHashMap<Thread, Transaction>(); 
	}
	
	@Override
	public Transaction newTransaction() throws Exception {
		Transaction newTran = null; 

		if(!this.concurrentHM.containsKey(Thread.currentThread())){
			newTran = TransactionFactory.getInstancia().createTransaction();
			this.concurrentHM.put(Thread.currentThread(), newTran);
			return newTran; 
		}
		else
			return this.concurrentHM.get(Thread.currentThread());
	}

	@Override
	public Transaction getTransaction() {
		return this.concurrentHM.get(Thread.currentThread());
	}

	@Override
	public boolean deleteTransaction() {
		if(this.concurrentHM.contains(Thread.currentThread())){
			this.concurrentHM.remove(Thread.currentThread());
			return true;
		}
		return false;
	}

}
