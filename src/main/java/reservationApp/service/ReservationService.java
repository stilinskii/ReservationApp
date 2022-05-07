package main.java.reservationApp.service;

import main.java.reservationApp.repository.ReservationDAO;

//로직구현 후 컨트롤러에서 호출 
public class ReservationService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	
	//확정된 예약 취소 못하게
	public void statusChk() {
		
	}

}
