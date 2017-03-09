package com.web.mvvm.model;

import java.util.List;

public class User {

	private int id;
	private String username;
	private String email;
	private List<User> friends;

	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

}
