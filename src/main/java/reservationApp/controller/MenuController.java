package main.java.reservationApp.controller;

import main.java.reservationApp.repository.MenuDAO;
import main.java.reservationApp.repository.ReservationDAO;
import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.ReservationService;
import main.java.reservationApp.service.RestaurantService;

public class MenuController {
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	ReservationDAO reserDAO = ReservationDAO.getInstance();
	ReservationService reserService = new ReservationService();
	RestaurantService restService = new RestaurantService();
	MenuDAO menuDAO = MenuDAO.getInstance();

	// 메뉴 리스트
	public void menuList(String managerPW) {
		menuDAO.menuListByRestaurantId(restDAO.findByPw(managerPW).get());
	}

	public void menuList(int restaurant_id) {
		menuDAO.menuListByRestaurantId(restaurant_id);
	}

	
	// 메뉴등록
	public int createMenu(String menuName, int price, String managerPW) {
		return menuDAO.insertMenu(menuName, price, restDAO.findByPw(managerPW).get());

	}

	// 메뉴삭제
	public int deleteMenu(int menu_id) {
		return menuDAO.deleteMenu(menu_id);
	}

}
