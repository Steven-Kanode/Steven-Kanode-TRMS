package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.Employee;
import kanode.steven.repositories.interfaces.EmployeeRepoInt;
import kanode.steven.util.JDBCConnection;

public class EmployeeRepoImpl implements EmployeeRepoInt {

	public static Connection conn = JDBCConnection.getConnection();

	// Tested and works
	@Override
	public Employee getEmployee(int id) {

		try {
			String sql = "SELECT * FROM Employees WHERE PK_EMPL_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e = new Employee();
				e.setfirstName(rs.getString(1));
				e.setlastName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setId(rs.getInt(4));
				e.setFK_SUPERVISOR_ID(rs.getInt(5));
				return e;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeeLogin(String email, String pass) {

		try {
			String sql = "select pk_empl_id from employees where email = ? AND employees.password = ? ";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("PK_EMPL_ID"));
				return e;

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	// Tested, works
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub

		try {
//		
			String sql = "INSERT INTO EMPLOYEES " + " (FIRST_NAME, LAST_NAME, EMAIL, FK_SUPERVISOR_ID) "
					+ " VALUES (?,?,?,?) ";

			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getfirstName());
			ps.setString(2, e.getlastName());
			ps.setString(3, e.getEmail());
			ps.setString(4, Integer.toString(e.getFK_SUPERVISOR_ID()));
			System.out.println("66");
			ps.execute();
			System.out.println("68");
			return true;
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Employee e = new Employee();
		try {
			String sql = "SELECT * FROM Employees";

			Statement ps = conn.createStatement();

			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				e.setfirstName(rs.getString(1));
				e.setlastName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setId(rs.getInt(4));
				e.setFK_SUPERVISOR_ID(rs.getInt(5));
				employees.add(e);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return employees;
	}

	@Override
	// tested works
	public boolean updateEmployee(Employee change) {
		// TODO Auto-generated method stub

		Employee e = change;
		try {
			String sql = "UPDATE EMPLOYEES " + "SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, FK_SUPERVISOR_ID = ? "
					+ "WHERE PK_EMPL_ID = ? ";

			System.out.println(sql);
//			Statement s = conn.createStatement();
//			s.execute(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getfirstName());
			ps.setString(2, e.getlastName());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getPK_EMPLOYEE_ID());
			ps.setInt(5, e.getFK_SUPERVISOR_ID());

			ps.executeQuery();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		String sql = "DELETE from EMPLOYEES where PK_EMPL_ID = ?";
		try {
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
