package com.te.ramayana.exception;

public class handleEmptyInput extends RuntimeException{
	String massage;
	public handleEmptyInput(String msg){
		super(msg);
		this.massage=msg;
	}

}

