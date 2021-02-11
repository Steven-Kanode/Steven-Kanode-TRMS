package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.Transaction;
import kanode.steven.repositories.interfaces.TransactionRepoInt;
import kanode.steven.util.JDBCConnection;

public class TransactionRepoImpl implements TransactionRepoInt {
	public static Connection conn = JDBCConnection.getConnection();
	@Override
	public Transaction getTransaction(int id) {
		
		try {
			String sql = "SELECT * FROM TRANSACTIONS WHERE PK_TRANSACTION_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Transaction t = new Transaction();
				t.setTransactionAmount(rs.getDouble(1));
				t.setPK_TRANSACTION_ID(rs.getInt(2));
				t.setFK_TUITION_AMOUNTS_ID(rs.getInt(3));
				
				return t;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addTransaction(Transaction g) {
		
		try {
			String sql = "INSERT INTO TRANSACTIONS "
					+ "(TRANSACTION_AMOUNT, PK_TRANSACTION_ID, FK_TUITION_AMOUNTS_ID) "
					+ "VALUES (?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, g.getTransactionAmount());
			ps.setInt(2, g.getPK_TRANSACTION_ID());
			ps.setInt(3, g.getFK_TUITION_AMOUNTS_ID());
			ps.executeQuery();
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> Transactions = new ArrayList<Transaction>();
		
		try {
			String sql = "SELECT * FROM TRANSACTIONS";
			
			Statement ps = conn.createStatement();
			
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				Transaction t = new Transaction();
				t.setTransactionAmount(rs.getDouble(1));
				t.setPK_TRANSACTION_ID(rs.getInt(2));
				t.setFK_TUITION_AMOUNTS_ID(rs.getInt(3));
				Transactions.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Transactions;
	}

	@Override
	public boolean updateTransaction(Transaction g) {
		try {
			String sql = "UPDATE TRANSACTIONS "
					+ "SET TRANSACTION_AMOUNT = ?, PK_TRANSACTION_ID = ?, FK_TUITION_AMOUNTS_ID = ? "
					+ "WHERE PK_TRANSACTION_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, g.getTransactionAmount());
			ps.setInt(2, g.getPK_TRANSACTION_ID());
			ps.setInt(3, g.getFK_TUITION_AMOUNTS_ID());
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteTransaction(int id) {
		
		String sql = "DELETE from TRANSACTIONS where PK_TRANSACTION_ID = ?";
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
