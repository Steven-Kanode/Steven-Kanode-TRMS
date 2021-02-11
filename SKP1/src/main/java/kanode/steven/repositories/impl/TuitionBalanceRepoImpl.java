package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.TuitionBalance;
import kanode.steven.repositories.interfaces.TuitionBalanceRepoInt;
import kanode.steven.util.JDBCConnection;

public class TuitionBalanceRepoImpl implements TuitionBalanceRepoInt {
	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public TuitionBalance getTuitionBalance(int id) {
		System.out.println(id);
		conn = JDBCConnection.getConnection();
		try {
			String sql = "SELECT * FROM TUITION_BALANCES WHERE PK_TUITION_AMOUNTS_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				TuitionBalance tb = new TuitionBalance();
				tb.setAmountLeft(rs.getInt("Amount_left"));
				tb.setAmountPending(rs.getInt("Amount_pending"));
				tb.setAmountApproved(rs.getInt("Amount_approved"));
				tb.setPK_TUITION_AMOUNTS_ID(rs.getInt("PK_TUITION_AMOUNTS_ID"));
				System.out.println(tb.toString());
				return tb;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean addTuitionBalance(TuitionBalance tb) {
		
		try {
			String sql = "INSERT INTO TUITION_BALANCES "
					+ "(AMOUNT_LEFT, AMOUNT_PENDING, AMOUNT_APPROVED, PK_TUITION_AMOUNTS_ID) "
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, tb.getAmountLeft());
			ps.setDouble(2, tb.getAmountPending());
			ps.setDouble(3, tb.getAmountApproved());
			ps.executeQuery();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TuitionBalance> getAllTuitionBalances() {
		
		List<TuitionBalance> tbs = new ArrayList<TuitionBalance>();
		
		try {
			String sql = "SELECT * FROM TRANSACTION_BALANCES";
			
			Statement ps = conn.createStatement();
			
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				TuitionBalance tb = new TuitionBalance();
				tb.setAmountLeft(rs.getDouble(1));
				tb.setAmountPending(rs.getDouble(2));
				tb.setAmountApproved(rs.getDouble(3));
				tb.setPK_TUITION_AMOUNTS_ID(rs.getInt(4));
				tbs.add(tb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tbs;
	}

	@Override
	public boolean updateTuitionBalance(TuitionBalance tb) {
		try {
			String sql = "UPDATE TUITION_BALANCES "
					+ "SET AMOUNT_LEFT = ?, AMOUNT_PENDING = ?, AMOUNT_APPROVED = ?, PK_TUITION_AMOUNTS_ID = ? "
					+ "WHERE PK_TUITION_AMOUNTS_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, tb.getAmountLeft());
			ps.setDouble(2, tb.getAmountPending());
			ps.setDouble(3, tb.getAmountApproved());
			ps.setInt(4, tb.getPK_TUITION_AMOUNTS_ID());
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteTuitionBalance(int id) {
		String sql = "DELETE from TuitionBalance where PK_TUITION_AMOUNTS_ID = ?";
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
