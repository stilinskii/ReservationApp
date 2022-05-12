package main.java.reservationApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

//로직구현 후 컨트롤러에서 호출 
public class ReservationService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();

	// 확정된 예약 취소 못하게
	public void statusChk(int reservation_id) {
		//예약번호로 예약찾아서 예약상태가 확정(2)인지 확인
		if (findReservationById(reservation_id).get().getReservation_state_num() == 2) {
			System.out.println("이미 확정된 예약은 취소가 불가합니다.");
		} else if (findReservationById(reservation_id).isEmpty()) {
			System.out.println("해당번호의 예약이 존재하지 않습니다");
		} else {
			reserDAO.deleteReservation(reservation_id);
		}
	}
	
	public Optional<ReservationDTO> findReservationById(int reservation_id) {
		return reserDAO.reservationList().stream().filter(value -> value.getReservation_id() == reservation_id)
				.findAny();
	}
	
	public List<ReservationDTO> findReservationByIdToList(int reservation_id) {
		return findReservationById(reservation_id).stream().collect(Collectors.toList());
//		return Arrays.asList(reserDAO.reservationList().stream()
//				.filter(value -> value.getReservation_id() == reservation_id)
//				.toArray(ReservationDTO[]::new));
	}

	
	// 레스토랑마다 대기중 예약목록 출력
	public List<ReservationDTO> waitingReservations(String managerPW) {
		List<ReservationDTO> alist = new ArrayList<>();
		findReservationByRestaurant(managerPW).stream()
				.filter(value -> value.getReservation_state_num() == 1)
				.forEach(e -> alist.add(e));
		return alist;
	}

	// 레스토랑마다 전체 예약목록
	public List<ReservationDTO> findReservationByRestaurant(String managerPW) {
		List<ReservationDTO> alist = new ArrayList<>();
		reserDAO.reservationList().stream()
				.filter(value -> value.getRestDTO().getRestaurant_id() == restDAO.findRestaurantIdByPw(managerPW).get())
				.forEach(e -> alist.add(e));
		return alist;
	}
	
	

}
