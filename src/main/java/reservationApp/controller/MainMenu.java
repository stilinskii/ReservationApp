package main.java.reservationApp.controller;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

public class MainMenu {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	
	//음식점 예약
	public int createReservation(String reservation_date,String reservation_time,int seat,String name, String phone, int rest_id) {
		return reserDAO.insertReservation(reservation_date,reservation_time,seat,name,phone,rest_id);
	}
	
	//발급번호로 예약 조회
	public ReservationDTO searchReservation(int reservation_id) {
		
		return reserDAO.findReservationById(reservation_id).get();
	}
	
	//예약 취소
	public int cancelReservation(int reservation_id) {
		return reserDAO.deleteReservation(reservation_id);
	}
	
	//음식점 리스트 불러오기
	public void restaurantList() {
		restDAO.listRestaurant();
	}
	
}
