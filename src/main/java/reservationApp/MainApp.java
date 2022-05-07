package main.java.reservationApp;

import java.util.Scanner;

import main.java.reservationApp.controller.MainMenu;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static MainMenu mainmenu = new MainMenu();

	public static void main(String[] args) {
		
		
		while(true){
			System.out.println("[메인화면]");
			System.out.println("1: 음식점 예약하기\r\n"
					+ "2: 예약 확인하기\r\n"
					+ "3: 예약 취소하기\r\n"
					+ "4: 관리자 메뉴로 이동\r\n"
					+ "0: 종료\r\n"
					+ "");
			System.out.print("메뉴를 선택하세요: ");
			int num = sc.nextInt();		
			
			switch (num){
			case 1:reserve();break;
			case 2:searchReservation();break;
			case 0:return;
			}
					
					
		}
		
		
	}
	
	//음식점 예약
	public static void reserve() {
		//레스토랑 리스트 불러오기
		System.out.println("[음식점 예약하기]");
		mainmenu.restaurantList();
		System.out.print("예약할 식당의 번호를 입력해주세요: ");
		//String reservation_date,String reservation_time,int seat,String name, 
		//String phone, int rest_id
		int rest_id = sc.nextInt();
		sc.nextLine();
		System.out.print("예약일을 입력해주세요(예: 20220508): ");
		String reservation_date = sc.nextLine();
		System.out.print("예약시간 입력해주세요(예:15:00): ");
		String reservation_time = sc.nextLine();
		System.out.print("인원수를 입력해주세요: ");
		int seat = sc.nextInt();
		sc.nextLine();
		System.out.print("예약자 성함을 입력해주세요: ");
		String name = sc.nextLine();
		System.out.print("예약자 연락처를 입력해주세요: ");
		String phone = sc.nextLine();
		System.out.println("예약이 완료되었습니다!");
		System.out.println();
		
		mainmenu.createReservation(reservation_date, reservation_time, seat, name, phone, rest_id);
	}
	
	//발급번호로 예약 조회
	public static void searchReservation() {
		System.out.println("[예약 조회하기]");
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		System.out.println();
		System.out.println("[예약정보]");
		System.out.println(mainmenu.searchReservation(reservation_id));
		
	}
	
	
	//예약취소
	public static void deleteReservation() {
		System.out.println("[예약 취소하기]");
		System.out.print("예약번호를 입력해주세요: ");
		int reservation_id = sc.nextInt();
		mainmenu.cancelReservation(reservation_id);
		
	}

}
