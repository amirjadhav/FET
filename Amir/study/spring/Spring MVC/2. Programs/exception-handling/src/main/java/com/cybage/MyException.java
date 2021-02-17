package com.cybage;

public class MyException extends RuntimeException{
	private String exceptionMsg;

	public MyException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	public String getExceptionMsg(){
		return this.exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
