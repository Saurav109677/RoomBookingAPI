package com.virtualpairprogrammers.roombooking.model.entities;

public class AngularUser {
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AngularUser [id=" + id + ", name=" + name + "]";
	}
	
	public AngularUser() {
		
	}
	
	public AngularUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public User asUser() {
		User u=new User();
		u.setId(this.id);
		u.setName(this.name);
		u.setPassword("dddd");
		return u;
	}
	
}
