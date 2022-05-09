package main.java.reservationApp.controller;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;

public class ReservationController {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationService reserService = new ReservationService();

	// 음식점 예약, 인원수가 해당음식점 수용가능보다 많으면 예약안되게 하는 거 추가
	public int createReservation(int reservation_id, String reservation_date, String reservation_time, int seat,
			String name, String phone, int rest_id) {
		return reserDAO.insertReservation(reservation_id, reservation_date, reservation_time, seat, name, phone,
				rest_id);
	}

	// 발급번호로 예약 조회
	public String searchReservation(int reservation_id) {
		try {
			return reserService.findReservationById(reservation_id).get().toString();

		} catch (NoSuchElementException e) {
			return "해당 번호의 예약이 없습니다. 예약번호를 확인해주세요.";
		}
	}

	// 예약 취소
	public void cancelReservation(int reservation_id) {
		reserService.statusChk(reservation_id); // 확정된 예약 취소 못하게
	}

	// 레스토랑 각각 예약 전체 목록
	public void reservationList(String managerPW) {
		try {
			reserService.findReservationByRestaurant(restDAO.findByPw(managerPW).get());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// 레스토랑 각각 예약대기목록
	public void waitingReservations(String managerPW) {
		reserService.waitingReservations(managerPW);
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
