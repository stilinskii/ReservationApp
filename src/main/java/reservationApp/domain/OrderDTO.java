package main.java.reservationApp.domain;

public class OrderDTO {
	private int count; // 메뉴개수
	private int total_price; // 메뉴개수에따른 총 가격
	private int menu_id;// 메뉴아이디
	private int reservation_id;// 예약아이디
	private MenuDTO menuDTO; // 주문서를 만들기 위해 메뉴 이름과 가격이 필요함.

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int count, int total_price, MenuDTO menuDTO) {
		super();
		this.count = count;
		this.total_price = total_price;
		this.menuDTO = menuDTO;
	}

	@Override
	public String toString() {
		
		return String.format("-%-5s  %d개  %6d원",menuDTO.getMenu_name(),count,menuDTO.getMenu_price());
	}

	public MenuDTO getMenuDTO() {
		return menuDTO;
	}

	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

}
