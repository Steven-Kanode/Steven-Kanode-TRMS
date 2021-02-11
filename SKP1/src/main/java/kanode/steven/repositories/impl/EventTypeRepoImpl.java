package kanode.steven.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.EventType;
import kanode.steven.repositories.interfaces.EventTypeRepoInt;
import kanode.steven.util.JDBCConnection;

public class EventTypeRepoImpl implements EventTypeRepoInt {

	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public EventType getEventType(int id) {

		try {
			String sql = "SELECT * FROM event_TYPES WHERE PK_EVENT_TYPES_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				EventType et = new EventType();
				et.setEVENT_TYPE(rs.getString("EVENT_TYPE"));
				et.setPK_EVENT_TYPES_ID(rs.getInt("PK_EVENT_TYPES_ID"));
				
				return et;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addEventType(EventType e) {

		try {
			String sql = "INSERT INTO EVENT_TYPES " + "(PK_EVENT_TYPES_ID, EVENT_TYPE) " + "VALUES (?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getPK_EVENT_TYPES_ID());
			ps.setString(2, e.getEVENT_TYPE());
			ps.execute();
			
			return true;

		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public List<EventType> getAllEventTypes() {
		List<EventType> eventTypes = new ArrayList<EventType>();

		try {
			String sql = "SELECT * FROM EVENT_TYPES";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				EventType et = new EventType();
				et.setPK_EVENT_TYPES_ID(rs.getInt(1));
				et.setEVENT_TYPE(rs.getString(2));
				eventTypes.add(et);
			}
			return eventTypes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateEventType(EventType e) {
		
		try {
			String sql = "UPDATE EVENT_TYPES "
					+ "SET PK_EVENT_TYPES_ID = ?, EVENT_TYPE = ?"
					+ "WHERE PK_EVENT_TYPES_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getPK_EVENT_TYPES_ID());
			ps.setString(2, e.getEVENT_TYPE());
			return true;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEventType(int id) {
		
		String sql = "DELETE from EVENT_TYPES where PK_EVENT_TYPES_ID = ?";
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
