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
	private int reservation_state_num;
	private String reservation_state_String;
	private RestaurantDTO restDTO;
	
	
	public ReservationDTO() {
		// TODO Auto-generated constructor stub
	}


	public ReservationDTO(int reservation_id, String reservation_date, String reservation_time, String requested_date,
			String requested_time, int seat, String name, String phone, int reservation_state_num, RestaurantDTO restDTO) {
		super();
		this.reservation_id = reservation_id;
		this.reservation_date = reservation_date;
		this.reservation_time = reservation_time;
		this.requested_date = requested_date;
		this.requested_time = requested_time;
		this.seat = seat;
		this.name = name;
		this.phone = phone;
		this.reservation_state_num = reservation_state_num;
		this.restDTO = restDTO;
	}

	@Override
	public String toString() {
		setReservation_state_String();
		return String.format("예약번호: %d\n음식점: %s\n예약일: %s\n예약시간: %s\n예약요정일, 시간:%s,%s\n인원수: %d\n성함: %s\n연락처: %s\n예약상태: %s\n", 
				reservation_id, restDTO.getRestaurant_name(),reservation_date, reservation_time, requested_date,requested_time,seat,name,phone,reservation_state_String);
	}


	public int getReservation_id() {
		return reservation_id;
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


	public int getReservation_state_num() {
		return reservation_state_num;
	}


	public void setReservation_state_num(int reservation_state_num) {
		this.reservation_state_num = reservation_state_num;
	}


	public String getReservation_state_String() {
		return reservation_state_String;
	}


	public void setReservation_state_String() {
		if(reservation_state_num == 1) {
			this.reservation_state_String = "대기";
		}else if(reservation_state_num == 2) {
			this.reservation_state_String = "확정";
		}else if(reservation_state_num ==3) {
			this.reservation_state_String = "취소";
		}else if(reservation_state_num==4) {
			this.reservation_state_String = "반려";
		}
	}


	public RestaurantDTO getRestDTO() {
		return restDTO;
	}


	public void setRestDTO(RestaurantDTO restDTO) {
		this.restDTO = restDTO;
	}

	
	
	//get set
	
	




	
	
	

}
