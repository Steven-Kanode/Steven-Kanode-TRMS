package kanode.steven.services;

import java.util.List;

import kanode.steven.models.Gradebook;
import kanode.steven.repositories.impl.GradebookRepoImpl;

public class GradebookServices {
	private GradebookRepoImpl etr;
	
	public GradebookServices() {
		this.etr = new GradebookRepoImpl();
	}
	
	public Gradebook getGradebook(int id) {
		return etr.getGradebook(id);
	}
	
	public List<Gradebook> getGradebooks(){
		return etr.getAllGradebooks();
	}
	
	public boolean deleteGradebook(int id) {
		return etr.deleteGradebook(id);
	}
	
	public boolean addGradebook(Gradebook e) {
		return etr.addGradebook(e);
	}
	
	public boolean updateGradebook(Gradebook e) {
		return etr.updateGradebook(e);
	}
}
