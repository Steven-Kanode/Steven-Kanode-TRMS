package kanode.steven.services;

import java.util.List;

import kanode.steven.models.GradebookFormat;
import kanode.steven.repositories.impl.GradebookFormatRepoImpl;

public class GradebookFormatServices {
	private GradebookFormatRepoImpl gfr;

	public GradebookFormatServices() {
		this.gfr = new GradebookFormatRepoImpl();
	}

	public GradebookFormat getGradebookFormat(int id) {
		return gfr.getGradebookFormat(id);
	}

	public List<GradebookFormat> getGradebookFormats() {
		return gfr.getAllGradebookFormats();
	}

	public boolean deleteGradebookFormat(int id) {
		return gfr.deleteGradebookFormat(id);
	}

	public boolean addGradebookFormat(GradebookFormat e) {
		return gfr.addGradebookFormat(e);
	}

	public boolean updateGradebookFormat(GradebookFormat e) {
		return gfr.updateGradebookFormat(e);
	}
}
