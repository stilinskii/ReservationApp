package main.java.reservationApp;

import java.sql.SQLException;
import java.util.Scanner;

import main.java.reservationApp.controller.AdminMenu;
import main.java.reservationApp.controller.MainMenu;

public class ManagerPage {
	static Scanner sc = new Scanner(System.in);
	static MainMenu mainmenu = new MainMenu();
	static AdminMenu adminMenu = new AdminMenu();

	 
	public ManagerPage() {
		
		//관리자메뉴로 이동
			System.out.println("[관리자 인증]");
			System.out.print("비밀번호: ");
			String managerPW = sc.nextLine();
			try {
				adminMenu.chkManagerPw(managerPW);
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
				case 5:reservationList(managerPW);break;
				case 8:reservationList(managerPW);break;
				case 0:return;
				}
				
			}
			
		
		

		
		
	}
	//비밀번호에따른 각 레스토랑의 예약들 리스트
	public static void reservationList(String managerPW) {
		adminMenu.reservationList(managerPW);
	}
	
	//음식점 삭제
	
	
	
	
	
}
