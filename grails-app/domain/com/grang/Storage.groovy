package com.grang

class Storage {

    String flash
	String ram
	
	static belongsTo = [PhoneDetail]
	
	static constraints = {
		flash  nullable : true
		ram  nullable : true
	}
}
