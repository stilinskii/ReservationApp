package main.java.reservationApp.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.domain.RestaurantDTO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;
import main.java.reservationApp.service.RestaurantService;

public class RestaurantController {
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	ReservationService reserService = new ReservationService();
	RestaurantService restService = new RestaurantService();
	
	//음식점 등록
	public void addRestaurant(String name, String type, int max_seat, String manager_pw) {
		//String name, String type, int max_seat, String manager_pw//최대10자
		restDAO.insertRestaurant(name, type, max_seat, manager_pw);
	}
	
	//음식점 삭제 
	public void deleteRestaurant(String managerPw) {
		restDAO.deleteRestaurant(managerPw);
	}
	
	
	// 비밀번호 인증
	public boolean chkManagerPw(String managerPW) throws ClassNotFoundException, SQLException {
		return restDAO.findByPw(managerPW).isPresent();
	}
	
	//음식점들 리스트
	public void restaurantList() {
		restDAO.listRestaurant();
	}

	
	//예약불가날자 설정
}
