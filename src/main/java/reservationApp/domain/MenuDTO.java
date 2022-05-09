package main.java.reservationApp.domain;

public class MenuDTO {
	private int menu_id;
	private String menu_name;
	private int menu_price;
	private RestaurantDTO restaurantDTO;
	
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(int menu_id, String menu_name, int menu_price, RestaurantDTO restaurantDTO) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.restaurantDTO = restaurantDTO;
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

	public RestaurantDTO getRestaurantDTO() {
		return restaurantDTO;
	}

	public void setRestaurantDTO(RestaurantDTO restaurantDTO) {
		this.restaurantDTO = restaurantDTO;
	}
	
	

}
