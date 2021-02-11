package kanode.steven.repositories.interfaces;

import java.util.List;

import kanode.steven.models.Employee;

public interface EmployeeRepoInt {
	
	public Employee getEmployee(int id);
	public boolean addEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(int id);
}
