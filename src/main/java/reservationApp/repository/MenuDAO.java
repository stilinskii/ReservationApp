package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.reservationApp.domain.MenuDTO;
import main.java.reservationApp.domain.OrderDTO;
import main.java.reservationApp.domain.ReservationDTO;

public class MenuDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static MenuDAO menuDAO = new MenuDAO();
	
	public static MenuDAO getInstance() {
		return menuDAO;
	}
	
	
	//메뉴 리스트 
	public List<MenuDTO> menuListByRestaurantId(int restaurant_id){
		List<MenuDTO> store = new ArrayList<>();
		try {
			pstmt = JdbcTemplate.getConnection().prepareStatement("select * from menutest WHERE restaurant_id = ?");
			pstmt.setInt(1, restaurant_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuDTO menuDTO = new MenuDTO(rs.getInt("menu_id"),rs.getString("menu_name"),rs.getInt("menu_price"));
				store.add(menuDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return store;
		
	}
	
	
	//메뉴등록
	public int insertMenu(String menuName,int price,int restaurant_id) {
		//아이디,메뉴이름,가격,레스토랑아이디
		int chk = -1;
		try {
			String sql = "insert into menutest "
					+ "values(menuId_num_seq.nextval,?,?,?)";
			pstmt = JdbcTemplate.getConnection().prepareStatement(sql);
			pstmt.setString(1,menuName);
			pstmt.setInt(2, price);
			pstmt.setInt(3, restaurant_id);
			chk = pstmt.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		return chk;
		
	}
	
	
	//메뉴삭제
	public int deleteMenu(int menu_id) {
		int chk = -1;
		try {
			pstmt = JdbcTemplate.getConnection().prepareStatement("DELETE FROM menutest WHERE menu_id=?");
			pstmt.setInt(1, menu_id);
			 chk = pstmt.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(conn);
		}
		
		return chk;
	}
	
	
}
