package com.jisu.Repo;

import java.util.List;

import com.jisu.model.Booking;

public interface BookingRepo {
	public void addBooking(Booking book);
	
	public List<Booking> showall();
	
	
}
