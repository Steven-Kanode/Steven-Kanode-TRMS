package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.TuitionBalance;

public interface TuitionBalanceRepoInt {
	public TuitionBalance getTuitionBalance(int id);
	public boolean addTuitionBalance(TuitionBalance e);
	public List<TuitionBalance> getAllTuitionBalances();
	public boolean updateTuitionBalance(TuitionBalance e);
	public boolean deleteTuitionBalance(int id);
}
