package test.java.reservationApp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

//@Transactional
class ReservationDAOTest {
	
	ReservationDAO dao = ReservationDAO.getInstance();
	
//	@AfterEach
//	void clear() {
//		dao.clearStore();
//	}
	
//	
//	@Test
//	void insertReservation() {
//		//insertReservation(String reservation_date,String reservation_time,int seat,String name, String phone, int rest_id)
//		dao.insertReservation("20220909","12:00",4,"하영d","010-5555-5555",3);
//		fail("Not yet implemented");
//	}
	
	@Test
	void findReservationById() {
		ReservationDTO dto = dao.findReservationById(22543).get();
		System.out.println(dto);
	}
//	
//	@Test
//	void findAll() {
//		dao.findAll().forEach(value -> System.out.println(value));
//		//값이 쌓이지 않고 날라감?
//	}
	
//	@Test
//	void deleteReservation() {
//		
//		dao.deleteReservation(1);
//	}
	

//	@Test
//	void updateReservationStatus() {
//		dao.updateReservationStatus(3, 21712);
//	}

}
