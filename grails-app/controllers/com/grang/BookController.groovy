package com.grang

import grails.converters.JSON

class BookController {

     def index() {
		def json = Book.list() as JSON
		render json
	}
		
    def showBook() {
		def json = Book.findById(params.bookId) as JSON
		render json
    }
}
