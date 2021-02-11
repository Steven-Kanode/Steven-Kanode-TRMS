package kanode.steven.repositories.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kanode.steven.models.Event;
import kanode.steven.repositories.interfaces.EventRepoInt;
import kanode.steven.util.JDBCConnection;

public class EventRepoImpl implements EventRepoInt{

	public static Connection conn = JDBCConnection.getConnection();
	
	//tested works
	@Override
	public Event getEvent(int id) {
		
		if (conn == null) {
			conn = JDBCConnection.getConnection();
		}
		
		try {
			String sql = "SELECT * FROM EVENTS WHERE PK_EVENT_ID = ?";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("rs.next worked");
				
				Event event = new Event();
				
				event.setPK_EVENT_ID(rs.getInt("PK_EVENT_ID"));
				event.setEventDescription(rs.getString("EVENT_DESCRIPTION"));
				event.setEventLocation(rs.getString("EVENT_LOCATION"));
				event.setDay(rs.getInt("day"));
				event.setMonth(rs.getInt("month"));
				event.setYear(rs.getInt("year"));
				event.setHour(rs.getInt("hour"));
				event.setMinute(rs.getInt("minute"));
				event.settype(rs.getInt("FK_EVENT_TYPE"));
				event.setFK_EMPLOYEE_ID(rs.getInt("FK_EMPLOYEE_ID"));
				event.setCost(rs.getDouble("cost"));
				
				System.out.println(event.toString());
			
				return event;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public boolean addEvent(Event event) {
		// TODO Auto-generated method stub
		CallableStatement cs;
		
		try {
			cs = conn.prepareCall("CALL ADD_EVENT(?,?,?,?,?,?,?,?,?,?)"); 
			
			//TODO: Need to fix the order of this
			cs.setString(1, event.getEventDescription());
			cs.setString(2, event.getEventLocation());
			cs.setInt(3, event.getFK_EVENT_TYPE_ID());
			cs.setInt(4, event.getFK_EMPLOYEE_ID());
			cs.setDouble(5, event.getCost());
			cs.setInt(6, event.getDay());
			cs.setInt(7, event.getMonth());
			cs.setInt(8, event.getYear());
			cs.setInt(9, event.getHour());
			cs.setInt(10, event.getMinute());
			cs.executeQuery();
			
			return true;
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		List<Event> events = new ArrayList<Event>();
		
		try {
			String sql = "SELECT * FROM EVENTS";
			
			Statement ps = conn.createStatement();
		
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				Event event = new Event();
				event.setPK_EVENT_ID(rs.getInt(1));
				event.setEventDescription(rs.getString(2));
				event.setEventLocation(rs.getString(3));
				//TODO: GOTTA FINISH THIS WITH THE NEW MIN/HOUR 
				event.settype(rs.getInt(6));
				event.setFK_EMPLOYEE_ID(rs.getInt(7));
	
				events.add(event);
			}
			return events;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEvent(Event event) {
		//TODO: ADD MIN/HOUR & DAY/MONTH/YEAR
		try {
			String sql = "UPDATE EVENTS "
					+ "SET PK_EVENT_ID = ?, EVENT_DESCRIPTION = ?, EVENT_LOCATION = ?"
					+ ", FK_type = ?"
					+ ", FK_EMPLOYEE_ID = ? "
					+ "WHERE PK_EVENT_ID = ? ";
			
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, event.getPK_EVENT_ID());
			ps.setString(2, event.getEventDescription());
			ps.setString(3, event.getEventLocation());
			ps.setInt(6, event.gettype());
			ps.setInt(7, event.getFK_EMPLOYEE_ID());
			ps.setInt(8, event.getPK_EVENT_ID());
			ps.executeQuery();
		
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEvent(int id) {
		String sql = "DELETE from EVENTS where PK_EVENT_ID = ?";
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
