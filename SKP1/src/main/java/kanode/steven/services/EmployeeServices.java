package kanode.steven.services;

import java.util.List;

import kanode.steven.models.Employee;
import kanode.steven.repositories.impl.EmployeeRepoImpl;

public class EmployeeServices {
	private EmployeeRepoImpl eri;
	
	public EmployeeServices() {
		this.eri = new EmployeeRepoImpl();
	}
	
	public Employee getEmployee(int id) {
		return eri.getEmployee(id);
	}
	
	public Employee getEmployeeLogin(String email, String password) {
		return eri.getEmployeeLogin(email, password);
	}
	
	public List<Employee> getEmployees(){
		return eri.getAllEmployees();
	}
	
	public boolean deleteEmployee(int id) {
		return eri.deleteEmployee(id);
	}
	
	public boolean addEmployee(Employee e) {
		return eri.addEmployee(e);
	}
	
	public boolean updateEmployee(Employee e) {
		return eri.updateEmployee(e);
	}
}
