package main.java.reservationApp.controller;

import main.java.reservationApp.repository.RestaurantDAO;
import main.java.reservationApp.service.RestaurantService;

public class RestaurantController {
	RestaurantDAO restDAO = RestaurantDAO.getInstance();
	RestaurantService restService = new RestaurantService();
	
	//음식점 등록
	public void addRestaurant(String name, String type, int max_seat, String manager_pw, String workingTime) {
		restService.registerManager(name, type, max_seat, manager_pw,workingTime);
	}
	
	//음식점 삭제 
	public void deleteRestaurant(String managerPw) {
		restDAO.deleteRestaurant(managerPw);
	}
	
	// 비밀번호 인증
	public boolean chkManagerPw(String managerPW) {
		return restDAO.findRestaurantIdByPw(managerPW).isEmpty();
	}
	
	//음식점들 리스트
	public void restaurantList() {
		System.out.println(" 번호  |   음식점이름   |   종류   |  수용가능 인원  |  영업시간 ");
		System.out.println("----------------------------------------------------------");
		restDAO.listRestaurant();
	}

	//비밀번호로 음식점 이름 불러오기
	public String findRestaurantNameByPw(String managerPW) {
		return restDAO.findRestaurantNameByPw(managerPW);
	}
	
	//영업시간사이에 주문한건지 체크
		public boolean timeChk(String reservation_time, int restaurant_id) {
			
			String[] workingTime = restDAO.restaurantWorkingTime(restaurant_id).split("~");
			int openTimeHour = Integer.parseInt(workingTime[0].split(":")[0]);
			int closeTimeHour = Integer.parseInt(workingTime[1].split(":")[0]);
			int reservation_time_hour = Integer.parseInt(reservation_time.split(":")[0]);
			
			if(reservation_time_hour >= openTimeHour && reservation_time_hour < closeTimeHour) {
				return true;
			}else {
				return false;
			}
		}
	
	//예약불가날자 설정 - 뺌
}
