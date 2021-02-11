package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.Department;
import kanode.steven.repositories.interfaces.ModelRepoInt;
import kanode.steven.util.JDBCConnection;

public class DepartmentRepoImpl implements ModelRepoInt{
	
	public static Connection conn = JDBCConnection.getConnection();
	
	//tested works
	@SuppressWarnings("unchecked")
	@Override
	public Department getModel(int id) {
		
		try {
			String sql = "SELECT * FROM Departments WHERE PK_DEPARTMENT_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Department d = new Department();
				d.setPK_DEPARTMENT_ID(rs.getInt("PK_DEPARTMENT_ID"));
				d.setName(rs.getString("NAME"));
				d.setFK_DEPARTMENT_HEAD_EMPLOYEE_ID(rs.getInt("FK_DEPARTMENT_HEAD_EMPLOYEE_ID"));
				
				return d;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//tested works
	@Override
	public <T> boolean addModel(T d) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO DEPARTMENTS "
					+ "(NAME, FK_DEPARTMENT_HEAD_EMPLOYEE_ID) "
					+ "VALUES (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ((Department) d).getName());
			ps.setInt(2, ((Department) d).getFK_DEPARTMENT_HEAD_EMPLOYEE_ID());
		
			ps.executeQuery();
		
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//tested works
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllModel() {
		// TODO Auto-generated method stub
		List<Department> departments = new ArrayList<Department>();
		
		try {
			String sql = "SELECT * FROM Departments";
			
			Statement ps = conn.createStatement();
		
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				Department d = new Department();
				d.setPK_DEPARTMENT_ID(rs.getInt("PK_DEPARTMENT_ID"));
				d.setName(rs.getString("NAME"));
				d.setFK_DEPARTMENT_HEAD_EMPLOYEE_ID(rs.getInt("FK_DEPARTMENT_HEAD_EMPLOYEE_ID"));
				departments.add(d);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}
	
	//tested works
	
	@Override
	public <T> boolean updateModel(T change) {
		
		
		try {
			String sql = "UPDATE DEPARTMENTS "
					+ "SET NAME = ?, FK_DEPARTMENT_HEAD_EMPLOYEE_ID = ? "
					+ "WHERE PK_DEPARTMENT_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ((Department) change).getName());
			ps.setInt(2, ((Department) change).getFK_DEPARTMENT_HEAD_EMPLOYEE_ID());
			ps.setInt(3, ((Department) change).getPK_DEPARTMENT_ID());
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteModel(int id) {
		String sql = "DELETE from departments where PK_DEPARTMENT_ID = ?";
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
