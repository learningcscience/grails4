package grails4

import grails.plugin.springsecurity.annotation.Secured


class BookController {



    @Secured('ROLE_ADMIN')
    def createABook(){
        def book = new Book(title: "Book", author: "Author")
        book.save()

        redirect(actionName: "index")
        return
    }


    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def index() {

        def books = Book.list()

        [books: books]

    }
}
