package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.Gradebook;
import kanode.steven.repositories.interfaces.GradebookRepoInt;
import kanode.steven.util.JDBCConnection;

public class GradebookRepoImpl implements GradebookRepoInt {
	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Gradebook getGradebook(int id) {
		// TODO Auto-generated method stub
		
		
		try {
			String sql = "SELECT * FROM GRADEBOOKS WHERE PK_GRADEBOOKS_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Gradebook gb = new Gradebook();
				gb.setGradingFormat(rs.getInt(1));
				gb.setFinalScore(rs.getInt(2));
				gb.setPK_GRADEBOOKS_ID(rs.getInt(3));
				gb.setFK_EVENT_ID(rs.getInt(4));
				
				return gb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addGradebook(Gradebook g) {
		try {
			String sql = "INSERT INTO GRADEBOOKS " 
					+ "(FK_GRADING_FORMAT, FINAL_SCORE, PK_GRADEBOOKS_ID, FK_EVENT_ID) " 
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getGradingFormat());
			ps.setInt(2, g.getFinalScore());
			ps.setInt(3, g.getPK_GRADEBOOKS_ID());
			ps.setInt(4, g.getFK_EVENT_ID());
			ps.execute();
			return true;

		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Gradebook> getAllGradebooks() {
		List<Gradebook> gradebooks = new ArrayList<Gradebook>();

		try {
			String sql = "SELECT * FROM GRADEBOOKS";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				Gradebook gb = new Gradebook();
				gb.setFK_EVENT_ID(rs.getInt(1));;
				gb.setFinalScore(rs.getInt(2));
				gb.setPK_GRADEBOOKS_ID(rs.getInt(3));
				gb.setPK_GRADEBOOKS_ID(rs.getInt(4));
			}
			return gradebooks;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateGradebook(Gradebook e) {
		try {
			String sql = "UPDATE GRADEBOOKS "
					+ "SET FK_GRADING_FORMAT = ?, FINAL_SCORE = ?, PK_GRADEBOOKS_ID = ?, "
					+ "FK_EVENT_ID = ?"
					+ "WHERE PK_GRADEBOOKS_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getFK_EVENT_ID());
			ps.setInt(2, e.getFinalScore());
			ps.setInt(3, e.getPK_GRADEBOOKS_ID());
			ps.setInt(4, e.getFK_EVENT_ID());
			ps.execute();
			
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteGradebook(int id) {
		String sql = "DELETE from GRADEBOOKS where PK_GRADEBOOKS_ID = ?";
		try {
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
