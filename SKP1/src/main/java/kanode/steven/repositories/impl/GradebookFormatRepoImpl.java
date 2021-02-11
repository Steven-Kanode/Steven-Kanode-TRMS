package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.GradebookFormat;
import kanode.steven.repositories.interfaces.GradebookFormatRepoInt;
import kanode.steven.util.JDBCConnection;

public class GradebookFormatRepoImpl implements GradebookFormatRepoInt {
	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public GradebookFormat getGradebookFormat(int id) {
		try {
			String sql = "SELECT * FROM GRADEBOOK_FORMATS WHERE PK_GRADEBOOK_FORMAT = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {

				GradebookFormat gb = new GradebookFormat();
				gb.setPK_GRADEBOOK_FORMAT(rs.getInt(1));
				gb.setGradingType(rs.getString(2));
		
				return gb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addGradebookFormat(GradebookFormat g) {
		try {
			String sql = "INSERT INTO GRADEBOOK_FORMATS " 
					+ "(PK_GRADEBOOK_FORMAT, GRADING_TYPE) " 
					+ "VALUES (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getPK_GRADEBOOK_FORMAT());
			ps.setString(2, g.getGradingType());
			ps.execute();
		
			return true;

		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public List<GradebookFormat> getAllGradebookFormats() {
		
		List<GradebookFormat> gbf = new ArrayList<GradebookFormat>();

		try {
			String sql = "SELECT * FROM GRADEBOOK_FORMATS";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				GradebookFormat gf = new GradebookFormat();
				gf.setPK_GRADEBOOK_FORMAT(rs.getInt(1));
				gf.setGradingType(rs.getString(2));
				gbf.add(gf);
			}
			return gbf;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateGradebookFormat(GradebookFormat g) {
		
		try {
			String sql = "UPDATE GRADEBOOK_FORMATS "
					+ "SET PK_GRADEBOOK_FORMAT = ?, GRADING_TYPE = ? "
					+ "WHERE PK_GRADEBOOK_FORMAT = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getPK_GRADEBOOK_FORMAT());
			ps.setString(2, g.getGradingType());
			ps.execute();
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGradebookFormat(int id) {
		String sql = "DELETE from GradebookFormats where PK_GRADEBOOK_FORMAT = ?";
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
