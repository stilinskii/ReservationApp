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
			String sql = "select RESTAURANT_ID,RESTAURANT_NAME,AVAILABLE_SEAT,AVAILABLE_STATE from restaurantstest";
			rs = JdbcTemplate.getConnection().createStatement().executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("["+rs.getInt(1)+"]" + "  " + rs.getString(2) 
				+ "   남은자리:"+rs.getInt(3)+"개");
				
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
	
	
	
	
	
	public int insertRestaurant(String name, String type, int max_seat, String manager_pw){
		
		int chk = -1;
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "insert into restaurantstest values(restaurantstest_num_seq.nextval,?,?,?,?,?,?,null,?)";
			pstmt = conn.prepareStatement(sql);
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
	
	public int deleteRestaurant(String managerPw){
		int chk=-1;;
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "DELETE FROM restaurantstest WHERE manager_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerPw);
			 chk = pstmt.executeUpdate();
			
		}catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("남은 예약이 존재합니다.");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return chk;
	}
	
	//비밀번호에다른 음식점 아이디
	public Optional<Integer> findByPw(String managerPW) throws SQLException, ClassNotFoundException {
		
		int restaurant_id = 0;
		
			conn = JdbcTemplate.getConnection();
			String sql = "SELECT restaurant_id FROM restaurantstest WHERE manager_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerPW);
			rs = pstmt.executeQuery();
			rs.next();
			
			restaurant_id = rs.getInt(1);
			

		return Optional.of(restaurant_id);
	}
	

	
}
