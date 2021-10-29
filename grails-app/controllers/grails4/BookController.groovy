package grails4

class BookController {


    def createABook(){
        def book = new Book(title: "Book", author: "Author")
        book.save()

        redirect(actionName: "index")
        return
    }



    def index() {

        def books = Book.list()

        [books: books]

    }
}
