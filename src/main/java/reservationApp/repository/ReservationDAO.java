package main.java.reservationApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.domain.RestaurantDTO;

public class ReservationDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	private static ReservationDAO reservationDAO = new ReservationDAO(); 
	
	public static ReservationDAO getInstance() {
		return reservationDAO;
	}
	
	
	
	Map<Integer,ReservationDTO> store = new HashMap<>();
	
	//목록출력
	public List<ReservationDTO> findAll(){
		try {
			conn = JdbcTemplate.getConnection();
			String sql = "select reservation_id,TO_CHAR(reservation_date,'yyyy/mm/dd'),TO_CHAR(reservation_time,'hh24:mi'),TO_CHAR(requested_date,'yyyy/mm/dd'), TO_CHAR(requested_time,'hh24:mi'),seat,guest_name,guest_phone,reservation_state,restaurant_name "
					+ "from reservationtest rser, restaurantstest rest "
					+ "where rser.RESTAURANT_ID = rest.RESTAURANT_ID ";
			
			rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				
				RestaurantDTO restDTO = new RestaurantDTO();
				restDTO.setRestaurant_name(rs.getString("restaurant_name"));
				
				ReservationDTO reserDTO = new ReservationDTO(
						rs.getInt("reservation_id"),
						rs.getString("TO_CHAR(reservation_date,'yyyy/mm/dd')"),
						rs.getString("TO_CHAR(reservation_time,'hh24:mi')"),
						rs.getString("TO_CHAR(requested_date,'yyyy/mm/dd')"),
						rs.getString("TO_CHAR(requested_time,'hh24:mi')"),
						rs.getInt("seat"),
						rs.getString("guest_name"),
						rs.getString("guest_phone"),
						rs.getInt("reservation_state"),
						restDTO
						);
				
				store.put(reserDTO.getReservation_id(), reserDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(stmt);
			JdbcTemplate.close(conn);
		}
		
		return new ArrayList<>(store.values());
	}
	
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
	
	
	public int insertReservation(String reservation_date,String reservation_time,int seat,String name, String phone, int rest_id) {
		int chk = -1;
		try {
			conn = JdbcTemplate.getConnection();
			//에약아이디, 예약일, 예약시간,( 예약한 날, 시간), 인원수, 이름, 번호, (예약상태), 레스토랑 아이디순
			String sql="insert into reservationtest "
					+ "values(?,?,to_date(?,'hh24:mi'), "
					+ "sysdate,sysdate,?,?,?,1,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sdf.format(new Date())));//예약아이디
			pstmt.setString(2, reservation_date);//예약일 20090417형식으로
			pstmt.setString(3, reservation_time);//예약시간 15:00형식으로
			pstmt.setInt(4, seat);
			pstmt.setString(5, name);
			pstmt.setString(6, phone);
			pstmt.setInt(7, rest_id);
			
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
	
	
	public Optional<ReservationDTO> findReservationById(int reservation_id) {
		findAll();
		return store.values().stream().filter(value -> value.getReservation_id()==reservation_id).findAny();
	}
	
	
	
	public void clearStore() {
		store.clear();
	}
	
	
	
	public int deleteReservation(int reservation_id) {
		int chk = -1;
		try {
			conn=JdbcTemplate.getConnection();
			String sql = "delete from reservationtest where reservation_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservation_id);
			
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
	
	public int updateReservationStatus(int statusNum, int reserv_id){
		int chk = -1;
		try {
			String sql = "UPDATE reservationtest SET reservation_state = ? WHERE RESERVATION_ID=?";
			pstmt = JdbcTemplate.getConnection().prepareStatement(sql);
			pstmt.setInt(1, statusNum);
			pstmt.setInt(2, reserv_id);
			
			chk=pstmt.executeUpdate();
			
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
