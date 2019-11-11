package com.example.demo.model;

public class ResponseBody {
	String message;
	public ResponseBody() {
		
	}
	public ResponseBody(String msg) {
		this.message=msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
