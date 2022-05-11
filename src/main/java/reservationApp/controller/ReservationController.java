package main.java.reservationApp.controller;

import java.util.List;
import java.util.NoSuchElementException;

import main.java.reservationApp.domain.OrderDTO;
import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.OrderDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;

public class ReservationController {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	OrderDAO orderDAO = OrderDAO.getInstance();
	ReservationService reserService = new ReservationService();
	OrderController orderController = new OrderController();

	// 음식점 예약, 인원수가 해당음식점 수용가능보다 많으면 예약안되게 하는 거 추가 - 실패
	public int createReservation(int reservation_id, String reservation_date, String reservation_time, int seat,
			String name, String phone, int rest_id) {
		return reserDAO.insertReservation(reservation_id, reservation_date, reservation_time, seat, name, phone,
				rest_id);
	}

	// 발급번호로 예약 조회
	public void searchReservation(int reservation_id) {
		ReservationsWithOrders(reserService.findReservationById2(reservation_id));

	}

	// 예약 취소
	public void cancelReservation(int reservation_id) {
		reserService.statusChk(reservation_id); // 확정된 예약 취소 못하게
	}
	
	//  레스토랑 관리자들 각각 예약 전체 목록 출력 + 주문서
	public void allReservations(String managerPW){
		ReservationsWithOrders(reserService.findReservationByRestaurant(managerPW));
	}

	// 레스토랑 관리자가 각각 예약대기목록 + 주문서
	public void waitingReservations(String managerPW) {
		ReservationsWithOrders(reserService.waitingReservations(managerPW));
	}
		
	
	// 예약정보들을 리스트로 받아서 그에맞는 주문서와 함께 출력
		public void ReservationsWithOrders(List<ReservationDTO> reservationList) {
			int total = 0;
			if (reservationList.isEmpty()) {
				System.out.println("예약이 존재하지 않습니다.");
			} else {
				for (ReservationDTO reservation:reservationList) {
					System.out.println();
					System.out.println("<예약정보>");
					System.out.print(reservation);
					List<OrderDTO> orderList = orderDAO.menuOrderList(reservation.getReservation_id());
					System.out.println("<주문정보>");
					for (OrderDTO order : orderList) {
						System.out.println(order);
						total += order.getTotal_price();
					}
					System.out.println("-----------------------");
					System.out.println("총합계: " + total + "원");
					System.out.println();
				}

			}
		}
	

	// 관리자가 예약거절 
	public void refuseReservation(int reservation_id) {
		int chk = reserDAO.updateReservationStatus(4, reservation_id);
		System.out.println(chk + "개 예약거절 완료");
	}

	// 관리자가 예약승인
	public void comfirmReservations(int reservation_id) {
		int chk = reserDAO.updateReservationStatus(2, reservation_id);
		System.out.println(chk + "개 예약승인 완료");

	}

}
