package com.grang

class Android {

    String os
	String ui
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
		ui  nullable : true
    }
}