package kanode.steven.controllers;
//
//import kanode.steven.models.Event;
//import kanode.steven.repositories.impl.DepartmentRepoImpl;
import kanode.steven.repositories.impl.EventRepoImpl;

public class testingtesttest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //DepartmentRepoImpl dri = new DepartmentRepoImpl();
		
//		Department d = dri.getDepartment(66);
//		System.out.println(d.toString());
//		Department d = new Department();
//		d.setFK_DEPARTMENT_HEAD_EMPLOYEE_ID(1);
//		d.setName("Steven's Big Boy Camp");
//		dri.addModel(d);
////		
//		List<Department> d = dri.getAllModel();
//		for (Department dp : d) {
//			System.out.println(dp.toString());
//		}
		
//		Department d = new Department(66, 1, "Get it boy");
//		System.out.println(d.toString());
//		dri.updateDepartment(d);
//		dri.deleteDepartment(135);
		
//		EmployeeRepoImpl eri = new EmployeeRepoImpl();
//////		
//		Employee e = new Employee("Stover", "Kanode", "nope", 1);
//		System.out.println(e.toString());
//		eri.deleteEmployee(e.getPK_EMPLOYEE_ID());
		 
		//Event event = new Event();
		EventRepoImpl eri = new EventRepoImpl();
		System.out.println(eri.getEvent(1).toString());
//		
	}
	
}
