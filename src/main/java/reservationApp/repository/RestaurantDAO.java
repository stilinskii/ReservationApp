package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestaurantDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	 
	
	private static RestaurantDAO restaurantDAO = new RestaurantDAO();
	
	public static RestaurantDAO getInstance() {
		return restaurantDAO;
	}
	
	//음식점아이디, 이름 프린트하는 메서드
	public void listRestaurant() {
		
		try {
			String sql = "select RESTAURANT_ID,RESTAURANT_NAME from restaurantstest";
			rs = JdbcTemplate.getConnection().createStatement().executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
				
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
	
	
	//예약번호생성
	SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
	
	
	public int insertRestaurant(String name, String type, int max_seat){
		
		int chk = -1;
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "insert into restaurantstest values(restaurantstest_num_seq.nextval,?,?,?,?,?,?,null)";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, Integer.parseInt(sdf.format(new Date()))); //id
			pstmt.setString(1, name); //name
			pstmt.setString(2, type); // type
			pstmt.setInt(3, max_seat); // max
			pstmt.setInt(4, 0); //reserved
			pstmt.setInt(5, max_seat); // available
			pstmt.setString(6, "O"); // status
			
			
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
	
	public int deleteRestaurant(int restaurant_id){
		int chk=-1;;
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "DELETE FROM restaurantstest WHERE restaurant_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, restaurant_id);
			 chk = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return chk;
	}
	
	
}
