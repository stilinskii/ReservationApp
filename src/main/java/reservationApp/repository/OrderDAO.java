package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.reservationApp.domain.MenuDTO;
import main.java.reservationApp.domain.OrderDTO;

public class OrderDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static OrderDAO dao = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return dao;
	}
	
	//이거... 객체반환으로 변경..
		public List<OrderDTO> menuOrderList(int reservation_id) {
			List<OrderDTO> store = new ArrayList<>();
			try {
			String sql = "select m.menu_name,o.count,m.menu_price,o.total_price "
					+ "from menutest m,ordertest o "
					+ "where m.menu_id=o.menu_id "
					+ "and o.reservation_id = ? ";
				pstmt = JdbcTemplate.getConnection().prepareStatement(sql);
				pstmt.setInt(1, reservation_id);
				rs = pstmt.executeQuery();
				System.out.println();
				
				while(rs.next()) {
					MenuDTO menuDTO = new MenuDTO();
					menuDTO.setMenu_name(rs.getString("menu_name"));
					menuDTO.setMenu_price(rs.getInt("menu_price"));
					OrderDTO orderDTO = new OrderDTO(rs.getInt("count"),rs.getInt("total_price"),menuDTO);
					store.add(orderDTO);

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
	
	public int insertOrder(int count, int total_price, int menu_id, int reservation_id) {
		//count, total_price, menu_id, reservation_id 모두 int
		int chk = -1;
		try {
			String sql = "insert into ordertest values(?,?,?,?)";
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
