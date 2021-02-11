package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.Transaction;

public interface TransactionRepoInt {	
	public Transaction getTransaction(int id);
	public boolean addTransaction(Transaction g);
	public List<Transaction> getAllTransactions();
	public boolean updateTransaction(Transaction g);
	public boolean deleteTransaction(int id);
}
