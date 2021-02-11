package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.Gradebook;

public interface GradebookRepoInt {
	
	public Gradebook getGradebook(int id);
	public boolean addGradebook(Gradebook e);
	public List<Gradebook> getAllGradebooks();
	public boolean updateGradebook(Gradebook e);
	public boolean deleteGradebook(int id);
	
}
