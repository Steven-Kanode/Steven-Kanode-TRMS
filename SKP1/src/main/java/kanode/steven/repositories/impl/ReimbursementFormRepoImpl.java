package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.EmployeeEventReview;

import kanode.steven.models.ReimbursementForm;
import kanode.steven.models.SupervisorEventReview;
import kanode.steven.models.UpdateMaker;
import kanode.steven.repositories.interfaces.ReimbursementFormRepoInt;
import kanode.steven.util.JDBCConnection;

public class ReimbursementFormRepoImpl implements ReimbursementFormRepoInt {

	public Connection conn = JDBCConnection.getConnection();

	public ReimbursementFormRepoImpl() {
		this.conn = JDBCConnection.getConnection();
	}

	public ReimbursementForm getReimbursementForm(int id) {

		try {
			String sql = "SELECT * FROM ReimbursementForms WHERE PK_REIMBURSEMENT_FORM_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ReimbursementForm rf = new ReimbursementForm();

				rf.setSupervisorApproved(rs.getInt(1));
				rf.setDepartmentheadApproved(rs.getInt(2));
				rf.setBencoApproved(rs.getInt(3));
				rf.setPK_REIMBURSEMENT_FORM_ID(rs.getInt(4));
				rf.setFK_EMPLOYEE_ID(rs.getInt(5));
				rf.setFK_EVENT_ID(rs.getInt(6));
				rf.setFK_TUITION_BALANCE(rs.getInt(7));

				return rf;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ReimbursementForm getReimbursementForm2(int id) {
		System.out.println(id);
		try {
			String sql = "SELECT * FROM Reimbursement_Form WHERE FK_event_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ReimbursementForm rf = new ReimbursementForm();

				rf.setSupervisorApproved(rs.getInt(1));
				rf.setDepartmentheadApproved(rs.getInt(2));
				rf.setBencoApproved(rs.getInt(3));
				rf.setPK_REIMBURSEMENT_FORM_ID(rs.getInt(4));
				rf.setFK_EMPLOYEE_ID(rs.getInt(5));
				rf.setFK_EVENT_ID(rs.getInt(6));
				rf.setFK_TUITION_BALANCE(rs.getInt(7));

				return rf;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean addReimbursementForm(ReimbursementForm g) {

		try {
			String sql = "INSERT INTO REIMBURSEMENT_FORM "
					+ "(SUPERVISOR_APPROVED, DEPARTMENT_HEAD_APPROVED, BENCO_APPROVED, "
					+ "PK_REIMBURSEMENT_FORM_ID, FK_EVENT_ID, FK_TUITION_BALANCE) " + "VALUES (?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getSupervisorApproved());
			ps.setInt(2, g.getDepartmentheadApproved());
			ps.setInt(3, g.getBencoApproved());
			ps.setInt(4, g.getPK_REIMBURSEMENT_FORM_ID());
			ps.setInt(5, g.getFK_EVENT_ID());
			ps.setInt(6, g.getFK_TUITION_BALANCE());
			ps.execute();

			return true;

		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public List<ReimbursementForm> getAllReimbursementForms() {
		List<ReimbursementForm> rbf = new ArrayList<ReimbursementForm>();

		try {
			String sql = "SELECT * FROM REIMBURSEMENT_FORM";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				ReimbursementForm rf = new ReimbursementForm();
				rf.setSupervisorApproved(rs.getInt(1));
				rf.setDepartmentheadApproved(rs.getInt(2));
				rf.setBencoApproved(rs.getInt(3));
				rf.setPK_REIMBURSEMENT_FORM_ID(rs.getInt(4));
				rf.setFK_EMPLOYEE_ID(rs.getInt(5));
				rf.setFK_EVENT_ID(rs.getInt(6));
				rf.setFK_TUITION_BALANCE(rs.getInt(7));
				rbf.add(rf);
			}

			return rbf;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateReimbursementFormApproval(UpdateMaker um) {
		
		String sql = "";
		if (um.getApproverType() == 1) {
			sql = "UPDATE REIMBURSEMENT_FORM " + "SET SUPERVISOR_APPROVED = " + um.getApproveDeny() + " WHERE FK_EVENT_ID = "
					+ um.getRfid();
		}
		if (um.getApproverType() == 2) {
			sql = "UPDATE REIMBURSEMENT_FORM " + "SET DEPARTMENT_HEAD_APPROVED = " + um.getApproveDeny()
					+ " WHERE FK_EVENT_ID = " + um.getRfid();
		}
		if (um.getApproverType() == 3) {
			sql = "UPDATE REIMBURSEMENT_FORM " + "SET BENCO_APPROVED = " + um.getApproveDeny()
					+ " WHERE FK_EVENT_ID = " + um.getRfid();
		}
		try {

			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			ReimbursementForm rf = new ReimbursementForm();
			rf = this.getReimbursementForm2(um.getRfid());
			this.updateReimbursementForm(rf);
			
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updateReimbursementForm(ReimbursementForm g) {
		
		try {
			
			String sql = "UPDATE REIMBURSEMENT_FORM " + "SET SUPERVISOR_APPROVED = ?, DEPARTMENT_HEAD_APPROVED = ?, "
					+ "BENCO_APPROVED = ?, " + "PK_REIMBURSEMENT_FORM_ID = ?," + "FK_EVENT_ID = ?,"
					+ "FK_TUITION_BALANCE = ?" + "WHERE PK_REIMBURSEMENT_FORM_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getSupervisorApproved());
			ps.setInt(2, g.getDepartmentheadApproved());
			ps.setInt(3, g.getBencoApproved());
			ps.setInt(4, g.getPK_REIMBURSEMENT_FORM_ID());
			ps.setInt(5, g.getFK_EVENT_ID());
			ps.setInt(6, g.getFK_TUITION_BALANCE());
			ps.setInt(7, g.getPK_REIMBURSEMENT_FORM_ID());
			ps.execute();
			
			if (g.getSupervisorApproved() == 1 & g.getDepartmentheadApproved() == 1 & g.getBencoApproved() == 1) {
//				String newSql = "update tuition_balances "
//						+ " set amount_left = amount_left - (select cost from events where pk_event_id = " + g.getFK_EVENT_ID() 
//					    + " ) * (select multi from event_types where pk_event_types_id = (select fk_event_type from events where pk_event_id = " + g.getFK_EVENT_ID() 
//						+ ")), amount_approved = amount_approved + (select cost from events where pk_event_id = " + g.getFK_EVENT_ID()  
//						+ " * (select multi from event_types where pk_event_types_id = (select fk_event_type from events where pk_event_id = " + g.getFK_EVENT_ID()
//						+ " where pk_tuition_amounts_id = " + g.getFK_EVENT_ID() + ")))";
				
				
				String s = "update tuition_balances "
				+ "set amount_left = amount_left - (select cost from events where pk_event_id = ?) * (select multi from event_types where pk_event_types_id = "
				+ "(select fk_event_type from events where pk_event_id=?))  "
				+ ", amount_approved = amount_approved + (select cost from events where pk_event_id = ?) * "
				+ "(select multi from event_types where pk_event_types_id = (select fk_event_type from events where pk_event_id=?)) "
				+ "where pk_tuition_amounts_id = ?";
				
				System.out.println(s);
				PreparedStatement newps = conn.prepareStatement(s);
				newps.setInt(1, g.getFK_EVENT_ID());
				newps.setInt(2, g.getFK_EVENT_ID());
				newps.setInt(3, g.getFK_EVENT_ID());
				newps.setInt(4, g.getFK_EVENT_ID());
				newps.setInt(5, g.getFK_EVENT_ID());
				
				newps.execute();
				System.out.println("Reimbursement Form");
			}
			
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteReimbursementForm(int id) {
		String sql = "DELETE from REIMBURSEMENT_FORM where PK_REIMBURSEMENT_FORM_ID = ?";
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

	public List<EmployeeEventReview> getReimbursementFormsByEmployee(int id) {

		ArrayList<EmployeeEventReview> forms = new ArrayList<EmployeeEventReview>();

		try {
			String sql = "select * from events e "
					+ "LEFT JOIN reimbursement_form rf on e.pk_event_id = rf.fk_event_id "
					+ "inner join event_types et on e.fk_event_type = et.pk_event_types_id "
					+ "where e.fk_employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				EmployeeEventReview rf = new EmployeeEventReview();
				rf.setEvent_description(rs.getString("EVENT_DESCRIPTION"));
				rf.setEvent_location(rs.getString("EVENT_LOCATION"));
				rf.setCost(rs.getInt("cost"));
				rf.setDay(rs.getInt("day"));
				rf.setMonth(rs.getInt("month"));
				rf.setYear(rs.getInt("year"));
				rf.setHour(rs.getInt("hour"));
				rf.setMinute(rs.getInt("minute"));
				rf.setSupervisor_approved(rs.getInt("supervisor_approved"));
				rf.setDepartment_head_approved(rs.getInt("department_head_approved"));
				rf.setBenco_approved(rs.getInt("benco_approved"));
				rf.setEvent_type(rs.getString("event_type"));
				
				forms.add(rf);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return forms;
	}

	public List<SupervisorEventReview> getReimbursementFormsBySupervisor(int id) {

		ArrayList<SupervisorEventReview> forms = new ArrayList<SupervisorEventReview>();

		try {
			String sql = "SELECT * FROM EVENTS "
					+ "INNER JOIN EMPLOYEES ON EMPLOYEES.PK_EMPL_ID = EVENTS.FK_EMPLOYEE_ID "
					+ "WHERE EMPLOYEES.FK_SUPERVISOR_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SupervisorEventReview e = new SupervisorEventReview();
				e.setEvent_location(rs.getString("event_location"));
				e.setEvent_description(rs.getString("event_Description"));
				e.setEvent_type(rs.getInt("fk_event_type"));
				e.setCost(rs.getInt("cost"));
				e.setDay(rs.getInt("day"));
				e.setMonth(rs.getInt("month"));
				e.setYear(rs.getInt("year"));
				e.setHour(rs.getInt("hour"));
				e.setMinute(rs.getInt("minute"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setEmail(rs.getString("email"));
				e.setPk_event_id(rs.getInt("PK_EVENT_ID"));
				forms.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return forms;
	}
}
