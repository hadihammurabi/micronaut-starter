package user.service.controller;

import java.util.ArrayList;
import com.google.gson.Gson;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.MediaType;
import user.service.service.UserService;
import user.service.model.UserModel;
import user.service.model.UserResponseModel;

import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Body;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.HttpStatus;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller("/users")
public class User {

  @Get(produces=MediaType.APPLICATION_JSON)
  public String index() {
    try {
      ArrayList<UserModel> users = UserService.all();

      UserResponseModel response = new UserResponseModel("ok", users);

      return new Gson().toJson(response);
    } catch(Exception e) {
      return e.getMessage();
    }
  }

  @Get("/{id}")
  public MutableHttpResponse<String> show(@QueryValue("id") int id) {
    try {
      UserModel user = UserService.findById(id);

      if (user != null) {
        UserResponseModel response = new UserResponseModel("ok", user);
        return HttpResponse.ok(new Gson().toJson(response));
      }

      return HttpResponse.notFound("Not Found");
    } catch(Exception e) {
      return HttpResponse.badRequest("Bad Request");
    }
  }

  @Post(produces=MediaType.APPLICATION_JSON, consumes=MediaType.APPLICATION_JSON)
  public MutableHttpResponse<String> store(@Body String userdata) {
    try {
      JsonObject data = new JsonParser().parse(userdata).getAsJsonObject();
      String email = data.get("email").getAsString();
      String name = data.get("name").getAsString();

      int store = UserService.store(email, name);

      if (store != 0) {
        UserResponseModel response = new UserResponseModel(Integer.toString(store), new UserModel(store, email, name));
        return HttpResponse.ok(new Gson().toJson(response));
      }

      return HttpResponse.badRequest("Bad Request");
    } catch(Exception e) {
      e.printStackTrace();
      return HttpResponse.badRequest(e.toString());
    }
  }

}
