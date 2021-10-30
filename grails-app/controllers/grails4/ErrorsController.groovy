package grails4

import grails.plugin.springsecurity.annotation.Secured



@Secured('permitAll')
class ErrorsController {

    def error403() {

        render "Access Denied"

    }
}
