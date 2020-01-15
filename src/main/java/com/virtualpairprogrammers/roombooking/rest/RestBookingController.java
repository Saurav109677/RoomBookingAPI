package com.virtualpairprogrammers.roombooking.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.roombooking.data.BookingRepository;
import com.virtualpairprogrammers.roombooking.model.entities.Booking;

@RestController
@CrossOrigin("https://saurav109677.github.io")
@RequestMapping("/api")
public class RestBookingController {
	
	@Autowired
	BookingRepository bookRepo;
	
	@GetMapping("/booking/{dateInString}")
	public List<Booking> getBookingByDate(@PathVariable("dateInString") String date){
		Date dateInSql=Date.valueOf(date);
		return bookRepo.findAllByDate(dateInSql);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBooking(@PathVariable("id")long id) {
		bookRepo.deleteById(id);
	}
	
	@GetMapping
	public Booking getBookingById(@RequestParam("id") long id) {
		return bookRepo.findById(id).get();
	}
	
	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking modifiedBooking) {
		System.out.println("form angular8:"+modifiedBooking.getStartTime());
		Booking b= bookRepo.findById(modifiedBooking.getId()).get();
		b.setRoom(modifiedBooking.getRoom());
		b.setUser(modifiedBooking.getUser());
		b.setDate(modifiedBooking.getDate());
		b.setEndTime(modifiedBooking.getEndTime());
		b.setLayout(modifiedBooking.getLayout());
		b.setParticipants(modifiedBooking.getParticipants());
		b.setStartTime(modifiedBooking.getStartTime());
		b.setTitle(modifiedBooking.getTitle());
		//modifiedBooking.setId(b.getId());
		
		return bookRepo.save(b);
	}
}
