package com.mchacks.blindr.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;



public class Message extends Event{

	public enum Gender {
		Male, Female, Custom
	};

	private String message;
	private ArrayList<UUID> idsMessage;
	private boolean isIncoming;
	private String fakeName;
	private Gender gender;

	public Message(User user, String message, boolean isIncoming){
		this(null, null, null, user, message, null, Gender.Custom, isIncoming);
	}

	public Message(UUID id, Timestamp timestamp, IDestination destination, User user, String message, String fakeName, Gender gender, boolean isIncoming) {
		super(id, timestamp, destination, user);
		this.message = message;
		this.isIncoming = isIncoming;
		idsMessage = new ArrayList<UUID>();
		idsMessage.add(id);
		this.fakeName = fakeName;
		this.gender = gender;
	}

	public boolean isIncoming(){
		return isIncoming;
	}

	public String getMessage(){
		return message;
	}

	public void addMessage(String newMessage, UUID id){
		message = message + "\n" + newMessage;
		idsMessage.add(id);
	}

	public ArrayList<UUID> getIdsMessage(){
		return idsMessage;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Message){
			Message other = (Message) o;
			if(idsMessage.contains(other.getId())){
				return true;
			}
		}

		return false;
	}

	public String getFakeName() {
		return fakeName;
	}

	public void setFakeName(String name) {
		fakeName = name;
	}


	public Gender getGender() {
		return gender;
	}

}