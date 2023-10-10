package com.lab.logic;

public class Player {

	  int playerId = -1;
	  String first_name=null;
	  String last_name=null;
	  String address=null;
	  String postal_code=null;
	  String province=null;
	  String phone_number=null;
	  
	  public Player(){
		  super();
	  }
	public Player(int playerId, String first_name, String last_name, String address, String postal_code,
			String province, String phone_number) {
		super();
		this.playerId = playerId;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.postal_code = postal_code;
		this.province = province;
		this.phone_number = phone_number;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	  
	  
	
}
