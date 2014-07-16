package com.grang

class Camera {

    String primaryCamera
	
	static hasMany = [
		features : String
		]
	
	static belongsTo = [PhoneDetail]
	
    static constraints = {
    }
	
}
