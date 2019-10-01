package user.service.controller

import com.google.gson.Gson
import com.google.gson.JsonParser
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import user.service.model.UserModel
import user.service.model.UserResponseModel
import user.service.service.UserService

@Controller("/users")
class User {

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun index(): String {
        return try {
            val users = UserService.all()

            val response = UserResponseModel("ok", users)

            Gson().toJson(response)
        } catch (e: Exception) {
            e.message.toString()
        }

    }

    @Get("/{id}")
    fun show(@QueryValue("id") id: Int): MutableHttpResponse<String> {
        try {
            val user = UserService.findById(id)

            if (user != null) {
                val response = UserResponseModel("ok", user)
                return HttpResponse.ok(Gson().toJson(response))
            }

            return HttpResponse.notFound("Not Found")
        } catch (e: Exception) {
            return HttpResponse.badRequest("Bad Request")
        }

    }

    @Post(produces = [MediaType.APPLICATION_JSON], consumes = [MediaType.APPLICATION_JSON])
    fun store(@Body userdata: String): MutableHttpResponse<String> {
        try {
            val data = JsonParser().parse(userdata).asJsonObject
            val email = data.get("email").asString
            val name = data.get("name").asString

            val store = UserService.store(email, name)

            if (store != 0) {
                val response = UserResponseModel(store.toString(), UserModel(store, email, name))
                return HttpResponse.ok(Gson().toJson(response))
            }

            return HttpResponse.badRequest("Bad Request")
        } catch (e: Exception) {
            e.printStackTrace()
            return HttpResponse.badRequest(e.toString())
        }
    }
}
