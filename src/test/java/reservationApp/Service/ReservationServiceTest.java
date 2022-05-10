package test.java.reservationApp.Service;

import org.junit.Test;

import main.java.reservationApp.repository.OrderDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;

public class ReservationServiceTest {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	OrderDAO orderDAO = OrderDAO.getInstance();
	ReservationService rs = new ReservationService();
	
	
}
