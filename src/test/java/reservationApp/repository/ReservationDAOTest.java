package test.java.reservationApp.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

class ReservationDAOTest {
	
	ReservationDAO dao = ReservationDAO.getInstance();
	
	@AfterEach
	void clear() {
		dao.clearStore();
	}
	
	
	@Test
	void insertReservation() {
		//insertReservation(String reservation_date,String reservation_time,int seat,String name, String phone, int rest_id)
		dao.insertReservation("20220909","12:00",4,"하영","010-5555-5555",1);
		fail("Not yet implemented");
	}
	
	@Test
	void findReservationById() {
		ReservationDTO dto = dao.findReservationById(55).get();
		System.out.println(dto);
	}
	
	@Test
	void findAll() {
		dao.findAll().forEach(value -> System.out.println(value));
		
	}

}
