package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.GradebookFormat;

public interface GradebookFormatRepoInt {
	public GradebookFormat getGradebookFormat(int id);
	public boolean addGradebookFormat(GradebookFormat g);
	public List<GradebookFormat> getAllGradebookFormats();
	public boolean updateGradebookFormat(GradebookFormat g);
	public boolean deleteGradebookFormat(int id);
}
