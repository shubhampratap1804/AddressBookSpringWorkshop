package com.addressbook.dto;

import lombok.Data;

@Data
public class ResponseDTO {

	//Class variables and objects
	private String message;
	private Object data;

	//Created constructors
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}
}
