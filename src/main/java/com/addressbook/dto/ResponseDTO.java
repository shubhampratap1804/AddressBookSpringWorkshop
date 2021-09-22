package com.addressbook.dto;

public class ResponseDTO {

	//Class variables and objects
	private String message;
	private Object data;

	//Created constructor
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
