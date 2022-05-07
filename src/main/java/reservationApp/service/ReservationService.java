package main.java.reservationApp.service;

import java.util.NoSuchElementException;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;

//로직구현 후 컨트롤러에서 호출 
public class ReservationService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	
	//확정된 예약 취소 못하게
	public void statusChk(int reservation_id) {
		if(reserDAO.findReservationById(reservation_id).get().getReservation_state_num()==2) {
			System.out.println("이미 확정된 예약은 취소가 불가합니다.");
		}else {
			reserDAO.deleteReservation(reservation_id);
		}
		
	}
	

	

}
