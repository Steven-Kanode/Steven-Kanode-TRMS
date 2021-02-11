package kanode.steven.services;

import java.util.List;

import kanode.steven.models.TuitionBalance;
import kanode.steven.repositories.impl.TuitionBalanceRepoImpl;

public class TuitionBalanceServices {
	private TuitionBalanceRepoImpl tbr;

	public TuitionBalanceServices() {
		this.tbr = new TuitionBalanceRepoImpl();
	}

	public TuitionBalance getTuitionBalance(int id) {
		return tbr.getTuitionBalance(id);
	}

	public List<TuitionBalance> getTuitionBalances() {
		return tbr.getAllTuitionBalances();
	}

	public boolean deleteTuitionBalance(int id) {
		return tbr.deleteTuitionBalance(id);
	}

	public boolean addTuitionBalance(TuitionBalance e) {
		return tbr.addTuitionBalance(e);
	}

	public boolean updateTuitionBalance(TuitionBalance e) {
		return tbr.updateTuitionBalance(e);
	}
}
