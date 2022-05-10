package main.java.reservationApp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import main.java.reservationApp.controller.OrderController;
import main.java.reservationApp.domain.OrderDTO;
import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.OrderDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

//로직구현 후 컨트롤러에서 호출 
public class ReservationService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	OrderDAO orderDAO = OrderDAO.getInstance();
	
	//확정된 예약 취소 못하게
	public void statusChk(int reservation_id) {
		if(findReservationById(reservation_id).get().getReservation_state_num()==2) {
			System.out.println("이미 확정된 예약은 취소가 불가합니다.");
		}else {
			reserDAO.deleteReservation(reservation_id);
		}
	}
	
	public Optional<ReservationDTO> findReservationById(int reservation_id) {
		return reserDAO.reservationList().stream()
				.filter(value -> value.getReservation_id() == reservation_id).findAny();
	}
	
	//뒤죽박죽 다 섞임....
	//총합계에 필요한 것 메뉴가격 오더카운트 예약번호

	
	
	
	
	//대기중 에약 목록 + 주문서
	public void waitingReservationsAndOrder(String managerPW) {
		List<ReservationDTO> reservationlist = waitingReservations(managerPW);
		int total = 0;
		for(int i = 0; i<reservationlist.size();i++) {
			System.out.println("<예약정보>");
			System.out.print(reservationlist.get(i));
			int reservation_id = reservationlist.get(i).getReservation_id();
			List<OrderDTO> orderList = orderDAO.menuOrderList(reservation_id);
			System.out.println("<주문정보>");
			for(OrderDTO order:orderList) {
				System.out.println(order);
				total += order.getTotal_price();
			}
			System.out.println("총합계: "+total+"원");
			
		}
	}
	
	//레스토랑마다 대기중 예약목록 출력
	public List<ReservationDTO> waitingReservations(String managerPW) {
		List<ReservationDTO> alist = new ArrayList<>();
		findReservationByRestaurant(restDAO.findRestaurantIdByPw(managerPW).get()).stream()
			.filter(value -> value.getReservation_state_num() == 1).forEach(e -> alist.add(e));
		return alist;	
	}
	
	//레스토랑마다 전체 예약목록
	public List<ReservationDTO> findReservationByRestaurant(int restaurant_id) {
		List<ReservationDTO> alist = new ArrayList<>();
		reserDAO.reservationList().stream()
			.filter(value -> value.getRestDTO().getRestaurant_id() == restaurant_id)
			.forEach(e -> alist.add(e));
		
		return alist;
	}
	
	//전체 예약목록 + 주문서
	public void allReservationsAndOrders(int restaurant_id) {
		List<ReservationDTO> reservationlist = findReservationByRestaurant(restaurant_id);
		int total = 0;
		for(int i = 0; i<reservationlist.size();i++) {
			System.out.println("<예약정보>");
			System.out.print(reservationlist.get(i));
			List<OrderDTO> orderList = orderDAO.menuOrderList(reservationlist.get(i).getReservation_id());
			System.out.println("<주문정보>");
			for(OrderDTO order:orderList) {
				System.out.println(order);
				total += order.getTotal_price();
			}
			System.out.println("총합계: "+total+"원");
			
		}
	}

		
	
}
	
	
	

	


