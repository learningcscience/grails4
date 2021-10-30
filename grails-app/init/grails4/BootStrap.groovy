package grails4
import grails.gorm.transactions.Transactional

class BootStrap {



    def init = {
        addTestUser()
    }

    @Transactional
    void addTestUser() {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def testUser = new User(username: 'admin', password: 'admin123').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }


        def roleUser = new Role(authority: 'ROLE_USER').save()

        def user1 = new User(username:  "user1", password:  "password1").save()
        UserRole.create user1, roleUser

        def user2 = new User(username:  "user2", password:  "password2").save()
        UserRole.create user2, roleUser

        def user3 = new User(username:  "user3", password:  "password3").save()
        UserRole.create user3, roleUser


    }
}