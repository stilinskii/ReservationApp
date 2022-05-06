package main.java.reservationApp.domain;

public class ReservationDTO {
	private int reservation_id;
	private String reservation_date;
	private String reservation_time;
	private String requested_date;
	private String requested_time;
	private int seat;
	private String name;
	private String phone;
	private int reservation_state;
	private RestaurantDTO restDTO;
	
	
	public ReservationDTO() {
		// TODO Auto-generated constructor stub
	}


	public ReservationDTO(int reservation_id, String reservation_date, String reservation_time, String requested_date,
			String requested_time, int seat, String name, String phone, int reservation_state, RestaurantDTO restDTO) {
		super();
		this.reservation_id = reservation_id;
		this.reservation_date = reservation_date;
		this.reservation_time = reservation_time;
		this.requested_date = requested_date;
		this.requested_time = requested_time;
		this.seat = seat;
		this.name = name;
		this.phone = phone;
		this.reservation_state = reservation_state;
		this.restDTO = restDTO;
	}

	@Override
	public String toString() {
		return String.format("예약번호: %d\n예약일: %s\n예약시간: %s\n예약요정일:%s,%s\n인원수: %d\n성함: %s\n연락처: %s\n예약상태: %d\n음식점: %s\n", 
				reservation_id, reservation_date, reservation_time, requested_date,requested_time,seat,name,phone,reservation_state,restDTO.getRestaurant_name());
	}

	
	
	//get set
	
	

	public int getReservation_id() {
		return reservation_id;
	}


	public RestaurantDTO getRestDTO() {
		return restDTO;
	}


	public void setRestDTO(RestaurantDTO restDTO) {
		this.restDTO = restDTO;
	}


	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}


	public String getReservation_date() {
		return reservation_date;
	}


	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}


	public String getReservation_time() {
		return reservation_time;
	}


	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}


	public String getRequested_date() {
		return requested_date;
	}


	public void setRequested_date(String requested_date) {
		this.requested_date = requested_date;
	}


	public String getRequested_time() {
		return requested_time;
	}


	public void setRequested_time(String requested_time) {
		this.requested_time = requested_time;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getReservation_state() {
		return reservation_state;
	}


	public void setReservation_state(int reservation_state) {
		this.reservation_state = reservation_state;
	}


	
	
	

}
