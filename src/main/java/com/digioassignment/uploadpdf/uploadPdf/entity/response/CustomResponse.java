package com.digioassignment.uploadpdf.uploadPdf.entity.response;

public class CustomResponse {
	
	private int statusCode;
	private String message;
	
	
	public CustomResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "\nCustomResponse [\nstatusCode=" + statusCode + ", \nmessage=" + message + "\n]";
	}
	
	

}
