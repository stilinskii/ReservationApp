package main.java.reservationApp.controller;

import java.sql.SQLException;

import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;

public class AdminMenu {
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	ReservationService rs = new ReservationService();
	
	//음식점 등록  /오늘
	public void addRestaurant(String name, String type, int max_seat, String manager_pw) {
		//String name, String type, int max_seat, String manager_pw//최대10자
		restDAO.insertRestaurant(name, type, max_seat, manager_pw);
	}
	
	//음식점 삭제  /오늘
	
	//음식점 메뉴등록
	
	//음식점 메뉴삭제
	
	//예약승인 /오늘
	
	//예약취소 /오늘
	
	//대기중 예약 목록 보기 
	
	//예약 전체목록 /오늘 - 관리자마다 다르게
	public void reservationList(String managerPW) {
		try {
			rs.findReservationByRestaurant(restDAO.findByPw(managerPW).get());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//예약불가날자 설정
	
	// 비밀번호 인증
	public boolean chkManagerPw(String managerPW) throws ClassNotFoundException, SQLException {
		
		return restDAO.findByPw(managerPW).isPresent();
	}

}
