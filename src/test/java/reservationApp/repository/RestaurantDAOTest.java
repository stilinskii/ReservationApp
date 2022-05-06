package test.java.reservationApp.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.reservationApp.repository.RestaurantDAO;

class RestaurantDAOTest {
	
	RestaurantDAO dao = RestaurantDAO.getInstance();

	@Test
	void insertRestaurant() {
		dao.insertRestaurant("양자강","중식", 30);
		
		fail("Not yet implemented");
	}
	
//	@Test
//	void deleteRestaurant() {
//		Assertions.assertEquals(1, dao.deleteRestaurant(1));
//	}

}
