package main.java.reservationApp.domain;

public class RestaurantDTO {
	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_type;
	private int max_seat_count;
	private int reserved_seat;
	private int available_state;
	
	
	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}


	public RestaurantDTO(int restaurant_id, String restaurant_name, String restaurant_type, int max_seat_count,
			int reserved_seat, int available_state) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_type = restaurant_type;
		this.max_seat_count = max_seat_count;
		this.reserved_seat = reserved_seat;
		this.available_state = available_state;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}


	public int getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public String getRestaurant_name() {
		return restaurant_name;
	}


	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}


	public String getRestaurant_type() {
		return restaurant_type;
	}


	public void setRestaurant_type(String restaurant_type) {
		this.restaurant_type = restaurant_type;
	}


	public int getMax_seat_count() {
		return max_seat_count;
	}


	public void setMax_seat_count(int max_seat_count) {
		this.max_seat_count = max_seat_count;
	}


	public int getReserved_seat() {
		return reserved_seat;
	}


	public void setReserved_seat(int reserved_seat) {
		this.reserved_seat = reserved_seat;
	}


	public int getAvailable_state() {
		return available_state;
	}


	public void setAvailable_state(int available_state) {
		this.available_state = available_state;
	}  
	
	
}


