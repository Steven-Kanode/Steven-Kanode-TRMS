package kanode.steven.services;

import java.util.List;

import kanode.steven.models.Department;
import kanode.steven.repositories.impl.DepartmentRepoImpl;

public class DepartmentServices {
	
	private DepartmentRepoImpl dri;
	public DepartmentServices() {
		this.dri = new DepartmentRepoImpl();
	}
	
	public Department getDepartment(int id) {
		return dri.getModel(id);
	}
	
	public List<Department> getDepartments(){
		return dri.getAllModel();
	}
	
	public boolean deleteDepartment(int id) {
		return dri.deleteModel(id);
	}
	
	public boolean addDepartment(Department e) {
		return dri.addModel(e);
	}
	
	public boolean updateDepartment(Department e) {
		return dri.updateModel(e);
	}
}
