package main.java.reservationApp;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import main.java.reservationApp.controller.AdminMenu;
import main.java.reservationApp.controller.MainMenu;

public class MainApp {
	static Scanner sc = new Scanner(System.in);
	static MainMenu mainmenu = new MainMenu();
	static AdminMenu adminMenu = new AdminMenu();

	public static void main(String[] args) {
		
		
		while(true){
			System.out.println("[메인화면]");
			System.out.println("1: 음식점 예약하기\r\n"
					+ "2: 예약 확인하기\r\n"
					+ "3: 예약 취소하기\r\n"
					+ "4: 관리자 등록(입점하기)\r\n"
					+ "5: 관리자 메뉴로 이동\r\n"
					+ "0: 종료\r\n"
					+ "");
			System.out.print("메뉴를 선택하세요: ");
			int num = sc.nextInt();		
			
			switch (num){
			case 1:reserve();break;
			case 2:searchReservation();break;
			case 3:deleteReservation();break;
			case 4:managerRegister();break;
			case 5:new ManagerPage();break;
			case 0:return;
			}
					
					
		}
		
		
	}
	
	//음식점 예약
	public static void reserve() {
		//예약번호 발급을 위해
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		//레스토랑 리스트 불러오기
		System.out.println("[음식점 예약하기]");
		mainmenu.restaurantList(); 
		
		// 남은 좌석수 정보도 변동되게 추가해야함....
		
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
		int reservation_id = Integer.parseInt(sdf.format(new Date()));
		System.out.println("[예약번호: "+reservation_id +"] 예약이 요청되었습니다!");
		System.out.println();
		
		mainmenu.createReservation(reservation_id,reservation_date, reservation_time, seat, name, phone, rest_id);
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
		System.out.println("에약 취소가 완료되었습니다.");
		
	}
	
	
	//입점하기
	public static void managerRegister() {
		sc.nextLine();
		System.out.println("[음식점 등록하기]");
		//String name, String type, int max_seat, String manager_pw 최대10자
		System.out.print("음식점 이름: ");
		String name = sc.nextLine();
		System.out.print("음식종류(ex) 한식, 중식, 양식, 일식): ");
		String type = sc.nextLine();
		System.out.print("수용가능 인원수: ");
		int max_seat = sc.nextInt();
		sc.nextLine();
		System.out.print("관리자 비밀번호 설정(문자,숫자포함5자): ");
		String manager_pw = sc.nextLine();
		
		adminMenu.addRestaurant(name, type, max_seat, manager_pw);
		System.out.println("등록이 완료되었습니다. 관리자 메뉴로 이동하여 메뉴를 추가하세요.");
		
	}
	
	
}
