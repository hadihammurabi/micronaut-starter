package user.service.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.MediaType

@Controller("/")
class Index {

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "halo semuanya"
    }

}
