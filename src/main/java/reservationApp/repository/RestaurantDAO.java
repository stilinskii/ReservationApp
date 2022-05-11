package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Optional;

public class RestaurantDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static RestaurantDAO restaurantDAO = new RestaurantDAO();
	
	public static RestaurantDAO getInstance() {
		return restaurantDAO;
	}
	
	//음식점정보 프린트하는 메서드
	public void listRestaurant() {
		
		try {
			
			String sql = "select RESTAURANT_ID,RESTAURANT_NAME,RESTAURANT_TYPE,AVAILABLE_SEAT,WORKING_TIME from restaurantstest";
			rs = JdbcTemplate.getConnection().createStatement().executeQuery(sql);
			
			while(rs.next()) {
				System.out.printf("[%2d]   %-13s %-5s %5d개  %18s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
			JdbcTemplate.close(conn);
		}
		
		
	}
	
	public String restaurantWorkingTime(int restaurant_id) {
		String workingTime = "";
		try {
			pstmt = JdbcTemplate.getConnection().prepareStatement("select WORKING_TIME from restaurantstest where RESTAURANT_ID = ?");
			pstmt.setInt(1, restaurant_id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			workingTime = rs.getString(1);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
			JdbcTemplate.close(conn);
		}
		
		return workingTime;
	}
	
	
	
	
	
	public int insertRestaurant(String name, String type, int max_seat, String manager_pw){
		
		int chk = -1;
		try {
			String sql = "insert into restaurantstest values(restaurantstest_num_seq.nextval,?,?,?,?,?,?,null,?)";
			pstmt = JdbcTemplate.getConnection().prepareStatement(sql);
			//pstmt.setInt(1, Integer.parseInt(sdf.format(new Date()))); //id
			pstmt.setString(1, name); //name
			pstmt.setString(2, type); // type
			pstmt.setInt(3, max_seat); // max
			pstmt.setInt(4, 0); //reserved
			pstmt.setInt(5, max_seat); // available
			pstmt.setString(6, "O"); // status
			pstmt.setString(7, manager_pw); // manager_pw
			
			
			chk = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return chk;
	}
	
	public void deleteRestaurant(String managerPw){
		try {
			conn = JdbcTemplate.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM restaurantstest WHERE manager_pw=?");
			pstmt.setString(1, managerPw);
			pstmt.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("남은 예약이 존재합니다.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
	}
	
	//비밀번호에다른 음식점 아이디
	public Optional<Integer> findRestaurantIdByPw(String managerPW)  {
		
		int restaurant_id = 0;
		
			try {
				conn = JdbcTemplate.getConnection();
				pstmt = conn.prepareStatement("SELECT restaurant_id FROM restaurantstest WHERE manager_pw=?");
				pstmt.setString(1, managerPW);
				rs = pstmt.executeQuery();
				rs.next();
				
				restaurant_id = rs.getInt(1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
				JdbcTemplate.close(conn);
			}
			

		return Optional.of(restaurant_id);
	}
	
	public String findRestaurantNameByPw(String managerPW)  {
		
		String restaurant_name = "";
		
			try {
				pstmt = JdbcTemplate.getConnection().prepareStatement("SELECT restaurant_name FROM restaurantstest WHERE manager_pw=?");
				pstmt.setString(1, managerPW);
				rs = pstmt.executeQuery();
				rs.next();
				
				restaurant_name = rs.getString(1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcTemplate.close(rs);
				JdbcTemplate.close(pstmt);
			}
			

		return restaurant_name;
	}
	
	
	

	
}
