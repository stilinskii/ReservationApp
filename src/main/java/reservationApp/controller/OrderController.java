package main.java.reservationApp.controller;

import main.java.reservationApp.repository.MenuDAO;
import main.java.reservationApp.repository.OrderDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;
import main.java.reservationApp.service.RestaurantService;

public class OrderController {
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	ReservationService reserService = new ReservationService();
	RestaurantService restService = new RestaurantService();
	MenuDAO menuDAO = MenuDAO.getInstance();
	OrderDAO orderDAO = OrderDAO.getInstance();
	
	public void createOrder() {
		
	}
	
	
}
