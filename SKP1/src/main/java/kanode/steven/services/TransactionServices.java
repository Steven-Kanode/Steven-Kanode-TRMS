package kanode.steven.services;

import java.util.List;

import kanode.steven.models.Transaction;
import kanode.steven.repositories.impl.TransactionRepoImpl;

public class TransactionServices {
	private TransactionRepoImpl tri;

	public TransactionServices() {
		this.tri = new TransactionRepoImpl();
	}

	public Transaction getTransaction(int id) {
		return tri.getTransaction(id);
	}

	public List<Transaction> getTransactions() {
		return tri.getAllTransactions();
	}

	public boolean deleteTransaction(int id) {
		return tri.deleteTransaction(id);
	}

	public boolean addTransaction(Transaction e) {
		return tri.addTransaction(e);
	}

	public boolean updateTransaction(Transaction e) {
		return tri.updateTransaction(e);
	}
}
