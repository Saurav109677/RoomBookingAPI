package com.virtualpairprogrammers.roombooking.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualpairprogrammers.roombooking.data.RoomRepository;
import com.virtualpairprogrammers.roombooking.data.UserRepository;
import com.virtualpairprogrammers.roombooking.model.Layout;
import com.virtualpairprogrammers.roombooking.model.entities.AngularUser;
import com.virtualpairprogrammers.roombooking.model.entities.LayoutCapacity;
import com.virtualpairprogrammers.roombooking.model.entities.Room;
import com.virtualpairprogrammers.roombooking.model.entities.User;

@RestController
@RequestMapping("/api")
@CrossOrigin("https://saurav109677.github.io")
public class RestControllers {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private UserRepository userRepo;
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id")long id) {
		userRepo.deleteById(id);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public void deleteRoom(@PathVariable("id") long id) {
		 roomRepository.deleteById(id);
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms(){
		return roomRepository.findAll();		
	}
	
	@GetMapping("/room/{id}")
	public Room getRoom(@PathVariable("id") long id) {
		return roomRepository.findById(id).get();
	}
	
	@PostMapping("/room")
	public Room addRoom(@RequestBody Room r1) {
		return roomRepository.save(r1);
	}
	
	@PutMapping("/room")
	public Room updateRoom(@RequestBody Room r1) {
		//throw new RuntimeException();
		return roomRepository.save(r1);
		//return null;
	}
	
	@GetMapping("/users")
	public List<AngularUser> getAllUsers(){
		List<User> users= userRepo.findAll();
		List<AngularUser> angularUsers=new ArrayList<AngularUser>();
		ListIterator<User> iterator=users.listIterator();
		while(iterator.hasNext()) {
			User u1=iterator.next();
			AngularUser aUser=new AngularUser(u1);
			angularUsers.add(aUser);
		}
		return angularUsers;
	}
	
	
	@GetMapping("/user/{id}")
	public AngularUser getUserById(@PathVariable("id") long id){
		return new AngularUser(userRepo.findById(id).get());
	}
	
	@PutMapping("/user")
	public AngularUser updateUser(@RequestBody AngularUser aUser) {
		User u=userRepo.findById(aUser.getId()).get();
		u.setName(aUser.getName());
		System.out.println(u);
		return new AngularUser(userRepo.save(u));
	}
	
	@PostMapping("/user")
	public AngularUser addUser(@RequestBody User aUser) {
		return new AngularUser(userRepo.save(aUser));	
	}
	
	@GetMapping("/allUsers")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	
}
