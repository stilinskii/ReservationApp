package main.java.reservationApp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

//로직구현 후 컨트롤러에서 호출 
public class ReservationService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	
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

	
	
	
	//레스토랑마다 다르게 예약대기목록 출력
	public void waitingReservations(String managerPW) {
	
		
			findReservationByRestaurant(restDAO.findByPw(managerPW).get()).stream()
				.filter(value -> value.getReservation_state_num() == 1)
				.forEach(value -> System.out.println(value));
		
		
		
	}
	
	//레스토랑마다 예약내역목록
	public List<ReservationDTO> findReservationByRestaurant(int restaurant_id) {
		List<ReservationDTO> alist = new ArrayList<>();
		reserDAO.reservationList().stream().filter(value -> value.getRestDTO().getRestaurant_id() == restaurant_id).forEach(e -> alist.add(e));
		
		return alist;
	}
	

		
	}
	
	
	

	


