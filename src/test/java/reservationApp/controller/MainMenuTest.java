package test.java.reservationApp.controller;

import org.junit.jupiter.api.Test;

import main.java.reservationApp.controller.ReservationController;

class reservationControllerTest {
	ReservationController mm = new ReservationController();
	
	@Test 
	void searchReservation() {
		mm.searchReservation(21712);
	}

}
