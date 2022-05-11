package main.java.reservationApp.controller;

import java.util.List;

import main.java.reservationApp.domain.OrderDTO;
import main.java.reservationApp.repository.MenuDAO;
import main.java.reservationApp.repository.OrderDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;
import main.java.reservationApp.service.RestaurantService;

public class OrderController {
	OrderDAO orderDAO = OrderDAO.getInstance();
	
	public void createOrder(int count, int total_price, int menu_id, int reservation_id) {
		orderDAO.insertOrder(count, total_price, menu_id, reservation_id);
	}
	
	//주문서
	public void bill(int reservation_id) {
		List<OrderDTO> orderList = orderDAO.menuOrderList(reservation_id);
		int total=0;
		
		for(OrderDTO order:orderList) {
			System.out.println(order);
			total += order.getTotal_price();
		}
		System.out.println("--------------------");
		System.out.println("총합계: "+total+"원");
		System.out.println();
		
	}
	
	
}
