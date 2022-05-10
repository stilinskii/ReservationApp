package main.java.reservationApp.service;

import java.sql.SQLIntegrityConstraintViolationException;

import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;

public class RestaurantService {
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	
	//비밀번호 중복체크 
	public boolean pwDuplicateChk(String manager_pw) {
		return restDAO.findRestaurantIdByPw(manager_pw).isPresent();
	}
	
	public void registerManager(String name, String type, int max_seat, String manager_pw) {
		
		if(pwDuplicateChk(manager_pw)) {
			System.out.println("비밀번호 중복, 다시 시도해주세요");
		}else {
			restDAO.insertRestaurant(name, type, max_seat, manager_pw);
			System.out.println("등록이 완료되었습니다. 관리자 메뉴로 이동하여 메뉴를 추가하세요.");
		}
		
	}

	

}
