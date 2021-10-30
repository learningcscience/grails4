package grails4
import org.springframework.security.access.AccessDeniedException

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(controller: 'errors', action: 'error403',
                exception: AccessDeniedException)

        "404"(view:'/notFound')
    }
}
