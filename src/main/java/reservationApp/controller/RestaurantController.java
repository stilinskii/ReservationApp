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
	RestaurantService restService = new RestaurantService();
	
	//음식점 등록
	public void addRestaurant(String name, String type, int max_seat, String manager_pw) {
		restService.registerManager(name, type, max_seat, manager_pw);
	}
	
	//음식점 삭제 
	public void deleteRestaurant(String managerPw) {
		restDAO.deleteRestaurant(managerPw);
	}
	
	
	// 비밀번호 인증
	public boolean chkManagerPw(String managerPW) throws ClassNotFoundException, SQLException {
		return restDAO.findRestaurantIdByPw(managerPW).isPresent();
	}
	
	//음식점들 리스트
	public void restaurantList() {
		restDAO.listRestaurant();
	}

	//비밀번호로 음식점 이름 불러오기
	public String findRestaurantNameByPw(String managerPW) {
		return restDAO.findRestaurantNameByPw(managerPW);
	}
	
	//예약불가날자 설정 - 뺌
}
