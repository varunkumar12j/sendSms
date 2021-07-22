package com.sendsms;

public enum Accounts {
 Varun("varun.kumar","Anu12jv@run92","DC2C06AA-2A6A-9C0D-0141-8CDEF0E6002A");
	
	String userName, password, Keys;
	
	
	Accounts(String userName, String password, String Keys) {
		this.userName = userName;
		this.password = password;
		this.Keys = Keys;
	}
	
	
	public String getUseName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getKey() {
		return Keys;
	}
	
}
