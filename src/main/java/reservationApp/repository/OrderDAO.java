package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static OrderDAO dao = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return dao;
	}
	
	
	public int insertOrder(int count, int total_price, int menu_id, int reservation_id) {
		//count, total_price, menu_id, reservation_id 모두 int
		int chk = -1;
		try {
			String sql = "insert into menutest values(?,?,?,?)";
			pstmt = JdbcTemplate.getConnection().prepareStatement(sql);
			pstmt.setInt(1,count);
			pstmt.setInt(2,total_price);
			pstmt.setInt(3,menu_id);
			pstmt.setInt(4,reservation_id);
			chk = pstmt.executeUpdate();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chk;
	}
}
