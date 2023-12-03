package com.pratyush.restfulwebservice.exception;

import java.time.LocalDate;

public class ErrorDetail {

	private LocalDate timestamp;
	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetail(LocalDate timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetail [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	private String message;
	private String details;
}

/*
 * {
    "timestamp": "2023-12-02",
    "message": "User Not Found for id = 9",
    "details": "uri=/users/9"
}
 * 
 */
  
