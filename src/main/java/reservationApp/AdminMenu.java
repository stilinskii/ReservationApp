package main.java.reservationApp;

import java.sql.SQLException;
import java.util.Scanner;

import main.java.reservationApp.controller.RestaurantController;
import main.java.reservationApp.controller.ReservationController;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	static ReservationController reservationController = new ReservationController();
	static RestaurantController restaurantController = new RestaurantController();

	 
	public AdminMenu() {
		
		//관리자메뉴로 이동
			System.out.println("[관리자 인증]");
			System.out.print("비밀번호: ");
			String managerPW = sc.nextLine();
			try {
				restaurantController.chkManagerPw(managerPW);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("비밀번호 불일치");
				return;
			}
			
			
			while(true) {
				System.out.println("[관리자 페이지]");
				System.out.println("1: 메뉴 등록하기\r\n"
						+ "2: 메뉴 삭제하기\r\n"
						+ "3: 예약 승인하기\r\n"
						+ "4: 예약 취소하기\r\n"
						+ "5: 예약내역 목록 보기\r\n"
						+ "6: 음식점 목록 보기 \r\n"
						+ "7: 예약불가 날짜 설정하기\r\n"
						+ "8: 퇴점하기\r\n"
						+ "0: 메인메뉴로 이동\r\n"
						+ "");
				System.out.print("메뉴를 선택하세요: ");
				int num = sc.nextInt();		
				
				
				switch (num){
				case 3:confirmReservation(managerPW);break;
				case 4:refuseReservation(managerPW);break;
				case 5:reservationList(managerPW);break;
				case 6:restaurantList();break;
				case 8:deleteRestaurant(managerPW);return;
				case 0:return;
				}
				
			}
			
		
		

		
		
	}
	//비밀번호에따른 각 레스토랑의 예약들 리스트
	public static void reservationList(String managerPW) {
		reservationController.reservationList(managerPW);
	}
	
	//음식점 삭제
	public static void deleteRestaurant(String managerPW) {
		restaurantController.deleteRestaurant(managerPW);
		System.out.println("퇴점이 완료되었습니다.");
		
	}
	
	public static void confirmReservation(String managerPW) {
		//1.비번에 따른 예약대기목록  출력
		//2.예약번호로 예약선택 후 상태 변경
		sc.nextLine();
		System.out.println("[예약승인]");
		reservationController.reservationList(managerPW);
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		reservationController.comfirmReservations(reservation_id);
	}
	
	public static void refuseReservation(String managerPW) {
		sc.nextLine();
		System.out.println("[예약거절]");
		reservationController.reservationList(managerPW);
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		reservationController.refuseReservation(reservation_id);
		
	}
	
	public static void restaurantList() {
		
	}
	
	
}
