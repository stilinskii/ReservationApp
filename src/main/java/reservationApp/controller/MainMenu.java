package main.java.reservationApp.controller;

import java.util.NoSuchElementException;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;

public class MainMenu {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationService rs = new ReservationService();
	
	//음식점 예약
	public int createReservation(String reservation_date,String reservation_time,int seat,String name, String phone, int rest_id) {
		return reserDAO.insertReservation(reservation_date,reservation_time,seat,name,phone,rest_id);
	}
	
	//발급번호로 예약 조회
	public String searchReservation(int reservation_id) {
		try {
			return reserDAO.findReservationById(reservation_id).get().toString();
			
		}catch(NoSuchElementException e) {
			return "해당 번호의 예약이 없습니다. 예약번호를 확인해주세요.";
		}
	}
	
	//예약 취소
	public void cancelReservation(int reservation_id) {
		rs.statusChk(reservation_id); // 확정된 예약 취소 못하게
	}
	
	//음식점 리스트 불러오기
	public void restaurantList() {
		restDAO.listRestaurant();
	}
	
}
