package com.grang

class Display {

    String screenResolution
	String screenSize
	String touchScreen
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
}
