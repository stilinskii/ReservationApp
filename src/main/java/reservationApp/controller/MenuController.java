package main.java.reservationApp.controller;

import java.util.List;

import main.java.reservationApp.domain.MenuDTO;
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
		menuDAO.menuListByRestaurantId(restDAO.findRestaurantIdByPw(managerPW).get())
				.forEach(e -> System.out.println(e));
	}

	
	public void menuList(int restaurant_id) {
		menuDAO.menuListByRestaurantId(restaurant_id)
				.forEach(e -> System.out.println(e));
	}
	
	//주문서 구성을 위해 메뉴의 가격만 가져오기
	public int menu_price(int restaurant_id,int menu_id) {
		return menuDAO.menuListByRestaurantId(restaurant_id).stream()
				.filter(e -> e.getMenu_id() == menu_id)
				.findAny().get().getMenu_price();
	}
	
	// 메뉴등록
	public int createMenu(String menuName, int price, String managerPW) {
		return menuDAO.insertMenu(menuName, price, restDAO.findRestaurantIdByPw(managerPW).get());
	}

	// 메뉴삭제
	public int deleteMenu(int menu_id) {
		return menuDAO.deleteMenu(menu_id);
	}
	
	
	


}
