package grails4

import grails.gorm.transactions.Transactional
import org.springframework.security.access.prepost.PreAuthorize

@Transactional
class BookService {

    @PreAuthorize('hasPermission(#id, "grails4.Book", read)')
    def get(Long id) {

        def book = Book.get(id)

        return book

    }
}
