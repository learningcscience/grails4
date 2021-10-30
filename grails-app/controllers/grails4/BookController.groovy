package grails4

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder as SCH
import static org.springframework.security.acls.domain.BasePermission.READ



@Secured('ROLE_USER')
class BookController {

    def aclService
    def objectIdentityRetrievalStrategy

    def aclUtilService


    def bookService


    @Secured('ROLE_ADMIN')
    def createABook(){
        def book = new Book(title: "Book", author: "Author")
        book.save()

        redirect(actionName: "index")
        return
    }


    def show(Long id){


        def book = bookService.get(id)
        render "Book name is " + book.title

    }


    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def createPermission() {

        SCH.context.authentication = new UsernamePasswordAuthenticationToken(
                'admin', 'admin123',
                AuthorityUtils.createAuthorityList('ROLE_ADMIN'))


        def book = Book.last()

        aclService.createAcl(objectIdentityRetrievalStrategy.getObjectIdentity(book))

        aclUtilService.addPermission book, 'user1', READ



        SCH.clearContext()




        render "done"



    }




    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def index() {

        def books = Book.list()

        [books: books]

    }
}
