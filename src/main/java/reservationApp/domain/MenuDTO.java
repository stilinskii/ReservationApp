package main.java.reservationApp.domain;

public class MenuDTO {
	private int menu_id;
	private String menu_name;
	private int menu_price;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(int menu_id, String menu_name, int menu_price) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}

	@Override
	public String toString() {
		
		return "[" + menu_id +"]  "+ menu_name+"  "+menu_price+"원";
	}
	
	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	

}
