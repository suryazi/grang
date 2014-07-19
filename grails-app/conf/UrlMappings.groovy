class UrlMappings {

	static mappings = {
		
		"/phones/phones.json" {
			controller = "phones"
		}
		
		"/phones/${phoneId}.json" {
			controller = "phones"
			action = "showPhone"
		}

		"/books/books.json" {
			controller = "book"
		}

		"/books/${bookId}.json" {
			controller = "book"
			action="showBook"
		}
		
        "/"(view:"/index")
	}

}
