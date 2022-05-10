package main.java.reservationApp;

import java.sql.SQLException;
import java.util.Scanner;


import main.java.reservationApp.controller.RestaurantController;
import main.java.reservationApp.domain.ReservationDTO;
import main.java.reservationApp.controller.MenuController;
import main.java.reservationApp.controller.ReservationController;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	static ReservationController reservationController = new ReservationController();
	static RestaurantController restaurantController = new RestaurantController();
	static MenuController menuController = new MenuController();
	 
	public AdminMenu() {
		
		//관리자메뉴로 이동
			
			System.out.println("[관리자 인증]");
			System.out.print("비밀번호: ");
			String managerPW = sc.next();
			try {
				restaurantController.chkManagerPw(managerPW);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("비밀번호 불일치");
				return;
			}
			
			
			while(true) {
				System.out.println("[<"+restaurantController.findRestaurantNameByPw(managerPW)
									+"> 관리자 페이지]");
				System.out.println("1: 메뉴 등록하기\r\n"
						+ "2: 메뉴 삭제하기\r\n"
						+ "3: 예약 승인하기\r\n"
						+ "4: 예약 취소하기\r\n"
						+ "5: 예약내역 목록 보기\r\n"
						+ "6: 음식점 목록 보기 \r\n"
						+ "7: 퇴점하기\r\n"
						+ "0: 메인메뉴로 이동\r\n"
						+ "");
				System.out.print("메뉴를 선택하세요: ");
				int num = sc.nextInt();		
				
				
				switch (num){
				case 1:createMenu(managerPW);break;
				case 2:deleteMenu(managerPW);break;
				case 3:confirmReservation(managerPW);break;
				case 4:refuseReservation(managerPW);break;
				case 5:reservationList(managerPW);break;
				case 6:restaurantList();break;
				case 7:deleteRestaurant(managerPW);return;
				case 0:return;
				default: System.out.println("알맞은 숫자를 입력해주세요");
				}
				
			}
			
		
	}
	//비밀번호에따른 각 레스토랑의 예약들 리스트 출력
	public static void reservationList(String managerPW) {
		reservationController.allReservations(managerPW);
	}
	
	public static void deleteRestaurant(String managerPW) {
		restaurantController.deleteRestaurant(managerPW);
	}
	
	public static void confirmReservation(String managerPW) {
		//1.비번에 따른 예약대기목록  출력
		System.out.println("[예약승인]");
		reservationController.waitingReservations(managerPW);
		//2.예약번호로 예약선택 후 상태 변경
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		reservationController.comfirmReservations(reservation_id);
	}
	
	public static void refuseReservation(String managerPW) {
		System.out.println("[예약거절]");
		reservationController.waitingReservations(managerPW);
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		reservationController.refuseReservation(reservation_id);
		
	}
	
	public static void restaurantList() {
		restaurantController.restaurantList();
	}
	
	public static void createMenu(String managerPW) {
		sc.nextLine();
		System.out.println("[메뉴등록]");
		System.out.print("메뉴이름: ");
		String menu_name = sc.nextLine();
		System.out.print("가격: ");
		int menu_price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("메뉴 "+menuController.createMenu(menu_name, menu_price, managerPW)+"개 추가 완료");
	}
	
	public static void deleteMenu(String managerPW) {
		System.out.println("[메뉴삭제]");
		menuController.menuList(managerPW);
		System.out.print("삭제할 메뉴의 번호를 입력하세요: ");
		int menu_id = sc.nextInt();
		
		System.out.println("메뉴 "+menuController.deleteMenu(menu_id)+"개 삭제 완료");
		
		
	}
	
}
