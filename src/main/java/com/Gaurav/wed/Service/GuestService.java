package com.Gaurav.wed.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Gaurav.wed.entity.GuestVisit;

@Service
public interface GuestService {
	void saveGuest(String name);
	
	List<GuestVisit> getAllGuests();

}


